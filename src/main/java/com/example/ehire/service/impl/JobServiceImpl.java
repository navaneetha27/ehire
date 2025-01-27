package com.example.ehire.service.impl;

import com.example.ehire.model.Job;

import java.util.List;

public interface JobServiceImpl {
    public  void postJob(Job job);
    public List<Job> getAllJobs();
    public Job getJobById(Long id);

    boolean deleteJobById(Long jobId);

    boolean updateJob(Long jobId, Job updatedJob);
}
