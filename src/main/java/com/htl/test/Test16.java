package com.htl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Test16 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        //查询实体对象的属性
        String hql = "select name from People where id = 6";
        Query query = session.createQuery(hql);
        String name = (String) query.uniqueResult();
        System.out.println(name);
        session.close();
    }
}