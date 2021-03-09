package com.example.JavaEE_Assignment4.fourth_task.second_part;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("fourth_task/second_part/link.html").include(request, response);

        HttpSession session=request.getSession(false);

        if (session != null) {
            String name = (String)session.getAttribute("name");
            out.print("Hello, " + name +" Welcome to Profile");
        } else {
            out.print("Please login first");
            request.getRequestDispatcher("fourth_task/second_part/login.html").include(request, response);
        }

        out.close();
    }
}
