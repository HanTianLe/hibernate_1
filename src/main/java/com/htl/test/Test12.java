package com.htl.test;

import com.htl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test12 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();
        //分页查询
        String hql = "from com.htl.entity.People";
        Query query = session.createQuery(hql);
        query.setFirstResult(1);
        query.setMaxResults(3);
        /* 截取People表里面第2个到第4个的数据。*/
        List<People> list = query.list();
        for (People people:list){
            System.out.println(people);
        }
        session.close();
    }
}