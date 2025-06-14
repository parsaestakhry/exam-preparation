package com.parsa.exampreparation.hidden;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondHidden", value = "/second-hidden")
public class SecondHidden  extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()){
            String username = request.getParameter("username");
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Servlet SecondCookie</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1 style='color:lightgreen;'>Your Name is " + username + "</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }


    @Override
    public String getServletInfo() {
        return "servlet info";
    }
}
