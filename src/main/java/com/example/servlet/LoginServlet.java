package com.example.servlet;

import com.example.Users;
import com.example.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (Util.isNotUserExist(req)) {
            redirect(req, resp, Util.LOGIN_JSP);
        } else {
            redirect(req, resp, Util.HELLO_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> login = checkUser(req);
        if (login.isPresent()) {
            Util.setUserSession(req, login.get());
            redirect(req, resp, Util.HELLO_JSP);
        } else {
            forward(req, resp);
        }
    }

    private Optional<String> checkUser(HttpServletRequest req) {
        Optional<String> result = Optional.empty();
        //check login
        String login = req.getParameter(Util.LOGIN_USER_REQUEST_PARAM);
        Users users = Users.getInstance();
        if (users.getUsers().contains(login)) {
            //check password
            String password = req.getParameter(Util.PASSWORD_USER_REQUEST_PARAM);
            if (Util.isNotEmpty(password)) {
                result = Optional.of(login);
            }
        }
        return result;
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(Util.LOGIN_JSP);
        dispatcher.forward(req, resp);
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, String page) throws IOException {
        resp.sendRedirect(req.getContextPath().concat(page));
    }
}
