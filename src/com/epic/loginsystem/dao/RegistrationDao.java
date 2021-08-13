package com.epic.loginsystem.dao;


import com.epic.loginsystem.db.DBConnection;
import com.epic.loginsystem.model.Registration;
import java.sql.*;
import java.util.ArrayList;

public class RegistrationDao {

    public boolean registerEmployee(Registration registration) throws ClassNotFoundException {
        DBConnection connection = null;
        try {
            connection = new DBConnection();

        System.out.println("dao comming");

        PreparedStatement pstm = connection.getConnection().prepareStatement("insert into Registration values(?,?,?,?,?,?)");
        System.out.println("db go");
        pstm.setObject(1,registration.getEmail());
        pstm.setObject(2,registration.getUserName());
        pstm.setObject(3,registration.getAddress());
        pstm.setObject(4,registration.getContact());
        pstm.setObject(5,registration.getPassword());
        pstm.setObject(6,registration.getRole());

        int i = pstm.executeUpdate();
        System.out.println(i);
        if (i>=0){
            return true;
        }else{
            return false;
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;

    }

    public Registration signIn(String email) throws ClassNotFoundException{
        Registration r=new Registration();
        //connect with database and get data from my sql database - registration table
        DBConnection dbConnection = null;
        try {
            dbConnection = new DBConnection();

        PreparedStatement pstm = dbConnection.getConnection().prepareStatement("select * from Registration where email=?");
        pstm.setObject(1,email);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()){
             System.out.println(rst.getString(5));String mail = rst.getString(1); //collect data
             String userName = rst.getString(2); //collect data
             String address = rst.getString(3); //collect data
             String contact = rst.getString(4); //collect data
             String pass = rst.getString(5); //collect data
             String role = rst.getString(6); //collect data
             r.setEmail(mail); //data set to registration model
             r.setUserName(userName); //data set to registration model
             r.setAddress(address); //data set to registration model
             r.setContact(contact);//data set to registration model
             r.setPassword(pass);//data set to registration model
            r.setRole(role);
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                dbConnection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return r;
    }

    public ArrayList<Registration> getDetails() throws SQLException, ClassNotFoundException {
        System.out.println("come dao");
        Registration r = new Registration();
        DBConnection dbConnection=null;
        ResultSet rst=null;
             dbConnection = new DBConnection();
             PreparedStatement pstm = dbConnection.getConnection().prepareStatement("SELECT * FROM Registration");
        rst = pstm.executeQuery();
        System.out.println("get result");
        ArrayList<Registration> load=new ArrayList<>();
        while (rst.next()){
            System.out.println("while ");
            load.add(new Registration(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5), rst.getString(6)));

            System.out.println("Add data");
        }
        return load;
    }
}
