package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.OrderDetailsBO;
import lk.ijse.dinamore.dao.CrudUtil;
import lk.ijse.dinamore.dao.custom.OrderDetailDAO;
import lk.ijse.dinamore.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.dinamore.entity.OrderDetails;
import lk.ijse.dinamore.util.HibernateUtil;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.ResultSet;

public class OrderDetailsBOImpl implements OrderDetailsBO {

    private SessionFactory sessionFactory;
    private OrderDetailDAO orderDetailDAO;

    public OrderDetailsBOImpl()
    {
        sessionFactory= HibernateUtil.getSessionFactory();
        orderDetailDAO=new OrderDetailsDAOImpl();
    }


    @Override
    public OrderDetailsDTO searchOrderDetail(Integer id) throws Exception {
        OrderDetails orderDetails =orderDetailDAO.Search(id);
        if(orderDetails!=null){
            return new OrderDetailsDTO(orderDetails.getOrders().getOrderid(),orderDetails.getMenu().getId());
        }
        return null;
    }
}
