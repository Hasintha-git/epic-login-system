package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.RegistrationDao;
import com.epic.loginsystem.model.Registration;
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
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/loadData") //url
public class RegistrationDataLoad extends HttpServlet {
    //create reference variable
    private RegistrationDao registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new RegistrationDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countTo = req.getParameter("countTo");
        String countFrom = req.getParameter("countFrom"); //collect data
        System.out.println(countTo+ "-"+countFrom);
        ArrayList<Registration> details = null;
        try {
            details = registrationDao.getDetails(countTo,countFrom);
            String data = new Gson().toJson(details);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(data);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
