package com.springBootProject.springBootProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
    // By default, spring boot does not support JSP, so we need to add a dependency "Tomcat Jasper"
    @RequestMapping("/")
    public String home()
    {
        System.out.println("Home method called");
        return "index";
    }

    @RequestMapping("/add")
    // public String add(HttpServletRequest req, HttpSession session)
    // {
    //     int a = Integer.parseInt(req.getParameter("num1"));
    //     int b = Integer.parseInt(req.getParameter("num2"));
    //     int result = a + b;
    //     System.out.println(result);
    //     System.out.println("Add method called");


    // If parameter name is same as the request parameter passed by the client(num1 and num2), then direct conversion happens
    // Otherwise we need to use "public String add(@RequestParam("num1"), int num, int num2)", here num will take the parameter value num1, and num2 gets mapped to num2
    // public String add(int num1, int num2, HttpSession session)
    // {
    //     int result = num1 + num2 + 1;
    //     System.out.println(result);
    //     System.out.println("Add method called");

    //     session.setAttribute("result", result); // Name of the data and its value, which will be used in the add.jsp page.
    //     return "add.jsp";
    // }

    // Instead of HttpSession, we can use Model object to transfer data between Controller and View.
    // public String add(int num1, int num2, Model model)
    // {
    //     int result = num1 + num2 + 1;
    //     System.out.println(result);
    //     System.out.println("Add method called");

    //     model.addAttribute("result", result); // Name of the data and its value, which will be used in the add.jsp page.
    //     return "add";
    // }

    public ModelAndView add(int num1, int num2, ModelAndView mv)
    {
        int result = num1 + num2 + 1;
        System.out.println(result);
        System.out.println("Add method called");

        mv.addObject("result", result); // Name of the data and its value, which will be used in the add.jsp page.
        mv.setViewName("add");
        return mv;
    }

    @RequestMapping("/addAlien")
    // Adding @ModelAttribute, removes the need for ModelAndView, this object is automatically sent to the jsp page
    // When typed "${alien}" in jsp page, it automatically calls the toString method
    // If we do not use @ModelAttribute, then also it will work, but then we name used in jsp page should same as alien not alien1 or anything else.
    // Using ModelView("name"), we can specify the name of the object to be used in the jsp page
    public String addAlien(@ModelAttribute("alien") Alien alien)
    {
        // Alien alien = new Alien();
        // alien.setAid(id);
        // alien.setAname(name);

        System.out.println("Add Alien method called");

        
        return "addAlien";
    }

    // When we use the value "course" in jsp page, it automatically plugs in the return value of this function
    // Works on all jsp files.
    @ModelAttribute("course")
    public String courseName()
    {
        return "Java";
    }
}

// All the requests are handled by Dispatcher which maps them with servlets
// Session: When user access multiple pages, then the data sent by the user to the server needs to be maintained betweena all pages, these are maintained by HttpSession Object.
