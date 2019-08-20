package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.ChefDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ChefService extends Remote {

    public boolean saveChef(ChefDTO chefDTO)throws Exception;

    public boolean updateChef(ChefDTO chefDTO)throws Exception;

    public boolean deleteChef(String id)throws Exception;

    public ChefDTO searchChef(String id)throws Exception;

    public ArrayList<ChefDTO> getAllChefs()throws Exception;
}
