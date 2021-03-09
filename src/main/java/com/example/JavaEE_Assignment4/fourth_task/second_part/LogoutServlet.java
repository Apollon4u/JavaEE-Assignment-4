package com.example.JavaEE_Assignment4.fourth_task.second_part;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("fourth_task/second_part/link.html").include(request, response);

        HttpSession session = request.getSession();
        session.invalidate();

        out.print("You are successfully logged out!");

        out.close();
    }
}