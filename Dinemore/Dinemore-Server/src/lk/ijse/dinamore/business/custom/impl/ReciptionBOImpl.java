package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.ReciptionBO;
import lk.ijse.dinamore.dao.custom.ReciptionDAO;
import lk.ijse.dinamore.dao.custom.impl.ReciptionDAOImpl;
import lk.ijse.dinamore.entity.Reciption;
import lk.ijse.dinemore.common.dto.ReciptionDTO;

import java.util.ArrayList;
import java.util.List;

public class ReciptionBOImpl implements ReciptionBO {

    private ReciptionDAO reciptionDAO;
    public ReciptionBOImpl(){
        reciptionDAO=new ReciptionDAOImpl();
    }

    @Override
    public boolean saveReception(ReciptionDTO reciptionDTO) throws Exception {
        return reciptionDAO.Save(new Reciption(reciptionDTO.getReciption_id(),reciptionDTO.getReciption_name(),reciptionDTO.getReciption_address(),reciptionDTO.getReciption_nic(),reciptionDTO.getReciption_mobile()));
    }

    @Override
    public boolean updateReciption(ReciptionDTO reciptionDTO) throws Exception {
        return reciptionDAO.Update(new Reciption(reciptionDTO.getReciption_id(),reciptionDTO.getReciption_name(),reciptionDTO.getReciption_address(),reciptionDTO.getReciption_nic(),reciptionDTO.getReciption_mobile()));
    }

    @Override
    public boolean deleteReciption(int id) throws Exception {
        return reciptionDAO.delete(id);
    }

    @Override
    public ReciptionDTO searchReciption(int id) throws Exception {
        Reciption reciption=reciptionDAO.Search(id);
        if(reciption!=null){

            return new ReciptionDTO(reciption.getReciption_id(),reciption.getReciption_name(reciption),reciption.getReciption_address(),reciption.getReciption_Nic(),reciption.getReciption_mobile());

        }
        return null;

    }

    @Override
    public ArrayList<ReciptionDTO> getAllReciptions() throws Exception {
        List <Reciption> reciptions=reciptionDAO.getAll();
        ArrayList<ReciptionDTO> reciptionDTOS =new ArrayList <>();
        for (Reciption reciption : reciptions){
            reciptionDTOS.add(new ReciptionDTO(reciption.getReciption_id(),reciption.getReciption_name(),reciption.getReciption_address(),reciption.getReciption_Nic(),reciption.getReciption_mobile()));
        }
        return reciptionDTOS;
    }
}
