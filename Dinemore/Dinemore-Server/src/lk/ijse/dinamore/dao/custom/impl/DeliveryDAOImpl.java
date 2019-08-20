package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.custom.DeliveryDAO;
import lk.ijse.dinamore.entity.Delivery;
import lk.ijse.dinamore.entity.Reciption;
import lk.ijse.dinamore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

public class DeliveryDAOImpl implements DeliveryDAO {

    private SessionFactory sessionFactory;
    public DeliveryDAOImpl(){
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(Delivery entity) throws Exception {
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
    public boolean Update(Delivery entity) throws Exception {
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

            Delivery delivery=session.get(Delivery.class,id);
            session.remove(delivery);


            session.getTransaction().commit();
        }catch (HibernateException ex){
            return false;
        }
        return true;
    }

    @Override
    public Delivery Search(String id) throws Exception {
        Delivery delivery=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            delivery=session.get(Delivery.class,id);

            session.getTransaction().commit();
        }catch (HibernateException ex){

        }
        return delivery;
    }


    @Override
    public List<Delivery> getAll() throws Exception {
        ArrayList<Delivery> deliveries=null;
        try(Session session=sessionFactory.openSession()){

            session.getTransaction().begin();

            Query query =session.createNativeQuery("SELECT * FROM  Delivery");
            query.setResultTransformer(Transformers.aliasToBean(Delivery.class));
            deliveries= (ArrayList <Delivery>) query.getResultList();


            session.getTransaction().commit();
        }catch (HibernateException ex){
            return null;
        }
        return deliveries;
    }

    @Override
    public List <Delivery> getAllThree() throws Exception {
        return null;
    }
}
