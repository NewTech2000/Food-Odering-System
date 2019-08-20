package lk.ijse.dinamore.util;


import lk.ijse.dinamore.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .loadProperties("Dinamore.properties")
                .build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Reciption.class)
                .addAnnotatedClass(Menu.class)
                .addAnnotatedClass(Delivery.class)
                .addAnnotatedClass(Chef.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetails.class)
                .addAnnotatedClass(UserAccount.class)
                .addAnnotatedClass(Customer.class)
                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
