package com.epic.loginsystem.db;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("application context created");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/epicLoginSystem");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("1234");
        basicDataSource.setMaxTotal(2);
        basicDataSource.setInitialSize(2);

        servletContextEvent.getServletContext().setAttribute("ds",basicDataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
