package com.jobApp.JobApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobApp.JobApp.model.JobPost;
import com.jobApp.JobApp.service.jobService;


@Controller
public class jobController 
{
    @Autowired
    jobService service;

    @RequestMapping({"/", "/home"})
    public String home() {
        return "home";
    }
        

    @RequestMapping("/addjob")
    public String addJob()
    {
        return "addjob";
    }

    @RequestMapping("/viewalljobs")
    public String viewalljobs(Model m)
    {
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }

    @PostMapping("/handleForm")
    public String handleForm(JobPost jobPost) // The data given by the form will be passed as object and fetched using POST method. 
    {
        service.addJob(jobPost);
        return "success";
    }
}
