package com.htl.test;

import com.htl.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        Orders orders = session.get(Orders.class,2);
//        System.out.println(orders);
        System.out.println(orders.getCustomer());
        session.close();
    }
}
