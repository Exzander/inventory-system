package com.iacademy.cselec05.Servlet;

import com.iacademy.cselec05.util.AuthUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("password")) {
            AuthUtility.setSession(username,req);
        }

        resp.sendRedirect("/login/");
    }
}
