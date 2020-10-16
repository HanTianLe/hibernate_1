package com.htl.test;

import com.htl.entity.Customer;
import com.htl.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Test9 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();

        Customer customer = new Customer();
        customer.setName("王5");

        Orders orders1 = new Orders();
        orders1.setName("5");
        orders1.setCustomer(customer);

        Orders orders2 = new Orders();
        orders2.setName("55");
        orders2.setCustomer(customer);

        //添加Customer维护
        Set<Orders> orders = new HashSet<Orders>();
        orders.add(orders1);
        orders.add(orders2);
        customer.setOrders(orders);

        session.save(customer);
        session.save(orders1);
        session.save(orders2);

        session.beginTransaction().commit();
        session.close();
    }
}