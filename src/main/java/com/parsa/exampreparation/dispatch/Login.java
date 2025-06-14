package com.parsa.exampreparation.dispatch;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Login" , value = "/login-disp")
public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {
                if (username.equalsIgnoreCase("parsa") && password.equalsIgnoreCase("hello")) {
                    request.setAttribute("user", "parsa");
                    request.getRequestDispatcher("linkscookie.html").include(request,response);
                } else {
                    writer.println("<h2 style='color:red;'> username or password is wrong </h2>");
                    request.getRequestDispatcher("logincookie.html").include(request, response);
                }
            } else {
                writer.println("<h2 style='color:red;'> username or password is wrong </h2>");
                request.getRequestDispatcher("logincookie.html").include(request, response);
            }
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
        return "Login Dispatcher";
    }
}
