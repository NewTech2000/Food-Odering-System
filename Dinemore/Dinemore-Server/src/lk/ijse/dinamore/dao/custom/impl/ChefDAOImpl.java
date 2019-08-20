package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.custom.ChefDAO;
import lk.ijse.dinamore.entity.Chef;
import lk.ijse.dinamore.entity.Reciption;
import lk.ijse.dinamore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class ChefDAOImpl implements ChefDAO {

    private SessionFactory sessionFactory;
    public  ChefDAOImpl(){
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(Chef entity) throws Exception {
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
    public boolean Update(Chef entity) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            session.merge(entity);

            session.getTransaction().commit();

        }catch (HibernateException ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Chef chef = session.get(Chef.class,id);
            session.remove(chef);

            session.getTransaction().commit();

        }catch (HibernateException ex){
            return false;
        }
        return true;
    }

    @Override
    public Chef Search(String id) throws Exception {
        Chef chef=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            chef=session.get(Chef.class,id);

            session.getTransaction().commit();
        }
        return chef;
    }

    @Override
    public List<Chef> getAll() throws Exception {
        ArrayList<Chef> chefs = null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Query query =session.createNativeQuery("SELECT * FROM  Chef");
            query.setResultTransformer(Transformers.aliasToBean(Chef.class));
            chefs= (ArrayList <Chef>) query.getResultList();


            session.getTransaction().commit();
        }catch (HibernateException ex){
            return null;
        }
        return chefs;
    }

    @Override
    public List <Chef> getAllThree() throws Exception {
        return null;
    }
}
