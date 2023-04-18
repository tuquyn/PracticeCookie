package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleCookie", value = "/SimpleCookie")
public class SimpleCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        Cookie cookie = new Cookie("Cookies_Name", "123456");
        cookie.setMaxAge(100);
        cookie.setPath(request.getContextPath());
        cookie.setDomain(request.getServerName());

        response.addCookie(cookie);

        out.println("<body style=\"background-color:powderblue;\">");
        out.println("<b>This is a cookie example</b><br>");
        out.println("Name: " + cookie.getName() + "<br>");
        out.println("Value: " + cookie.getValue() + "<br>");
        out.println("Path: " + cookie.getPath() + "<br>");
        out.println("Domain: " + request.getRequestURL().toString() + "<br>");
        out.println(cookie.getDomain());
        out.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
