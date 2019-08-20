package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.OrderDetailsDTO;

import java.rmi.Remote;

public interface OrderDetailsService extends Remote {

    public OrderDetailsDTO searchByOrderId(Integer id)throws Exception;



}
