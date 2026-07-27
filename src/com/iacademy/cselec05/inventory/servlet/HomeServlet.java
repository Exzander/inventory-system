package com.iacademy.cselec05.inventory.servlet;

import com.iacademy.cselec05.inventory.model.User;
import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.util.AuthUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Retrieve user object and set it as a request attribute for the JSP View
        User currentUser = AuthUtility.getUser(req);
        req.setAttribute("currentUser", currentUser);

        // Forward request to protected dashboard view inside WEB-INF
        req.getRequestDispatcher(Views.HOME).forward(req, resp);
    }
}
