package com.example.hungpchu.HibernateTutorial;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory(){ return sessionFactory; }

    public static void shutdown() { getSessionFactory().close(); }

    //Hibernate 5
    private static SessionFactory buildSessionFactory()
    {
        ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        // Tạo MetaData (siêu dữ liệu) cung cấp các thông tin về DB, charset, vv...
        Metadata metadata = new MetadataSources( serviceRegistry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();

    }
}
