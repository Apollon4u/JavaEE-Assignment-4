package com.example.JavaEE_Assignment4.first_task.second_part;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("first_task/second_part/link.html").include(request, response);

        String name=request.getParameter("name");
        String password=request.getParameter("password");

        if (password.equals("admin123")) {
            out.print("You are successfully logged in!");
            out.print("<br>Welcome, "+name);

            Cookie ck=new Cookie("name",name);
            response.addCookie(ck);
        } else {
            out.print("sorry, username or password error!");
            request.getRequestDispatcher("first_task/second_part/login.html").include(request, response);
        }

        out.close();
    }

}
