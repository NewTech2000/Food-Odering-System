package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.DeliveryDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface DeliveryService extends Remote {

    public boolean saveDelivery(DeliveryDTO deliveryDTO)throws Exception;

    public boolean updateDelivery(DeliveryDTO deliveryDTO)throws Exception;

    public boolean deleteDelivery(String id)throws Exception;

    public DeliveryDTO searchDelivery(String id)throws Exception;

    public ArrayList<DeliveryDTO> getAllDeliveries()throws Exception;
 }
