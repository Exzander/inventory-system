package com.iacademy.cselec05.inventory.servlet;

import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.repo.UserRepository;
import com.iacademy.cselec05.inventory.model.User;
import com.iacademy.cselec05.inventory.util.AuthUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private UserRepository userRepository = ObjectFactory.getUserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Redirects authenticated users to the home page instead of showing the login page
        if(AuthUtility.isAuthenticated(req)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

       if(username == null || username.trim().isEmpty()) {
           req.setAttribute("usernameError", "Username is required");
           req.getRequestDispatcher("/login.jsp").forward(req, resp);
           return;
       }

       if(password == null || password.trim().isEmpty()) {
           req.setAttribute("passwordError", "Password is required");
           req.getRequestDispatcher("/login.jsp").forward(req, resp);
           return;
       }

        // Authenticates the user using the entered credentials
        User user = userRepository.findByCredentials(username, password);

        // If authentication succeeds, create a session for the user and redirect to the home page
       if(user != null) {
           AuthUtility.setSession(user, req);
           resp.sendRedirect(req.getContextPath() + "/");
       } else {
           req.setAttribute("error", "Invalid Username or Password");
           req.getRequestDispatcher("/login.jsp").forward(req, resp);
       }

    }
}
