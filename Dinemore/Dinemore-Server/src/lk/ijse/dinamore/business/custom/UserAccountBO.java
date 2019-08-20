package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.UserAccountDTO;

public interface UserAccountBO extends SuperBO {

    public boolean saveUser(UserAccountDTO userAccountDTO)throws Exception;

}
