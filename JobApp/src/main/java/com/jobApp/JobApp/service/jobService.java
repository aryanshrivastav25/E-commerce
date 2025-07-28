package com.jobApp.JobApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobApp.JobApp.model.JobPost;
import com.jobApp.JobApp.repo.jobRepo;


@Service
public class jobService {
    @Autowired
    private jobRepo repo;

    public List<JobPost> getAllJobs()
    {
        return repo.getAllJobs();
    }

    public void addJob(JobPost jobpost)
    {
        repo.addJob(jobpost);
    }
}
