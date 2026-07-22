package com.iacademy.cselec05.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class AuthUtility {

    private static String USERNAME = "username";

    public static void setSession(String username, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute(USERNAME, username);
    }

    public static boolean isAuthenticated(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(USERNAME) != null;
    }

    public static String getUsername(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return session != null ? (String) session.getAttribute(USERNAME) : null;
    }

    public static void invalidateSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
    }


}
