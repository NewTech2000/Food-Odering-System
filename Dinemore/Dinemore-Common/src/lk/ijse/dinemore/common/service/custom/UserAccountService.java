package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.UserAccountDTO;

import java.rmi.Remote;

public interface UserAccountService extends Remote {
    public boolean save(UserAccountDTO userAccountDTO)throws Exception;
}
