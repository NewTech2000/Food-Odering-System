package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.ChefDTO;

import java.util.ArrayList;

public interface ChefBO extends SuperBO {

    public boolean saveChef(ChefDTO chefDTO)throws Exception;

    public boolean updateChef(ChefDTO chefDTO)throws Exception;

    public boolean deleteChef(String id)throws Exception;

    public ChefDTO searchChef(String id)throws Exception;

    public ArrayList<ChefDTO> getAllChefs()throws Exception;
}
