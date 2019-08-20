package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.DeliveryBO;
import lk.ijse.dinamore.dao.custom.DeliveryDAO;
import lk.ijse.dinamore.dao.custom.impl.DeliveryDAOImpl;
import lk.ijse.dinamore.entity.Delivery;
import lk.ijse.dinemore.common.dto.DeliveryDTO;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {

    private DeliveryDAO deliveryDAO;
    public DeliveryBOImpl(){
        deliveryDAO=new DeliveryDAOImpl();
    }

    @Override
    public boolean saveDelivery(DeliveryDTO deliveryDTO) throws Exception {
        return deliveryDAO.Save(new Delivery(deliveryDTO.getDelivery_id(),deliveryDTO.getName(),deliveryDTO.getDel_Nic(),deliveryDTO.getAddress(),deliveryDTO.getMobileNo(),deliveryDTO.getBikeNo()));
    }

    @Override
    public boolean updateDelivery(DeliveryDTO deliveryDTO) throws Exception {
        return deliveryDAO.Update(new Delivery(deliveryDTO.getDelivery_id(),deliveryDTO.getName(),deliveryDTO.getDel_Nic(),deliveryDTO.getAddress(),deliveryDTO.getMobileNo(),deliveryDTO.getBikeNo()));
    }

    @Override
    public boolean deleteDelivery(String id) throws Exception {
        return deliveryDAO.delete(id);
    }

    @Override
    public DeliveryDTO searchDelivery(String id) throws Exception {
        Delivery delivery =deliveryDAO.Search(id);
        if(delivery!=null){
            return new DeliveryDTO(delivery.getDeliveryid(),delivery.getName(),delivery.getDelNic(),delivery.getAddress(),delivery.getMobileNo(),delivery.getBikeNo());

       }
       return null;
    }

    @Override
    public ArrayList<DeliveryDTO> getAllDeliveries() throws Exception {
        List<Delivery> deliveryList = deliveryDAO.getAll();
        ArrayList<DeliveryDTO> deliveryDTOS = new ArrayList <>();
        for(Delivery delivery : deliveryList){
            deliveryDTOS.add(new DeliveryDTO(delivery.getDeliveryid(),delivery.getName(),delivery.getDelNic(),delivery.getAddress(),delivery.getMobileNo(),delivery.getBikeNo()));
        }
        return deliveryDTOS;
    }
}
