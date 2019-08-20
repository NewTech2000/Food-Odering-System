package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.custom.OrderDetailDAO;
import lk.ijse.dinamore.entity.OrderDetails;
import lk.ijse.dinamore.entity.Orders;
import lk.ijse.dinamore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailDAO {

    private SessionFactory sessionFactory;

    public OrderDetailsDAOImpl(){
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(OrderDetails entity) throws Exception {
        return false;
    }

    @Override
    public boolean Update(OrderDetails entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        return false;
    }

    @Override
    public OrderDetails Search(Integer integer) throws Exception {
        OrderDetails orders=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            orders=session.get(OrderDetails.class,orders);

            session.getTransaction().commit();
        }
        return orders;


    }

    @Override
    public List<OrderDetails> getAll() throws Exception {
        return null;
    }

    @Override
    public List <OrderDetails> getAllThree() throws Exception {
        return null;
    }


}
