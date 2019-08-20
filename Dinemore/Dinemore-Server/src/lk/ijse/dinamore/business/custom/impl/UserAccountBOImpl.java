package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.UserAccountBO;
import lk.ijse.dinamore.dao.custom.UserAccountDAO;
import lk.ijse.dinamore.dao.custom.impl.UserAccountDAOImpl;
import lk.ijse.dinamore.entity.UserAccount;
import lk.ijse.dinemore.common.dto.UserAccountDTO;

public class UserAccountBOImpl implements UserAccountBO {

    private UserAccountDAO userAccountDAO;
    public UserAccountBOImpl(){
        userAccountDAO= new UserAccountDAOImpl();
    }

    @Override
    public boolean saveUser(UserAccountDTO userAccountDTO) throws Exception {
        return userAccountDAO.Save(new UserAccount(userAccountDTO.getUsername(),userAccountDTO.getPassword(),userAccountDTO.getConfrimpassword()));

    }
}
