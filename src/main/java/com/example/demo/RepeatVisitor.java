package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RepeatVisitor", value = "/RepeatVisitor")
public class RepeatVisitor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        boolean newbie = true;
        Cookie[] cookies = request.getCookies();
        Integer cVisit = 0;

        if (cookies != null) {
            for(int i=0; i<cookies.length; i++) {
                Cookie c = cookies[i];
                if ((c.getName().equals("repeatVisitor"))) {
                    Integer temp = Integer.parseInt(c.getValue());
                    temp++;
                    cVisit = temp;
                    newbie = false;
                    break;
                }
            }
        }


        String title;
        if (newbie) {
            Cookie returnVisitorCookie = new Cookie("repeatVisitor", "0");
            returnVisitorCookie.setMaxAge(-1);
            response.addCookie(returnVisitorCookie);
            title = "Welcome Aboard";
        } else {
            Cookie returnVisitorCookie = new Cookie("repeatVisitor", cVisit.toString());
            returnVisitorCookie.setMaxAge(-1);
            response.addCookie(returnVisitorCookie);
            title = "Welcome Back";
        }


        out.println("<html>");
        out.println("<head><title>" + title + "</title></head>");
        out.println("<body bgcolor=\"#FDF5E6\">");
        out.println("<h1 align=\"center\">" + title + "</h1>");
        out.println("<br>");
        out.println("<center>Counter: " + cVisit +  "</center>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
