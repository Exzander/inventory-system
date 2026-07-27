package com.iacademy.cselec05.inventory.servlet.auth;

import com.iacademy.cselec05.inventory.constant.Urls;
import com.iacademy.cselec05.inventory.util.AuthUtility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(AuthUtility.isAuthenticated(req)) {
            AuthUtility.invalidateSession(req);
        }

        resp.sendRedirect(req.getContextPath() + Urls.LOGIN);
    }
}
