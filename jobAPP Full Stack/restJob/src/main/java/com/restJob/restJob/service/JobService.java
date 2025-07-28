package com.restJob.restJob.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restJob.restJob.model.JobPost;
import com.restJob.restJob.repo.jobRepo;


@Service
public class JobService {
    @Autowired
    private jobRepo repo;

    public List<JobPost> getAllJobs()
    {
        return repo.findAll();
    }

    public void addJob(JobPost jobpost)
    {
        repo.save(jobpost);
    }

    public JobPost getJob(int jobId) {
        return repo.findById(jobId).orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int id)
    {
        repo.deleteById(id);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        for (JobPost i: jobs)
            repo.save(i);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
