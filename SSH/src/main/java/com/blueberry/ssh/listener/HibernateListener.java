package com.blueberry.ssh.listener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/27.
 */
public class HibernateListener implements ServletContextListener {

    private String path = "/hibernate/hibernate.cfg.xml";
    private Configuration config;
    private SessionFactory factory;

    private static Class clazz = HibernateListener.class;
    public static final String KEY_NAME = clazz.getName();
    public void contextInitialized(ServletContextEvent event) {

        try {
            URL url = HibernateListener.class.getResource(path);
            config = new Configuration().configure(url);
            factory = config.buildSessionFactory();
            event.getServletContext().setAttribute(KEY_NAME,factory);
        }catch ( Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
    }
}
