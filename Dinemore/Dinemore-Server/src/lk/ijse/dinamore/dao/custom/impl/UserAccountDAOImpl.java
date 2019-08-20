package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.custom.UserAccountDAO;
import lk.ijse.dinamore.entity.UserAccount;
import lk.ijse.dinamore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserAccountDAOImpl implements UserAccountDAO {

    private SessionFactory sessionFactory;

    public UserAccountDAOImpl(){
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(UserAccount entity) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            session.persist(entity);

            session.getTransaction().commit();
        }catch (HibernateException ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean Update(UserAccount entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public UserAccount Search(String s) throws Exception {
        return null;
    }

    @Override
    public List<UserAccount> getAll() throws Exception {
        return null;
    }

    @Override
    public List <UserAccount> getAllThree() throws Exception {
        return null;
    }
}
