package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.UserRoleDao;
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

@WebServlet(urlPatterns = "/newrole") //url
public class RoleController extends HttpServlet {

    //create reference variable
    private UserRoleDao userRoleDao;

    //create object class loading time
    public void init() {
        userRoleDao =new UserRoleDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject User_role = reader.readObject();
        String role = User_role.getString("role");
        boolean b = userRoleDao.setUserRole(role);
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
            ArrayList<User_role> allRoles = userRoleDao.getAllRoles();
            String data = new Gson().toJson(allRoles);
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
