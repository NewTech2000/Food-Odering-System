package lk.ijse.dinamore.dao.custom;

import lk.ijse.dinamore.dao.CrudDAO;
import lk.ijse.dinamore.entity.Orders;

import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<Orders , Integer> {
    public boolean updateLastDelivery(Orders entity)throws Exception;

    public ArrayList <Orders> getAllOrders()throws Exception;

}
