package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.OrderBO;
import lk.ijse.dinamore.business.custom.impl.OrderBOImpl;
import lk.ijse.dinemore.common.dto.CustomerDTO;
import lk.ijse.dinemore.common.dto.DeliveryTableDTO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;
import lk.ijse.dinemore.common.service.custom.OrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {

    private OrderBO orderBO;

    public OrderServiceImpl()throws RemoteException {
        orderBO=new OrderBOImpl();
    }

    @Override
    public boolean save(OrderDTO orderDTO) throws Exception {
        return orderBO.saveOrder(orderDTO);
    }

    @Override
    public ArrayList <OrderDTO> getAllOrders() throws Exception {
        return orderBO.getAllOrders();
    }


    @Override
    public OrderDTO searchOrder(Integer id) throws Exception {
        return orderBO.serachOrder(id);
    }

    @Override
    public ArrayList <OrderDTO> getAllAvailableOrders() throws Exception {
        ArrayList<OrderDTO> allAvailableOrder = orderBO.getAllAvailableOrder();
        return allAvailableOrder;
    }

    @Override
    public ArrayList <DeliveryTableDTO> getAllDeliveries() throws Exception {
        return orderBO.getAllDeliveries();
    }



    @Override
    public ArrayList <OrderDTO> getAllCookedOrders() throws Exception {
        return orderBO.getAllCookedOrders();
    }

    @Override
    public CustomerDTO searchCustomerByOrder(Integer id) throws Exception {
        return orderBO.searchCustomerByOrder(id);
    }

    @Override
    public boolean CookingUpdate(OrderDTO orderDTO) throws Exception {
        return orderBO.Cooking(orderDTO);
    }

    @Override
    public boolean CookingFinished(OrderDTO orderDTO) throws Exception {
        return orderBO.Cooked(orderDTO);
    }

    @Override
    public boolean DeliveryUpdate(OrderDTO orderDTO) throws Exception {
        return orderBO.Delivering(orderDTO);
    }

    @Override
    public boolean DeliveryFinished(OrderDTO orderDTO) throws Exception {
        return orderBO.Delivered(orderDTO);
    }


}
