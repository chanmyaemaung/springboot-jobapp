package dev.chanmyaemaung.JobApp.controller;

import dev.chanmyaemaung.JobApp.model.JobPost;
import dev.chanmyaemaung.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping({"/", "home"})
    public String index() {
        return "index";
    }

    @GetMapping("jobs")
    public String jobs(Model model) {
        List<JobPost> jobs = jobService.getAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "jobs";
    }

    @GetMapping("add-job")
    public String addJob() {
        return "add-job";
    }

    @PostMapping("handle-form")
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }
}
