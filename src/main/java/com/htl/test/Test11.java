package com.htl.test;

import com.htl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        //查询对象
        String hql = "from People ";
        /* 写的是所查询表对应的实体类的名字！尽量写实体类的全类名。也就是 from com.htl.entity.People */
        Query query = session.createQuery(hql);
        List<People> list = query.list();
        for (People people:list){
            System.out.println(people);
        }
        session.close();
    }
}