package com.htl.test;

import com.htl.entity.Customer;
import com.htl.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configuration = new Configuration().configure();
        /*如果默认是 hibernate.cfg.xml ，configure()里面就不用写。如果xml名字改了，里面就写修改的名字。*/
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();
        //创建Customer
        Customer customer = new Customer();
        customer.setName("张三11");
        //创建Orders
        Orders orders = new Orders();
        orders.setName("订单11");
        //建立关联关系
        orders.setCustomer(customer);
        //保存
        session.save(customer);
        session.save(orders);
        //提交事务
        session.beginTransaction().commit();
        //关闭
        session.close();
    }
}

