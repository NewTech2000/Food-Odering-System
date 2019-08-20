package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.ReciptionDTO;

import java.util.ArrayList;

public interface ReciptionBO extends SuperBO {

    public boolean saveReception(ReciptionDTO reciptionDTO)throws Exception;

    public boolean updateReciption(ReciptionDTO reciptionDTO)throws Exception;

    public boolean deleteReciption(int id)throws Exception;

    public ReciptionDTO searchReciption(int id)throws Exception;

    public ArrayList<ReciptionDTO> getAllReciptions()throws Exception;

}
