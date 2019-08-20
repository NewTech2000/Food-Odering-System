package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.UserAccountBO;
import lk.ijse.dinamore.business.custom.impl.UserAccountBOImpl;
import lk.ijse.dinemore.common.dto.UserAccountDTO;
import lk.ijse.dinemore.common.service.custom.UserAccountService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserAccountServiceServiceImpl extends UnicastRemoteObject implements UserAccountService {

    private UserAccountBO userAccountBO;
    public UserAccountServiceServiceImpl()throws RemoteException {
        userAccountBO=new UserAccountBOImpl();

    }
    @Override
    public boolean save(UserAccountDTO userAccountDTO) throws Exception {
        return userAccountBO.saveUser(userAccountDTO);
    }
}
