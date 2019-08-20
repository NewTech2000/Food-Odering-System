package lk.ijse.dinamore.business.custom.impl;

import lk.ijse.dinamore.business.custom.CustomerBO;
import lk.ijse.dinamore.dao.custom.CustomerDAO;
import lk.ijse.dinamore.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dinamore.entity.Customer;
import lk.ijse.dinamore.util.HibernateUtil;
import lk.ijse.dinemore.common.dto.CustomerDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO;

    private SessionFactory sessionFactory;

    public CustomerBOImpl()
    {
        customerDAO=new CustomerDAOImpl();
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.Save(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),customerDTO.getCustomerNic(),customerDTO.getCustomerMobile()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDAO.Update(new Customer(customerDTO.getCustomerId(),customerDTO.getCustomerName(),customerDTO.getCustomerAddress(),customerDTO.getCustomerNic(),customerDTO.getCustomerMobile()));
    }

    @Override
    public boolean deleteCustomer(Integer id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO searchCustomer(Integer id) throws Exception {
        Customer customer=customerDAO.Search(id);
        if (customer!=null){
            return new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerNic(),customer.getCustomerMobile());
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> customerList=customerDAO.getAll();
        ArrayList<CustomerDTO> dtos=new ArrayList <>();
        for (Customer customer : customerList){
            dtos.add(new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerNic(),customer.getCustomerMobile()));

        }
        return dtos;
    }

    @Override
    public CustomerDTO searchNNic(String nic) throws Exception {
        Customer customer=customerDAO.searchNIC(nic);
        if (customer!=null){
            return new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerNic(),customer.getCustomerMobile());
        }
        return null;
//

    }
}
