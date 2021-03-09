package com.example.JavaEE_Assignment4.fourth_task.second_part;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("fourth_task/second_part/link.html").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (password.equals("admin123")) {
            out.print("Welcome, " + name);
            HttpSession session=request.getSession();
            session.setAttribute("name",name);
        } else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("fourth_task/second_part/login.html").include(request, response);
        }
        out.close();
    }
}
