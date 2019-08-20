package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.CrudUtil;
import lk.ijse.dinamore.dao.custom.OrderDAO;
import lk.ijse.dinamore.entity.*;
import lk.ijse.dinamore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private SessionFactory sessionFactory;

    public OrderDAOImpl(){
        sessionFactory=HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(Orders orders) throws Exception {

       return false;
    }

    @Override
    public boolean Update(Orders entity) throws Exception {
        return CrudUtil.executeUpdate("update Orders set delivery_delivery_id=?,status=? where orderid=? " ,entity.getDelivery().getDeliveryid(),entity.getStatus(),entity.getOrderid())>0;


    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }

    @Override
    public Orders Search(Integer integer) throws Exception {
        Orders orders=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            orders=session.get(Orders.class,integer);

            session.getTransaction().commit();
        }
        return orders;
    }

    @Override
    public List<Orders> getAll() throws Exception {
        ArrayList<Orders> orders=new ArrayList<>();
        ResultSet rst= CrudUtil.executeQuery(" select orderid,orderdate,orderTime,status,qty from Orders where status=? ","Placed order");
        while(rst.next()){
            orders.add(new Orders(rst.getInt("orderid"),
                    rst.getString("orderdate"),
                    rst.getString("orderTime"),
                    rst.getString("status"),
                    rst.getInt("qty")));

        }
        return orders;

    }

    @Override
    public List <Orders> getAllThree() throws Exception {
        ArrayList <Orders> orders = new ArrayList <>();
        ResultSet rst = CrudUtil.executeQuery(" select orderid , qty , price , status  from orders where status='Cooked'");
        while (rst.next()) {
            orders.add(new Orders(rst.getInt(1),
                    rst.getInt(2),
                    rst.getDouble(3),
                    rst.getString(4)));
        }
        return orders;
    }

    @Override
    public boolean updateLastDelivery(Orders entity) throws Exception {
//        return CrudUtil.executeUpdate("update Orders set delivery_delivery_id=?,status=? ,payment_Status=?, endDeliver=? where orderid=? " ,entity.getDelivery().getDeliveryid(),entity.getStatus(),entity.getOrderid(),entity.getStatus(),entity.getPayment_Status(),entity.getEndDeliver())>0;
        return false;
    }

    @Override
    public ArrayList <Orders> getAllOrders() throws Exception {
        ArrayList<Orders> alOrders=new ArrayList <>();
        ResultSet set =CrudUtil.executeQuery("select orderid , customer_customerId , qty,orderdate ,  price ,  menu_food_id from orders o, Orderdetails od where  o.orderid=od. orders_orderid");
        while (set.next()){
            alOrders.add(new Orders(set.getInt(1),
                    set.getInt(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getDouble(5),
                    set.getInt(6)));
        }
        return alOrders;
    }
}
