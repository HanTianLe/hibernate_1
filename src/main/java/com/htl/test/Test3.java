package com.htl.test;

import com.htl.entity.Account;
import com.htl.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new Configuration().configure();
        /*如果默认是 hibernate.cfg.xml ，configure()里面就不用写。如果xml名字改了，里面就写修改的名字。*/
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();
        Course course = new Course();
        course.setName("C语言");
        Account account = new Account();
        account.setName("李四");
        Set<Course> courses = new HashSet<Course>();
        courses.add(course);
        account.setCourses(courses);
        session.save(course);
        session.save(account);
        session.beginTransaction().commit();
        session.close();
    }
}
