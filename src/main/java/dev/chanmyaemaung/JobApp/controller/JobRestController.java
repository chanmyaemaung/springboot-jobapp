package dev.chanmyaemaung.JobApp.controller;

import dev.chanmyaemaung.JobApp.model.JobPost;
import dev.chanmyaemaung.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobRestController {
    @Autowired
    private JobService jobService;

    // To accept only Json Response
    @GetMapping(path = "api/v1/jobs", produces = {"application/json"})
    public List<JobPost> getAllJobsPosts() {
        return jobService.getAllJobs();
    }

    @GetMapping("api/v1/jobs/{postId}")
    public JobPost getJobPost(@PathVariable int postId) {
        return jobService.getJob(postId);
    }

    @PostMapping("api/v1/add-job")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobPost;
    }

    @PutMapping("api/v1/jobs/{postId}")
    public List<JobPost> updateJob(@PathVariable int postId, @RequestBody JobPost jobPost) {
        jobService.updateJobPost(postId, jobPost);

        return jobService.getAllJobs();
    }

    @DeleteMapping("api/v1/jobs/{postId}")
    public String deleteJobPost(@PathVariable int postId) {
        jobService.deleteJobPost(postId);

        return "You've successfully deleted this job post ID: " + postId;
    }
}
