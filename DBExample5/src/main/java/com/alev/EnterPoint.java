package com.alev;

import com.alev.entity.User;
import com.alev.persistence.HibernateUtil;
import org.hibernate.Session;

public class EnterPoint {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setFirstName("Vasily");
        user.setLastName("Shukshin");

        session.save(user);
        session.getTransaction().commit();
    }

}
