package com.iacademy.cselec05.inventory.filter;

import com.iacademy.cselec05.inventory.constant.Urls;
import com.iacademy.cselec05.inventory.constant.Views;
import com.iacademy.cselec05.inventory.util.AuthUtility;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Implemented an AuthenticationFilter to prevent unauthenticated users from accessing private pages available only for logged-in users
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getRequestURI().substring(req.getContextPath().length());

        // Identifies public paths
        boolean isLoginPath = path.equals(Urls.LOGIN) || path.equals(Views.LOGIN);
        boolean isStaticResource = path.startsWith("/css");

        boolean isLoggedIn = AuthUtility.isAuthenticated(req);

        // If any of the condition is true,  allows the request to pass forward to the requested page or servlet.
        if(isLoggedIn || isLoginPath || isStaticResource) {
            filterChain.doFilter(req, resp);
        } else { // If all are false, deny the request and redirect them to the login page
            resp.sendRedirect(req.getContextPath() + Urls.LOGIN);
        }
    }

    @Override
    public void destroy() {}
}
