package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.RegistrationDao;
import com.epic.loginsystem.model.Registration;
import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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

@WebServlet(urlPatterns = "/details") //url
public class RegistrationCrudController extends HttpServlet {
    //create reference variable
    private RegistrationDao registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new RegistrationDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Registration> details = registrationDao.searchRegistration(req.getParameter("userName"));
        String data = new Gson().toJson(details);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(data);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject Registration = reader.readObject();
        String email = Registration.getString("email");
        String userName = Registration.getString("userName"); //collect data
        String address = Registration.getString("address");//collect data
        String contact = Registration.getString("contact");//collect data
        String password = Registration.getString("password");//collect data

        Registration registration=new Registration(); //create object type of registration
        registration.setEmail(email); //assign data to using set method
        registration.setUserName(userName); //assign data to using set method
        registration.setAddress(address); //assign data to using set method
        registration.setContact(contact); //assign data to using set method
        registration.setPassword(password); //assign data to using set method

        System.out.println(registration.toString());
        boolean b = registrationDao.updateRegister(registration);
        System.out.println(b);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject reg = reader.readObject();
        String email = reg.getString("email");
        System.out.println(email);
        int i = 0;
        try {
            i = registrationDao.deleteRegistration(email);

        resp.setContentType("application/json");
        if(i>0){
            System.out.println("deletttttt");
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("operation","success");
            writer.print(response.build());
        }
        writer.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
