package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.RegistrationDao;
import com.epic.loginsystem.model.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/signup") //url
public class RegistrationController extends HttpServlet {

    //create reference variable
    private RegistrationDao registrationDao;

    //create object class loading time
    public void init() {
        registrationDao =new RegistrationDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        String userName = req.getParameter("userName"); //collect data
        String email = req.getParameter("email");//collect data
        String address = req.getParameter("address");//collect data
        String contact = req.getParameter("phone");//collect data
        String password = req.getParameter("password");//collect data

        Registration registration=new Registration(); //create object type of registration
        registration.setEmail(email); //assign data to using set method
        registration.setUserName(userName); //assign data to using set method
        registration.setAddress(address); //assign data to using set method
        registration.setContact(contact); //assign data to using set method
        registration.setPassword(password); //assign data to using set method

        boolean b = registrationDao.registerEmployee(registration); // send registration model type data to dao
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        if (b){
            writer.write("{\"operation\":\"success\"}");//send response to front end if this task success
        }else{
            writer.write("{\"operation\":\"failed\"}");//send response to front end if this task failed
        }
            writer.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email"); //collect data
        String password = req.getParameter("password"); //collect data
        try {
            Registration r = registrationDao.signIn(email); // send data for dao and catch it return data
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            String p = r.getPassword();

            if (p.equals(password)){ //check password matched
                System.out.println("success");
                writer.write("{\"operation\":\"success\"}"); //send response to front end if this task success
            }else{
                System.out.println("failed");
                writer.write("{\"operation\":\"failed\"}");//send response to front end if this task failed
            }

            writer.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
