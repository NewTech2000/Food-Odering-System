package lk.ijse.dinamore.dao.custom.impl;

import lk.ijse.dinamore.dao.custom.MenuDAO;
import lk.ijse.dinamore.entity.Menu;
import lk.ijse.dinamore.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {

    private SessionFactory sessionFactory;

    public MenuDAOImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();

    }

    @Override
    public boolean Save(Menu entity) throws Exception {
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
    public boolean Update(Menu entity) throws Exception {
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
    public boolean delete(Integer integer) throws Exception {
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            Menu menu = session.get(Menu.class,integer);
            session.remove(menu);
            session.getTransaction().commit();

        }catch (HibernateException ex){
            return false;
        }
        return true;    }

    @Override
    public Menu Search(Integer integer) throws Exception {
        Menu menu=null;
        try(Session session=sessionFactory.openSession()){
            session.getTransaction().begin();

            menu=session.get(Menu.class,integer);

            session.getTransaction().commit();
        }
        return menu;
    }


    @Override
    public List<Menu> getAll() throws Exception {
        ArrayList<Menu> menus =null;
        try(Session session = sessionFactory.openSession()){
            session.getTransaction().begin();

            Query query =session.createNativeQuery("SELECT * FROM  Menu");
            query.setResultTransformer(Transformers.aliasToBean(Menu.class));
            menus= (ArrayList <Menu>) query.getResultList();


            session.getTransaction().commit();
        }catch (HibernateException ex){
            return null;
        }
        return menus;
    }

    @Override
    public List <Menu> getAllThree() throws Exception {
        return null;
    }

    @Override
    public Menu searchByName(String name) throws Exception {
        Menu foods=null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("from Menu where foodName=:food");
            query.setString("food",name);
            foods=(Menu) query.uniqueResult();
            session.getTransaction().commit();

        }catch (HibernateException ex){
            ex.printStackTrace();
            return null;

        }
        return foods;
    }
}
