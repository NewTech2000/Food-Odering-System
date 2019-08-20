package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.CustomerDTO;
import lk.ijse.dinemore.common.dto.DeliveryTableDTO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;

import java.util.ArrayList;

public interface OrderBO extends SuperBO {

    public boolean saveOrder(OrderDTO orderDTO)throws Exception;

    public OrderDTO serachOrder(Integer id)throws Exception;

    public ArrayList <OrderDTO> getAllAvailableOrder()throws Exception;

    public ArrayList<DeliveryTableDTO> getAllDeliveries()throws Exception;

    public OrderDetailsDTO searchOrders(Integer id)throws Exception;

    public ArrayList<OrderDTO> getAllCookedOrders()throws Exception;

    public CustomerDTO searchCustomerByOrder(Integer id)throws Exception;

    public boolean Cooking(OrderDTO orderDTO)throws Exception;

    public boolean Cooked(OrderDTO orderDTO)throws Exception;

    public boolean Delivering(OrderDTO orderDTO)throws Exception;

    public boolean Delivered(OrderDTO orderDTO)throws Exception;

    public ArrayList<OrderDTO> getAllOrders()throws Exception;









}
