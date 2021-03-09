package com.example.JavaEE_Assignment4.first_task.second_part;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("first_task/second_part/link.html").include(request, response);

        Cookie ck[]=request.getCookies();
        if (ck!=null) {
            String name=ck[0].getValue();
            if (!name.equals("")||name!=null) {
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, "+name);
            }
        } else {
            out.print("Please login first");
            request.getRequestDispatcher("first_task/second_part/login.html").include(request, response);
        }

        out.close();
    }
}
