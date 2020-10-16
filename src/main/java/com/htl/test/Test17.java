package com.htl.test;

import com.htl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test17 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        //占位符
        String hql = "from People where name = :name";
        Query query = session.createQuery(hql);
        query.setString("name","张三0");
        List<People> list = query.list();
        for (People people:list){
            System.out.println(people);
        }
        session.close();
    }
}