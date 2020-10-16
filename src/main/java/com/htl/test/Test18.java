package com.htl.test;

import com.htl.entity.Customer;
import com.htl.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test18 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        //级联查询
        String hql = "from Customer where name = :name";
        Query query1 = session.createQuery(hql);
        query1.setString("name","李四");
        Customer customer = (Customer) query1.uniqueResult();
        String hql2 = "from Orders where customer = :customer";
        Query query2 = session.createQuery(hql2);
        query2.setEntity("customer",customer);
        List<Orders> list = query2.list();
        for (Orders orders:list){
            System.out.println(orders);
        }
        session.close();
    }
}