package com.parsa.exampreparation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowProfileCookie", value = "/show-profile")
public class ShowProfileCookie extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()){
            boolean isLoggedIn = false;
            String username = "";
            Cookie[] cookies = request.getCookies();

            for(Cookie cookie:cookies) {
                if (cookie.getName().equals("login")){
                    username = cookie.getValue();
                    isLoggedIn = true;
                    break;
                }
            }

            if (!isLoggedIn) {
                writer.println("<h1 style='color:red;'> username or password is not valid </h1>");
                request.getRequestDispatcher("logincookie.html").include(request,response);
            } else {
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<head>");
                writer.println("<title>Servlet ShowProfileCookie</title>");
                writer.println("</head>");
                writer.println("<body>");
                request.getRequestDispatcher("linkscookie.html").include(request, response);
                writer.println("<h1>Profile of " + username + "</h1>");
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
        return "ShowProfile";
    }
}
