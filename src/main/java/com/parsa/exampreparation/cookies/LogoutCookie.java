package com.parsa.exampreparation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutCookie", value = "/logout-cookie")
public class LogoutCookie extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()){
            Cookie cookies = new Cookie("login", "");
            cookies.setMaxAge(0);
            response.addCookie(cookies);

            writer.println("<html>");
            writer.println("<head><title> title </title></head>");
            writer.println("<h1 style='color:green;'> Logout successful </h1> ");
            request.getRequestDispatcher("logincookie.html").include(request,response);

        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }


    @Override
    public String getServletInfo() {
        return "logout servlet";
    }
}
