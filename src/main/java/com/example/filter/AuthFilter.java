package com.example.filter;

import com.example.Util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/*"})
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (Util.isNotUserExist(req)) {
            resp.sendRedirect(req.getContextPath().concat(Util.LOGIN_JSP));
        }

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

}