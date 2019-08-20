package lk.ijse.dinamore.business.custom;

import lk.ijse.dinamore.business.SuperBO;
import lk.ijse.dinemore.common.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean saveCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean deleteCustomer(Integer id)throws Exception;

    public CustomerDTO searchCustomer(Integer id)throws Exception;

    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;

    public CustomerDTO searchNNic(String nic)throws Exception;
}
