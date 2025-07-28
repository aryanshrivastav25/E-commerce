package com.servletdemo;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println("Hello, world");
		Tomcat tomcat = new Tomcat();
		
		Context context = tomcat.addContext("", null);
		Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
		tomcat.setPort(8080);

		// Mapping servlet to the url
		context.addServletMappingDecoded("/hello", "HelloServlet"); // URL and the name of servlet as parameter

		tomcat.start();
		tomcat.getServer().await();
    }
}
