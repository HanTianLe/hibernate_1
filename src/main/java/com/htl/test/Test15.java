package com.htl.test;

import com.htl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test15 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        //order by
//        String hql = "from People order by id";
        String hql = "from People order by id desc ";
        /* 默认是 asc 升序。*/
        Query query = session.createQuery(hql);
        List<People> list = query.list();
        for (People people:list){
            System.out.println(people);
        }
        session.close();
    }
}