package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.CustomerDTO;
import lk.ijse.dinemore.common.dto.DeliveryTableDTO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface OrderService extends Remote {
    public boolean save(OrderDTO orderDTO)throws Exception;

    public ArrayList<OrderDTO> getAllOrders()throws Exception;

    public OrderDTO searchOrder(Integer id)throws Exception;

    public ArrayList<OrderDTO> getAllAvailableOrders()throws Exception;

    public ArrayList<DeliveryTableDTO> getAllDeliveries()throws Exception;

    public ArrayList<OrderDTO> getAllCookedOrders()throws Exception;

    public CustomerDTO searchCustomerByOrder(Integer id)throws Exception;

    public boolean CookingUpdate(OrderDTO orderDTO)throws Exception;

    public boolean CookingFinished(OrderDTO orderDTO)throws Exception;

    public boolean DeliveryUpdate(OrderDTO orderDTO)throws Exception;

    public boolean DeliveryFinished(OrderDTO orderDTO)throws Exception;


}
