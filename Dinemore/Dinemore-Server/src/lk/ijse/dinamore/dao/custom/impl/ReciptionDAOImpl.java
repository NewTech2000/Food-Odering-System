package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.custom.ReciptionDAO;
import lk.ijse.dinamore.entity.Reciption;
import lk.ijse.dinamore.util.HibernateUtil;
import lk.ijse.dinemore.common.dto.ReciptionDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static javafx.scene.input.KeyCode.T;

public class ReciptionDAOImpl implements ReciptionDAO {

    private SessionFactory sessionFactory;

    public ReciptionDAOImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean Save(Reciption entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

             session.persist(entity);

            session.getTransaction().commit();

        } catch (HibernateException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean Update(Reciption entity) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            session.update(entity);

            session.getTransaction().commit();

        } catch (HibernateException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            Reciption reciption = session.get(Reciption.class, id);
            session.remove(reciption);

            session.getTransaction().commit();

        } catch (HibernateException ex) {
            return false;
        }
        return true;
    }

    @Override
    public Reciption Search(Integer id) throws Exception {
        Reciption reciption = null;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();

            reciption=session.get(Reciption.class,id);
            System.out.println(reciption);


            session.getTransaction().commit();

        } catch (HibernateException ex) {

        }

        return reciption;

    }


    @Override
    public List <Reciption> getAll() throws Exception {
        ArrayList<Reciption> reciptions=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Query query =session.createNativeQuery("SELECT * FROM  Reciption");
            query.setResultTransformer(Transformers.aliasToBean(Reciption.class));
            reciptions= (ArrayList <Reciption>) query.getResultList();


        }catch (HibernateException ex){
            return null;
        }
        return reciptions;

    }

    @Override
    public List <Reciption> getAllThree() throws Exception {
        return null;
    }
}
