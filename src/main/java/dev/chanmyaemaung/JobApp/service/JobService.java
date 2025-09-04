package dev.chanmyaemaung.JobApp.service;

import dev.chanmyaemaung.JobApp.model.JobPost;
import dev.chanmyaemaung.JobApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public JobPost getJob(int postId) {
        return jobRepo.getJob(postId);
    }

    public void updateJobPost(int postId, JobPost jobPost) {
        jobRepo.updateJobPost(postId, jobPost);
    }

    public void deleteJobPost(int postId) {
        jobRepo.deleteJob(postId);
    }
}
