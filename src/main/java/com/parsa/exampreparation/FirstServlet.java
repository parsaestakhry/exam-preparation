package com.parsa.exampreparation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "FirstServlet", value = "/first-servlet")
public class FirstServlet implements Servlet {
    ServletConfig config = null;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet Initializing");
    }

    @Override
    public ServletConfig getServletConfig() {
        return  config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("utf8");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<html>");
        writer.println("<head> <title> title </title> </head>");
        writer.println("<body>");
        writer.println("<h1> Welcome to the first  servlet </h1>");
        writer.println("<h2 style='background-color:red;'> Content Type: " + servletRequest.getContentType() + "</h2>");
        writer.println("<h2> Servlet Name: " + servletRequest.getServerName() + "</h2>");
        if (servletRequest.getParameter("user") != null ) {
            writer.println("<h2 style='color:red;> User Parameter Value " + servletRequest.getParameter("user") + "</h2>");


        }

        writer.println("<h2> Server Date time " + new Date() + "</h2>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "FIRST SERVLET";
    }

    @Override
    public void destroy() {
        System.out.println("SERVLET DESTROYING");
    }
}
