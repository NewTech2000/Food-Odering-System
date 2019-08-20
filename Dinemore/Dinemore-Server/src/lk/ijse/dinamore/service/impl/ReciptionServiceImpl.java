package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.ReciptionBO;
import lk.ijse.dinamore.business.custom.impl.ReciptionBOImpl;
import lk.ijse.dinemore.common.dto.ReciptionDTO;
import lk.ijse.dinemore.common.service.custom.ReciptionService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReciptionServiceImpl extends UnicastRemoteObject implements ReciptionService {

    public ReciptionBO reciptionBO;

    public ReciptionServiceImpl()throws RemoteException {
        reciptionBO = new ReciptionBOImpl();
    }

    @Override
    public boolean saveReciption(ReciptionDTO reciptionDTO) throws Exception {
        return reciptionBO.saveReception(reciptionDTO);
    }

    @Override
    public boolean updateReciption(ReciptionDTO reciptionDTO) throws Exception {
        return reciptionBO.updateReciption(reciptionDTO);
    }

    @Override
    public boolean deleteReciption(int id) throws Exception {
        return reciptionBO.deleteReciption(id);
    }

    @Override
    public ReciptionDTO searchReciption(int id) throws Exception {
        return reciptionBO.searchReciption(id);
    }

    @Override
    public ArrayList<ReciptionDTO> getAllReciptions() throws Exception {
        return reciptionBO.getAllReciptions();
    }
}
