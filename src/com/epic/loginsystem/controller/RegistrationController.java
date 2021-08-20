package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.RegistrationDao;
import com.epic.loginsystem.dao.UserRoleDao;
import com.epic.loginsystem.model.Registration;
import com.epic.loginsystem.model.Role_page_details;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/signup") //url
public class RegistrationController extends HttpServlet {

    //create reference variable
    private RegistrationDao registrationDao;
    private  UserRoleDao userRoleDao;

    //create object class loading time
    public void init() {
        registrationDao =new RegistrationDao();
         userRoleDao = new UserRoleDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        String userName = req.getParameter("userName"); //collect data
        String email = req.getParameter("email");//collect data
        String address = req.getParameter("address");//collect data
        String contact = req.getParameter("contact");//collect data
        String password = req.getParameter("password");//collect data
        String role=req.getParameter("role");//collect data

        String page="Home.jsp";

        Registration registration=new Registration(); //create object type of registration
        registration.setEmail(email); //assign data to using set method
        registration.setUserName(userName); //assign data to using set method
        registration.setAddress(address); //assign data to using set method
        registration.setContact(contact); //assign data to using set method
        registration.setPassword(password); //assign data to using set method
        registration.setRole(role);
        System.out.println(registration.toString());
        boolean b = registrationDao.registerEmployee(registration); // send registration model type data to dao
            System.out.println("go and come register");
            PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        if (b){
            writer.write("{\"operation\":\"success\"}");//send response to front end if this task success
        }else{
            System.out.println("failed");
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
        System.out.println(email);
        String password = req.getParameter("password"); //collect data
        System.out.println("email is ==="+email);
        try {
            Registration r = registrationDao.signIn(email); // send data for dao and catch it return data
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            if (r!=null){
                if (r.getPassword().equals(password)){
                    System.out.println(r.toString());
                    System.out.println("roleee is-------------"+r.getRole());
                    ArrayList<Role_page_details> role_page_details = userRoleDao.searchRoleDetails(r.getRole());
                    System.out.println("role details -----------");
                    String data = new Gson().toJson(role_page_details);
                    System.out.println(data);
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    resp.getWriter().write(data);
                }else{
                    resp.sendRedirect("Signin.jsp");
                }
            }else{
                resp.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
