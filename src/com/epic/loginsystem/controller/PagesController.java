package com.epic.loginsystem.controller;

import com.epic.loginsystem.dao.PagesDao;
import com.epic.loginsystem.dao.RegistrationDao;
import com.epic.loginsystem.model.Pages;
import com.epic.loginsystem.model.Registration;
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

@WebServlet(urlPatterns = "/pages") //url
public class PagesController extends HttpServlet {

    //create reference variable
    private PagesDao pagesDao;

    //create object class loading time
    public void init() {
        pagesDao =new PagesDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add page controller");
        String pageName = req.getParameter("pageName");
        String des = req.getParameter("des");
        Pages pages = new Pages(pageName, des);
        boolean b = pagesDao.addPage(pages);
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
            ArrayList<Pages> allPages = pagesDao.getAllPages();
            String data = new Gson().toJson(allPages);
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
