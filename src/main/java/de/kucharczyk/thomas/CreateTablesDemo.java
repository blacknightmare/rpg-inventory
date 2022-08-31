package de.kucharczyk.thomas;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import de.kucharczyk.thomas.User;


public class CreateTablesDemo {

    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        User newUser = new User(1, "hans", "strolch", "hansi", "1234", "test@mail.de");
        User newUser = new User("one", "two", "hans", "123", "test@mail.de");
//        User newUser = new User(1, "one", "two", "hans", "123", "test@mail.de");
//        newUser.toString();
        session.save(newUser);

        // Create Session Factory Object using Annotation Configuration

        session.getTransaction().commit();
        session.close();

    }
}
