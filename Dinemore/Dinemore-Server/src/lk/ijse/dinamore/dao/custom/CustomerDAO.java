package lk.ijse.dinamore.dao.custom;

import lk.ijse.dinamore.dao.CrudDAO;
import lk.ijse.dinamore.entity.Customer;
import lk.ijse.dinemore.common.dto.CustomerDTO;

public interface CustomerDAO extends CrudDAO<Customer , Integer> {

    public Customer searchNIC(String nic)throws Exception;
}
