package com.parsa.exampreparation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ThirdServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<html>");
            writer.println("<head><title> title </title> </head>");
            writer.println("<body>");
            writer.println("<h1> this is a HttpServlet </h1>");
            writer.println("<h1> this servlet is at " + request.getContextPath() + "</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "servlet";
    }
}
