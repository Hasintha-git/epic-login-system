package com.epic.loginsystem.dao;

import com.epic.loginsystem.db.DBConnection;
import com.epic.loginsystem.model.Pages;
import com.epic.loginsystem.model.Role_page_details;
import com.epic.loginsystem.model.User_role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRoleDao {
    public ArrayList<User_role> getAllRoles() throws SQLException, ClassNotFoundException {
        Pages pages = new Pages();
        DBConnection dbConnection = null;
        ResultSet rst = null;
        dbConnection = new DBConnection();
        final String url="SELECT * FROM user_role ";
        PreparedStatement pstm = dbConnection.getConnection().prepareStatement(url);

        rst = pstm.executeQuery();
        ArrayList<User_role> load = new ArrayList<>();
        while (rst.next()) {
            System.out.println("while ");
            load.add(new User_role(rst.getString(1)));
        }
        dbConnection.connection.close();
        return load;
    }

    public boolean addRolePageDetails(Role_page_details rpd) {
        DBConnection connection = null;
        try {
            connection = new DBConnection();
            System.out.println("user role dao");
            PreparedStatement pstm = connection.getConnection().prepareStatement("insert into role_pages_details values(?,?)");
            System.out.println("db go and come to daaoooooo");
            pstm.setObject(1, rpd.getRoleType());
            pstm.setObject(2,rpd.getPageName());
            int i = pstm.executeUpdate();
            System.out.println(i);
            if (i >= 0) {

                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<Role_page_details> getAllRoleDetails() throws SQLException, ClassNotFoundException {
        Role_page_details role_page_details = new Role_page_details();
        DBConnection dbConnection = null;
        ResultSet rst = null;
        dbConnection = new DBConnection();
        final String url="SELECT * FROM role_pages_details ";
        PreparedStatement pstm = dbConnection.getConnection().prepareStatement(url);

        rst = pstm.executeQuery();
        ArrayList<Role_page_details> load = new ArrayList<>();
        while (rst.next()) {
            System.out.println("while ");
            load.add(new Role_page_details(rst.getString(1),rst.getString(2)));
        }
        dbConnection.connection.close();
        return load;
    }

    public boolean setUserRole(String role) {
        DBConnection connection = null;
        try {
            connection = new DBConnection();
            System.out.println("user role dao");
            PreparedStatement pstm = connection.getConnection().prepareStatement("insert into user_role values(?)");
            System.out.println("db go and come to daaoooooo");
            pstm.setObject(1,role);
            int i = pstm.executeUpdate();
            System.out.println(i);
            if (i >= 0) {

                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public ArrayList<Role_page_details> searchRoleDetails(String role) {
        DBConnection connection = null;
        try {
            connection = new DBConnection();
            final String url="SELECT * FROM role_pages_details WHERE roleType=?";
            PreparedStatement pstm = connection.getConnection().prepareStatement(url);
            pstm.setObject(1, role);
            ResultSet rst = pstm.executeQuery();
            ArrayList<Role_page_details> load = new ArrayList<>();
            while (rst.next()) {
                load.add(new Role_page_details(rst.getString(1), rst.getString(2)));
            }
            return load;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;

    }

}
