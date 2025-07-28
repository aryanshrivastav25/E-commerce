package com.restJob.restJob.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restJob.restJob.model.JobPost;



@Repository
public interface jobRepo extends JpaRepository<JobPost, Integer>
{
        // @Query("select job from JobPost job where postProfile like %?1% or postDesc like %?2%")
    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}

// private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//             new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                     List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//             new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//                     List.of("HTML", "CSS", "JavaScript", "React")),
//             new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                     List.of("Python", "Machine Learning", "Data Analysis")),
//             new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                     List.of("Networking", "Cisco", "Routing", "Switching")),
//             new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
//                     List.of("iOS Development", "Android Development", "Mobile App"))
//     ));


//     public List<JobPost> getAllJobs()
//     {
//         System.out.println(jobs);
//         return jobs;
//     }

//     public void addJob(JobPost jobPost)
//     {
//         jobs.add(jobPost);
//         System.out.println(jobs);
//     }

//     public JobPost getJob(int jobId) 
//     {
//         for (JobPost job : jobs)
//         {
//             if (job.getPostId() == jobId)
//                 return job;
//         }

//         return null;
//     }

//     public void updateJob(JobPost job) 
//     {
//         for (int i = 0; i < jobs.size(); i++)
//         {
//                 if (jobs.get(i).getPostId() == job.getPostId())
//                 {
//                         jobs.get(i).setPostDesc((job.getPostDesc()));
//                         jobs.get(i).setPostId(job.getPostId());
//                         jobs.get(i).setPostProfile(job.getPostProfile());
//                         jobs.get(i).setPostTechStack(job.getPostTechStack());
//                         jobs.get(i).setReqExperience(job.getReqExperience());
//                 }
//         }
//     }


//     public void deleteJob(int id)
//     {
//         for (JobPost job : jobs)
//         {
//                 if (job.getPostId() == id)
//                 {
//                         jobs.remove(job);
//                         return;
//                 }
//         }
//     }
