package com.parsa.exampreparation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookiePolicy;

@WebServlet(name = "LoginCookie", value = "/login-cookie")
public class LoginCookie extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            boolean isLoggedIn = false;
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies) {
                if (cookie.getName().equals("login")){
                    isLoggedIn = true;
                    break;
                }
            }

            if (!isLoggedIn) {
                String username = request.getParameter("username");


                String password = request.getParameter("password");

                if (username !=null && password != null && username.equalsIgnoreCase("parsa") && password.equals("hello")) {
                    Cookie new_cookie = new Cookie("login", username);
                    response.addCookie(new_cookie);
                    request.getRequestDispatcher("linkscookie.html").include(request, response);
                    writer.println("<h2 style='background-color:green;>" + username + " has logged in successfully </h2>");
                } else {
                    System.out.println("username or password is wrong");
                    writer.println("<h2 style='color:red;'> username or password is not valid </h2>");
                    request.getRequestDispatcher("logincookie.html").include(request,response);
                }

            }
            writer.println("<!DOCTYPE html>");
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
        return "cookie servlet";
    }
}
