package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.PagesDao;
import com.epic.loginsystem.dao.UserRoleDao;
import com.epic.loginsystem.model.Pages;
import com.epic.loginsystem.model.Role_page_details;
import com.epic.loginsystem.model.User_role;
import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(urlPatterns = "/roles") //url
public class UserRoleController extends HttpServlet {

    //create reference variable
    private UserRoleDao userRoleDao;

    //create object class loading time
    public void init() {
        userRoleDao =new UserRoleDao();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject Role_page_details = reader.readObject();
        String role = Role_page_details.getString("role");
        String pageName = Role_page_details.getString("pageName");

        System.out.println(role+"-"+pageName);
        Role_page_details rpd = new Role_page_details();
        rpd.setRoleType(role);
        rpd.setPageName(pageName);
        boolean b = userRoleDao.addRolePageDetails(rpd);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        if (b){
            writer.write("{\"operation\":\"success\"}");//send response to front end if this task success
        }else{
            writer.write("{\"operation\":\"failed\"}");//send response to front end if this task success
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Role_page_details> allRoleDetails = userRoleDao.getAllRoleDetails();
            String data = new Gson().toJson(allRoleDetails);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            System.out.println(data);
            resp.getWriter().write(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
