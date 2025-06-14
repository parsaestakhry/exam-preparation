package com.parsa.exampreparation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstCookie", value = "/first-cookie")
public class FirstCookie extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf8");
        try (PrintWriter writer = response.getWriter()) {
            String name = request.getParameter("name");
            Cookie cookie = new Cookie("name", name);
            response.addCookie(cookie);
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang='en'>");
            writer.println("<head><title> First Cookie </title></head>");
            writer.println("<body>");
            writer.println("<h1> your name is " + name + "</h1>");
            writer.println("<a href='/exam_preparation_war_exploded/second-cookie'> Second cookie page </a>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    @Override
    public String getServletInfo() {
        return "First Cookie Servlet";
    }
}
