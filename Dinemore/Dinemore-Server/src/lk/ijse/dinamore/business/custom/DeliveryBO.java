package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.DeliveryDTO;

import java.util.ArrayList;

public interface DeliveryBO extends SuperBO {

    public boolean saveDelivery(DeliveryDTO deliveryDTO)throws Exception;

    public boolean updateDelivery(DeliveryDTO deliveryDTO)throws Exception;

    public boolean deleteDelivery(String id)throws Exception;

    public DeliveryDTO searchDelivery(String id)throws Exception;

    public ArrayList<DeliveryDTO> getAllDeliveries()throws Exception;
}
