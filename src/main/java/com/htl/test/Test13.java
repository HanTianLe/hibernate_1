package com.htl.test;

import com.htl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Test13 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        //where条件查询
        String hql = "from People where id = 0";
        Query query = session.createQuery(hql);
        People people = (People) query.uniqueResult();
        System.out.println(people);
        session.close();
    }
}