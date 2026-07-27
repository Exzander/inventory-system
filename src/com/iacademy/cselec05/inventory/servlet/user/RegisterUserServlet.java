package com.iacademy.cselec05.inventory.servlet.user;

import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.factory.ObjectFactory;
import com.iacademy.cselec05.inventory.model.User;
import com.iacademy.cselec05.inventory.repo.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUserServlet extends HttpServlet {
    private final UserRepository userRepository = ObjectFactory.getUserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Sends authorized users to the registration page
        req.getRequestDispatcher(Views.REGISTER_USER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        // Retains user inputs in fields if an error occurred
        req.setAttribute("username", username);
        req.setAttribute("password", password);

        if(username == null || username.trim().isEmpty()) {
            req.setAttribute("usernameError", "Username is required");
            req.getRequestDispatcher(Views.REGISTER_USER).forward(req, resp);
            return;
        }

        if(password == null || password.trim().isEmpty()) {
            req.setAttribute("passwordError", "Password is required");
            req.getRequestDispatcher(Views.REGISTER_USER).forward(req, resp);
            return;
        }

        if(role == null || role.trim().isEmpty()) {
            req.setAttribute("roleError", "Role is required");
            req.getRequestDispatcher(Views.REGISTER_USER).forward(req, resp);
            return;
        }

        User newUser = new User();
        newUser.setUsername(username.trim());
        newUser.setPassword(password.trim());
        newUser.setRole(role.trim());

        boolean success = userRepository.registerUser(newUser);

        if(success) {
            req.setAttribute("success", "User registered successfully");

            // Clear inputs on success so the form resets
            req.removeAttribute("username");
            req.removeAttribute("role");
        } else {
            req.setAttribute("registrationError", "Failed to register User");
        }

        req.getRequestDispatcher(Views.REGISTER_USER).forward(req, resp);
    }
}
