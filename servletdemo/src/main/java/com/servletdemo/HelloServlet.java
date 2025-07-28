package com.servletdemo;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

    // Executed whenever a request is sent
    // public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {   
        System.out.println("In service");

        res.setContentType("text/html");
        // The client will accept the response sent by the server and the Writer will write to the page
        res.getWriter().println("<h1><b>Hello, world</b></h1>");
    }
}


// By default, the browser uses the GET method.
/*
 * To use specific methods, we can Servlet methods like doGet(), doPost()
 * Otherwise, we can use service() method which by default uses the GET method
 */

