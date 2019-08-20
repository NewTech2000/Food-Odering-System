package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.DeliveryBO;
import lk.ijse.dinamore.business.custom.impl.DeliveryBOImpl;
import lk.ijse.dinemore.common.dto.DeliveryDTO;
import lk.ijse.dinemore.common.service.custom.DeliveryService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeliveryServiceImpl extends UnicastRemoteObject implements DeliveryService {

    public DeliveryBO deliveryBO;

    public DeliveryServiceImpl()throws RemoteException {
        deliveryBO=new DeliveryBOImpl();

    }

    @Override
    public boolean saveDelivery(DeliveryDTO deliveryDTO) throws Exception {
        return deliveryBO.saveDelivery(deliveryDTO);
    }

    @Override
    public boolean updateDelivery(DeliveryDTO deliveryDTO) throws Exception {
        return deliveryBO.updateDelivery(deliveryDTO);
    }

    @Override
    public boolean deleteDelivery(String id) throws Exception {
        return deliveryBO.deleteDelivery(id);
    }

    @Override
    public DeliveryDTO searchDelivery(String id) throws Exception {
        return deliveryBO.searchDelivery(id);
    }

    @Override
    public ArrayList<DeliveryDTO> getAllDeliveries() throws Exception {
        return deliveryBO.getAllDeliveries();
    }
}
