package com.example.listener;

import com.example.Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent e) {
        // showing when the context was initialized
        e.getServletContext().setAttribute(Util.SERVLET_TIME_INIT_CONTEXT_ATTRIBUTE, LocalDateTime.now());
    }
}
