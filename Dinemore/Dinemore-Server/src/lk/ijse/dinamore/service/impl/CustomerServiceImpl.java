package lk.ijse.dinamore.service.impl;

import lk.ijse.dinamore.business.custom.CustomerBO;
import lk.ijse.dinamore.business.custom.impl.CustomerBOImpl;
import lk.ijse.dinemore.common.dto.CustomerDTO;
import lk.ijse.dinemore.common.service.custom.CustomerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    private CustomerBO customerBO;

    public CustomerServiceImpl()throws RemoteException {
        customerBO=new CustomerBOImpl();
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBO.saveCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBO.updateCustomer(customerDTO);
    }

    @Override
    public boolean deleteCustomer(Integer id) throws Exception {
        return customerBO.deleteCustomer(id);
    }

    @Override
    public CustomerDTO searchCustomer(Integer id) throws Exception {
        return customerBO.searchCustomer(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.getAllCustomers();
    }

    @Override
    public CustomerDTO searchByNIC(String nic) throws Exception {
        return customerBO.searchNNic(nic);
    }
}
