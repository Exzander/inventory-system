package com.iacademy.cselec05.inventory.util;

import com.iacademy.cselec05.inventory.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class AuthUtility {

    private static final String USER_KEY = "currentUser";

    public static void setSession(User user, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute(USER_KEY, user);
    }

    public static User getUser(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return session != null ? (User) session.getAttribute(USER_KEY) : null;
    }

    public static boolean isAuthenticated(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(USER_KEY) != null;
    }

    // Checks the logged-in user's specific role
    public static boolean hasRole(String role, HttpServletRequest request) {
        User user = getUser(request);
        return user != null && user.getRole().equals(role);
    }

    public static void invalidateSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
    }

}
