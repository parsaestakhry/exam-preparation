package com.parsa.exampreparation.hidden;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstHidden", value = "/first-hidden")
public class FirstHidden extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try(PrintWriter writer = response.getWriter()) {
            String username = request.getParameter("username");
            if (username != null) {
                writer.println("<html>");
                writer.println("<head><title> title </title></head>");
                writer.println("<body>");
                writer.println("<h1 style='color:green;'> your name is  " + username + "</h1>");
                writer.println("<form action='second-hidden' method='POST'>");
                writer.println("<input type=\"submit\" value=\"Send Name\"/>");
                writer.println("</form>");
                writer.println("</body>");
                writer.println("</html>");


            }
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
        return "Servlet Info";
    }
}
