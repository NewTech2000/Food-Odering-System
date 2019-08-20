package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.OrderDetailsBO;
import lk.ijse.dinamore.business.custom.impl.OrderDetailsBOImpl;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;
import lk.ijse.dinemore.common.service.custom.OrderDetailsService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderDetailsServiceImpl extends UnicastRemoteObject implements OrderDetailsService {

    private OrderDetailsBO orderDetailsBO;

    public OrderDetailsServiceImpl()throws RemoteException {
        orderDetailsBO=new OrderDetailsBOImpl();
    }


    @Override
    public OrderDetailsDTO searchByOrderId(Integer id) throws Exception {
        return orderDetailsBO.searchOrderDetail(id);
    }
}
