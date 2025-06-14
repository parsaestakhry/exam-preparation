package com.parsa.exampreparation.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstSession", value = "/first-session")
public class FirstSession extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()){
            String username = request.getParameter("username");
            HttpSession session = request.getSession(false);
            if (session == null) {
                session = request.getSession();
            }

            session.setAttribute("username", username);

            writer.println("<html>");
            writer.println("<head><title> title </title></head>");
            writer.println("<h1 style='color:red;'> your username is  " + username + "</h1>");
            writer.println("<a href='"+request.getContextPath()+"/secondsession'>Second Page</a>");
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
        return "servlet";
    }
}
