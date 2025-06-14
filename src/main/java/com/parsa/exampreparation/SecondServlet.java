package com.parsa.exampreparation;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", value = "/second-servlet")
public class SecondServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("utf8");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<html>");
        writer.println("<head><title> title </title></head>");
        writer.println("<body>");
        writer.println("<h1 style='background-color:red;'> this is a generic servlet </h1>");
        writer.println("<h2> Language: " + servletResponse.getLocale().getLanguage() + "</h2>");
        writer.println("<h2> Servlet Name:  " + servletRequest.getServerName() + "<h2>");
        if (servletRequest.getParameter("user") !=null ) {
            writer.println("<h1> this is : " + servletRequest.getParameter("user") + "</h1>");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
