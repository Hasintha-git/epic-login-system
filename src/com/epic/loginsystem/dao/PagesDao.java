package com.epic.loginsystem.dao;

import com.epic.loginsystem.db.DBConnection;
import com.epic.loginsystem.model.Pages;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagesDao {
    public ArrayList<Pages> getAllPages() throws SQLException, ClassNotFoundException {
        Pages pages = new Pages();
        DBConnection dbConnection = null;
        ResultSet rst = null;
        dbConnection = new DBConnection();
        final String url="SELECT * FROM Pages ";
        PreparedStatement pstm = dbConnection.getConnection().prepareStatement(url);

        rst = pstm.executeQuery();
        ArrayList<Pages> load = new ArrayList<>();
        while (rst.next()) {
            System.out.println("while ");
            load.add(new Pages(rst.getString(1), rst.getString(2)));
        }
        dbConnection.connection.close();
        return load;
    }

    public boolean addPage(Pages pages) {
        DBConnection connection = null;
        try {
            connection = new DBConnection();
            System.out.println("user role dao");
            PreparedStatement pstm = connection.getConnection().prepareStatement("insert into Pages values(?,?)");
            System.out.println("db go and come to daaoooooo");
            pstm.setObject(1, pages.getPageName());
            pstm.setObject(2,pages.getDes());
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
}
