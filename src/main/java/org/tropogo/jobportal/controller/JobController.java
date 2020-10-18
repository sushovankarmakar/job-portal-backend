package org.tropogo.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tropogo.jobportal.exchange.JobCreationRequest;
import org.tropogo.jobportal.exchange.JobCreationResponse;
import org.tropogo.jobportal.exchange.JobSearchResponse;
import org.tropogo.jobportal.service.JobService;

import javax.validation.Valid;
import java.util.Objects;

import static org.tropogo.jobportal.constant.EndPointURLs.*;

/**
 * DESCRIPTION :
 * {@code JobController} class is the rest controller class which exposes two end points
 * 1. "/createJobs"
 * 2. "/jobs"
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

@RestController
@RequestMapping("/tropogo")
public class JobController {

    @Autowired
    JobService jobService;

    /**
     * {@code createJob} method is responsible for creating jobs
     * @param  request
     * @return JobCreationResponse which is embedded with ResponseEntity
     */

    @PostMapping(path = CREATE_JOBS_ENDPOINT)
    public ResponseEntity<JobCreationResponse> createJob(@Valid @RequestBody JobCreationRequest request) {
        JobCreationResponse response = jobService.createJob(request);

        return Objects.isNull(response) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(response);
    }

    /**
     * {@code getJob} method is responsible for searching jobs
     * @return JobSearchResponse which is embedded with ResponseEntity
     */

    @GetMapping(path = SEARCH_JOBS_ENDPOINT, produces = "application/json; charset=UTF-8")
    public ResponseEntity<JobSearchResponse> getJob() {
        JobSearchResponse response = jobService.getJob();

        return Objects.isNull(response) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(response);
    }
}
