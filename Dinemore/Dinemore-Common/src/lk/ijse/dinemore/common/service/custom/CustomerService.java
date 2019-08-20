package lk.ijse.dinemore.common.service.custom;

import lk.ijse.dinemore.common.dto.CustomerDTO;

import java.rmi.Remote;
import java.util.ArrayList;

public interface CustomerService extends Remote {
    public boolean saveCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean deleteCustomer(Integer id)throws Exception;

    public CustomerDTO searchCustomer(Integer id)throws Exception;

    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;

    public CustomerDTO searchByNIC(String nic)throws Exception;

}
