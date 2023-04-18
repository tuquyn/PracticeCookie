package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieExample", value = "/CookieExample")
public class CookieExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // print out cookies

        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            String name = c.getName();
            String value = c.getValue();
            out.println("Name: " + name + "<br>");
            out.println("Content: " + value + "<br>");
        }

        out.println("<hr>");

        // set a cookie

        String name = request.getParameter("cName");
        if (name != null && name.length() > 0) {
            String value = request.getParameter("cValue");
            Cookie c = new Cookie(name, value);
            c.setMaxAge(-1);
            response.addCookie(c);
            out.println("Set a new cookie:<br>");
            out.println("Name: " + c.getName() + "<br>");
            out.println("Cookie value: " + c.getValue() + "<br>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
