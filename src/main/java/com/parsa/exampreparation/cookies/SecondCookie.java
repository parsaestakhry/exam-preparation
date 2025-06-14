package com.parsa.exampreparation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondCookie", value = "/second-cookie")
public class SecondCookie extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset='utf8   '");
        try(PrintWriter writer = response.getWriter()) {
            Cookie[] cookies = request.getCookies();
            String username = "not entered";
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("name")) {
                    username = cookie.getValue();
                    break;
                }
            }
            writer.println("<html>");
            writer.println("<head><title>Second Cookie </title></head>");
            writer.println("<body>");
            writer.println("<h1 style='background-color:red;'> your name is  " + username + "</h1>");
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
        processRequest(req, resp);
    }


    @Override
    public String getServletInfo() {
        return "Second Cookie";
    }
}


