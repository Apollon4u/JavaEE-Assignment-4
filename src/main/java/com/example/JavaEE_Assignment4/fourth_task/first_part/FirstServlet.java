package com.example.JavaEE_Assignment4.fourth_task.first_part;

import java.io.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            out.print("Welcome "+n);

            HttpSession session=request.getSession();
            session.setAttribute("uname",n);

            out.print("<a href='fourth_task-servlet2'>visit</a>");

            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
