package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.CustomerBO;
import lk.ijse.dinamore.business.custom.OrderBO;
import lk.ijse.dinamore.dao.CrudUtil;
import lk.ijse.dinamore.dao.custom.OrderDAO;
import lk.ijse.dinamore.dao.custom.impl.OrderDAOImpl;
import lk.ijse.dinamore.entity.*;
import lk.ijse.dinamore.util.HibernateUtil;
import lk.ijse.dinemore.common.dto.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO;
    private CustomerBO customerBO;

    private SessionFactory sessionFactory;

    public OrderBOImpl(){
        customerBO=new CustomerBOImpl();
        orderDAO=new OrderDAOImpl();
        sessionFactory= HibernateUtil.getSessionFactory();
    }



    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws Exception {

        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Customer customer=new Customer();

            customer.setCustomerId(orderDTO.getCustomerDTO().getCustomerId());
            customer.setCustomerName(orderDTO.getCustomerDTO().getCustomerName());
            customer.setCustomerAddress(orderDTO.getCustomerDTO().getCustomerAddress());
            customer.setCustomerNic(orderDTO.getCustomerDTO().getCustomerNic());
            customer.setCustomerMobile(orderDTO.getCustomerDTO().getCustomerMobile());

            Reciption reception = session.get(Reciption.class, orderDTO.getReciptionId());
//            Chef chef =session.get(Chef.class,"0000");
//            Delivery delivery =session.get(Delivery.class,"0000");
//
            Chef chef=new Chef();
            chef.setChef_id("No Id");
            chef=session.get(Chef.class,"No Id");

            Delivery delivery=new Delivery();
            delivery.setDeliveryid("No Id");
            delivery=session.get(Delivery.class,"No Id");




            Orders orders=new Orders();
            orders.setOrderid(orderDTO.getOrderid());
            orders.setOrderdate(orderDTO.getOrderdate());
            orders.setQty(orderDTO.getQty());
            orders.setPrice(orderDTO.getPrice());
            orders.setStatus(orderDTO.getStatus());
            orders.setOrderTime(orderDTO.getOrderTime());
            orders.setCustomer(customer);
            orders.setReciption(reception);
            orders.setChef(chef);
            orders.setDelivery(delivery);
            session.persist(orders);


            List<OrderDetails>orderDetails=new ArrayList <>();
                for (OrderDetailsDTO orderDetailsDTO : orderDTO.getOrderDetailsDTOS()){
                Menu menu1 = session.get(Menu.class, orderDetailsDTO.getFoodid());


                OrderDetails orderDetails1=new OrderDetails();
                orderDetails1.setOrderd_qty(orderDetailsDTO.getOrderd_qty());
                orderDetails1.setOrdered_price(orderDetailsDTO.getOrdered_price());
                orderDetails1.setMenu(menu1);
                orderDetails1.setOrders(orders);

                session.persist(orderDetails1);


            }

            session.getTransaction().commit();
            return true;
        }


    }



    @Override
    public OrderDTO serachOrder(Integer id) throws Exception {
        Orders orders=orderDAO.Search(id);
        if(orders!=null){
            return new OrderDTO(orders.getOrderid(),orders.getStatus());

        }
        return null;
    }



    @Override
    public ArrayList <OrderDTO> getAllAvailableOrder() throws Exception {
       List<Orders> orders=orderDAO.getAll();
       ArrayList<OrderDTO> orderDTOS=new ArrayList <>();
       for (Orders ods:orders){
           orderDTOS.add(new OrderDTO(ods.getOrderid(),ods.getOrderdate(),ods.getOrderTime(),ods.getStatus(),ods.getQty()));
       }
       return orderDTOS;
    }



    @Override
    public ArrayList <DeliveryTableDTO> getAllDeliveries() throws Exception {
        return null;
    }

    @Override
    public OrderDetailsDTO searchOrders(Integer id) throws Exception {
//        OrderDetailsDTO orderDetails=null;
//        try(Session session=sessionFactory.openSession()){
//            session.getTransaction().begin();
//
//            orderDetails=session.get(OrderDetailsDTO.class,id);
//
//            session.getTransaction().commit();
//        }catch (HibernateException ex){
//
//        }
//        return orderDetails;
        return null;
    }

    @Override
    public ArrayList <OrderDTO> getAllCookedOrders() throws Exception {
        List<Orders> orders=orderDAO.getAllThree();
        ArrayList<OrderDTO> orderDTOS=new ArrayList <>();
        for (Orders ods:orders){
            orderDTOS.add(new OrderDTO(ods.getOrderid(),ods.getQty(),ods.getPrice(),ods.getStatus()));
        }
        return orderDTOS;
    }

    @Override
    public CustomerDTO searchCustomerByOrder(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select customerid,customeraddress,customermobile,customername,customernic from Customer c,Orders o where c.customerid=o.customer_customerId and o.orderid=? ", id);
        if(rst.next()){
            return new CustomerDTO(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getInt(5));
        }else{
            return null;
        }
    }

    @Override
    public boolean Cooking(OrderDTO orderDTO) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Orders orders = session.get(Orders.class, orderDTO.getOrderid());
            orders.setStatus(orderDTO.getStatus());
            orders.setStartCooking(orderDTO.getStartCooking());
            Chef chef = new Chef();
            chef.setChef_id(orderDTO.getChefId());
            orders.setChef(chef);

            System.out.println(orderDTO.getChefId());

            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean Cooked(OrderDTO orderDTO) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Orders orders = session.get(Orders.class, orderDTO.getOrderid());
            orders.setStatus(orderDTO.getStatus());
            orders.setEndCooking(orderDTO.getEndCooking());
            Chef chef = new Chef();
            chef.setChef_id(orderDTO.getChefId());
            orders.setChef(chef);

            System.out.println(orderDTO.getChefId());

            System.out.println("Cooking "+orderDTO.getChefId());
            System.out.println("Cooking "+orderDTO.getEndCooking());



            session.getTransaction().commit();
        }
        return true;

    }

    @Override
    public boolean Delivering(OrderDTO orderDTO) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Orders orders = session.get(Orders.class, orderDTO.getOrderid());
            orders.setStatus(orderDTO.getStatus());
            orders.setStartDeliver(orderDTO.getStartDeliver());
            Delivery delivery = new Delivery();
            delivery.setDeliveryid(orderDTO.getDeliveryID());
            orders.setDelivery(delivery);

            System.out.println(orderDTO.getDeliveryID());
            System.out.println(orderDTO.getStartDeliver());


            session.getTransaction().commit();
        }
        return true;

    }

    @Override
    public boolean Delivered(OrderDTO orderDTO) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Orders orders = session.get(Orders.class, orderDTO.getOrderid());
            orders.setStatus(orderDTO.getStatus());
            orders.setEndDeliver(orderDTO.getEndDeliver());
            orders.setPayment_Status(orderDTO.getPayment_Status());
            Delivery delivery = new Delivery();
            delivery.setDeliveryid(orderDTO.getDeliveryID());
            orders.setDelivery(delivery);

            System.out.println(orderDTO.getChefId());

            System.out.println("Del "+orderDTO.getDeliveryID());
            System.out.println("Del "+orderDTO.getEndDeliver());



            session.getTransaction().commit();
        }
        return true;

    }

    @Override
    public ArrayList <OrderDTO> getAllOrders() throws Exception {
        return null;
    }




}
