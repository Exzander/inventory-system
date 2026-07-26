package com.iacademy.cselec05.inventory.filter;

import com.iacademy.cselec05.inventory.util.AuthUtility;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // Block non-Admin users from accessing the registration page
        if (!AuthUtility.hasRole("Admin", req)) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Admin privileges required.");
            return;
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {}
}
