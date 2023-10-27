package com.example.servlet;

import com.example.Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Util.deleteUserSession(req);
        Util.invalidateSession(req);
        // cause invalid test
        resp.sendRedirect(Util.LOGIN_JSP);
    }
}
