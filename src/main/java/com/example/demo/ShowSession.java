package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ShowSession", value = "/ShowSession")
public class ShowSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        Integer accessNum = 0;
        String title;

        if(session == null || session.isNew()){
            session = request.getSession();
            title = "Welcome, Newcomer";
            session.setAttribute("accessNum", accessNum.toString());
        } else if(session.getAttribute("accessNum") == null){
            session = request.getSession();
            title = "Welcome, Newcomer";
            session.setAttribute("accessNum", accessNum.toString());
        } else {
            title = "Welcome back";
            accessNum = Integer.parseInt((String) session.getAttribute("accessNum"));
            session.setAttribute("accessNum", (++accessNum).toString());
        }

        out.println("<html>");
        out.println("<head><title>" + title + "</title></head>");
        out.println("<body bgcolor=\"#FDF5E6\">");
        out.println("<h1 align=\"center\">" + title + "</h1>");
        out.println("<br>");
        out.println("<h2 align=\"center\">Information on your Session:</h2>");
        out.println("<table align=\"center\" border=\"1\">");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<th>Info type</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>" + session.getId() + "</td>");
        out.println("</tr><tr>");
        out.println("<td>Creation time</td>");
        out.println("<td>" + new Date(session.getCreationTime()) + "</td>");
        out.println("</tr><tr>");
        out.println("<td>Time of last access:</td>");
        out.println("<td>" + new Date(session.getLastAccessedTime()) + "</td>");
        out.println("</tr><tr>");
        out.println("<td>Number of previous access</td>");
        out.println("<td>" + (String) session.getAttribute("accessNum") + "</td>");
        out.println("</tr></tbody></table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
