package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.OrderDetailsDTO;

public interface OrderDetailsBO extends SuperBO {

    public OrderDetailsDTO searchOrderDetail(Integer id)throws Exception;


}
