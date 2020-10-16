package com.htl.test;

import com.htl.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        /*如果默认是 hibernate.cfg.xml ，configure()里面就不用写。如果xml名字改了，里面就写修改的名字。*/
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class,6);
//        System.out.println(customer);
//        System.out.println(customer.getOrders());
        System.out.println(customer.getOrders().size());
        session.close();

    }
}
