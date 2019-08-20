package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.ChefBO;
import lk.ijse.dinamore.dao.custom.ChefDAO;
import lk.ijse.dinamore.dao.custom.MenuDAO;
import lk.ijse.dinamore.dao.custom.impl.ChefDAOImpl;
import lk.ijse.dinamore.dao.custom.impl.MenuDAOImpl;
import lk.ijse.dinamore.entity.Chef;
import lk.ijse.dinemore.common.dto.ChefDTO;

import java.util.ArrayList;
import java.util.List;

public class ChefBOImpl implements ChefBO {

    private ChefDAO chefDAO;
    public ChefBOImpl(){
        chefDAO=new ChefDAOImpl();
    }

    @Override
    public boolean saveChef(ChefDTO chefDTO) throws Exception {
        return chefDAO.Save(new Chef(chefDTO.getChef_id(),chefDTO.getChef_name(),chefDTO.getChef_address(),chefDTO.getChef_mobile(),chefDTO.getChef_Nic()));
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        return chefDAO.Update(new Chef(chefDTO.getChef_id(),chefDTO.getChef_name(),chefDTO.getChef_address(),chefDTO.getChef_mobile(),chefDTO.getChef_Nic()));
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        return (boolean) chefDAO.delete(id);
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        Chef chef =chefDAO.Search(id);
        if(chef!=null){
            return new ChefDTO(chef.getChef_id(),chef.getChef_name(),chef.getChef_address(),chef.getChef_mobile(),chef.getChef_Nic());
        }
        return null;
    }

    @Override
    public ArrayList<ChefDTO> getAllChefs() throws Exception {
        List<Chef> chefList =chefDAO.getAll();
        ArrayList<ChefDTO> chefDTOS = new ArrayList <>();
        for (Chef chef : chefList){
            chefDTOS.add(new ChefDTO(chef.getChef_id(),chef.getChef_name(),chef.getChef_address(),chef.getChef_mobile(),chef.getChef_Nic()));

        }
        return chefDTOS;
    }
}
