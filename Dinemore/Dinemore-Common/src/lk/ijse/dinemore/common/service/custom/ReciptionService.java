package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.ReciptionDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface ReciptionService extends Remote {
    public boolean saveReciption(ReciptionDTO reciptionDTO)throws Exception;

    public boolean updateReciption(ReciptionDTO reciptionDTO)throws Exception;

    public boolean deleteReciption(int id)throws Exception;

    public ReciptionDTO searchReciption(int id)throws Exception;

    public ArrayList<ReciptionDTO> getAllReciptions()throws Exception;
}
