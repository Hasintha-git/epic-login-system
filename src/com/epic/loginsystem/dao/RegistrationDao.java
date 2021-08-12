package com.epic.loginsystem.dao;

import com.epic.loginsystem.model.Registration;
import java.sql.*;

public class RegistrationDao {

    public boolean registerEmployee(Registration registration) throws ClassNotFoundException {
        System.out.println("dao comming");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epicLoginSystem", "root", "1234");

        PreparedStatement pstm = connection.prepareStatement("insert into Registration values(?,?,?,?,?)");
        System.out.println("db go");
        pstm.setObject(1,registration.getEmail());
        pstm.setObject(2,registration.getUserName());
        pstm.setObject(3,registration.getAddress());
        pstm.setObject(4,registration.getContact());
        pstm.setObject(5,registration.getPassword());

        int i = pstm.executeUpdate();
        System.out.println(i);
        if (i<=0){
            return true;
        }else{
            return false;
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    public Registration signIn(String email) throws ClassNotFoundException, SQLException {
        Registration r=new Registration();
        //connect with database and get data from my sql database - registration table
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/epicLoginSystem", "root", "1234");
        PreparedStatement pstm = connection.prepareStatement("select * from Registration where email=?");
        pstm.setObject(1,email);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()){
             System.out.println(rst.getString(5));String mail = rst.getString(1); //collect data
             String userName = rst.getString(2); //collect data
             String address = rst.getString(3); //collect data
             String contact = rst.getString(4); //collect data
             String pass = rst.getString(5); //collect data
             r.setEmail(mail); //data set to registration model
             r.setUserName(userName); //data set to registration model
             r.setAddress(address); //data set to registration model
             r.setContact(contact);//data set to registration model
             r.setPassword(pass);//data set to registration model
        }
        return r;

    }

}
