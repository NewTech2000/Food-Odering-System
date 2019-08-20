package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.ChefBO;
import lk.ijse.dinamore.business.custom.impl.ChefBOImpl;
import lk.ijse.dinamore.dao.custom.ChefDAO;
import lk.ijse.dinemore.common.dto.ChefDTO;
import lk.ijse.dinemore.common.service.custom.ChefService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChefServiceImpl extends UnicastRemoteObject implements ChefService {

    private ChefBO chefBO;
    public ChefServiceImpl()throws RemoteException {
        chefBO=new ChefBOImpl();
    }

    @Override
    public boolean saveChef(ChefDTO chefDTO) throws Exception {
        return chefBO.saveChef(chefDTO);
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        return chefBO.updateChef(chefDTO);
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return chefBO.deleteChef(id);
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        return chefBO.searchChef(id);
    }

    @Override
    public ArrayList<ChefDTO> getAllChefs() throws Exception {
        return chefBO.getAllChefs();
    }
}
