package com.htl.test;

import com.htl.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        // 创建Configuration
        Configuration configuration = new Configuration().configure();
        /*如果默认是 hibernate.cfg.xml ，configure()里面就不用写。如果xml名字改了，里面就写修改的名字。*/
        System.out.println(configuration);
        // 获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 获取Session
        Session session = sessionFactory.openSession();
        // 向People表中插入数据
        People people = new People();
        people.setName("李四");
        people.setMoney(200.0);
        session.save(people);/*保存*/
        session.beginTransaction().commit();/*提交事务*/
        session.close();/*关闭session*/
    }
}
