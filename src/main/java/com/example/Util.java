package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    public static final String USER_SESSION_ATTRIBUTE = "user";
    public static final String LOGIN_USER_REQUEST_PARAM = "login";
    public static final String PASSWORD_USER_REQUEST_PARAM = "password";
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String HELLO_JSP = "/user/hello.jsp";
    public static final String SERVLET_TIME_INIT_CONTEXT_ATTRIBUTE = "servletTimeInit";

    public static boolean isNotUserExist(HttpServletRequest req) {
        return req.getSession().getAttribute(USER_SESSION_ATTRIBUTE) == null;
    }

    public static void deleteUserSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute(USER_SESSION_ATTRIBUTE);
        }
    }

    public static void setUserSession(HttpServletRequest req, String login) {
        req.getSession().setAttribute(USER_SESSION_ATTRIBUTE, login);
    }

    public static void invalidateSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }
}
