package com.example.hungpchu.HibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class App {

    public static void main(String[] args)
    {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.getTransaction().begin();

            String jpql = "Select e from " + Todo.class.getName() + " e ";

            System.out.println("cau lenh = " + jpql);

            // Tạo đối tượng Query.
            Query<Todo> query = session.createQuery(jpql, Todo.class);

            // Thực hiện truy vấn.
            List<Todo> todos = query.getResultList();

            for (Todo todo : todos)  System.out.println(todo);
            session.getTransaction().commit();
        }catch(Exception e)
        {
            e.printStackTrace();
            // Rollback trong trường hợp có lỗi xẩy ra.
            session.getTransaction().rollback();
        }

    }
}
