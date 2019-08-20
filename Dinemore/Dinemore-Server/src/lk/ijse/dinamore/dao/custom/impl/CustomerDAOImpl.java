package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.business.custom.CustomerBO;
import lk.ijse.dinamore.dao.custom.CustomerDAO;
import lk.ijse.dinamore.entity.Customer;
import lk.ijse.dinamore.entity.Delivery;
import lk.ijse.dinamore.util.HibernateUtil;
import lk.ijse.dinemore.common.dto.CustomerDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;
    public CustomerDAOImpl(){
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(Customer entity) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            session.persist(entity);


            session.getTransaction().commit();
        }
        return true;

    }

    @Override
    public boolean Update(Customer entity) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            session.merge(entity);


            session.getTransaction().commit();
        }
        return true;

    }

    @Override
    public boolean delete(Integer integer) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Customer customer=session.get(Customer.class,integer);
            session.remove(customer);


            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public Customer Search(Integer integer) throws Exception {
        Customer customer=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            customer=session.get(Customer.class,integer);

            session.getTransaction().commit();
        }catch (HibernateException ex){

        }
        return customer;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        ArrayList<Customer> customerArrayList=null;
        try(Session session=sessionFactory.openSession()){

            session.getTransaction().begin();

            Query query =session.createNativeQuery("SELECT * FROM  Customer");
            ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(Customer.class));
            customerArrayList= (ArrayList <Customer>) query.getResultList();


            session.getTransaction().commit();
        }catch (HibernateException ex){
            return null;
        }
        return customerArrayList;
    }

    @Override
    public List <Customer> getAllThree() throws Exception {
        return null;
    }

    @Override
    public Customer searchNIC(String nic) throws Exception {
        Customer customer;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();


            org.hibernate.query.Query query = session.createQuery("from Customer where customerNic=:nic");
            query.setString("nic", nic);
            customer = (Customer) query.uniqueResult();


            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return customer;
    }
}
