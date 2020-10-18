package org.tropogo.jobportal.factory;

import org.tropogo.jobportal.entity.Job;
import org.tropogo.jobportal.exchange.JobCreationRequest;
import org.tropogo.jobportal.exchange.JobCreationResponse;
import org.tropogo.jobportal.exchange.JobSearchResponse;

import java.util.Date;
import java.util.List;

import static org.tropogo.jobportal.constant.SuccessCode.JOB_CREATION_SUCCESS;

public class TestObjectsFactory {

    public static JobCreationRequest getJobCreationRequest() {
        return JobCreationRequest.builder()
                .company("tropogo")
                .description("software developer with spring boot knowledge")
                .experienceRange("0-2 years")
                .location("bengaluru")
                .postedBy("rohan")
                .postedDate(new Date())
                .salaryRange("10-15L")
                .title("software developer")
                .build();
    }

    public static JobCreationResponse getJobCreationResponse() {
        return JobCreationResponse.builder()
                .message(JOB_CREATION_SUCCESS.getMessage())
                .build();
    }

    public static JobSearchResponse getJobSearchResponse() {
        List<Job> jobs = getListOfJobs();

        return JobSearchResponse.builder()
                .numberOfJobs(1)
                .jobs(jobs)
                .build();
    }

    public static List<Job> getListOfJobs() {
        return List.of(getJob());
    }

    public static Job getJob() {
        return Job.builder()
                .id(1L)
                .company("abc")
                .description("candidate should know automation")
                .experienceRange("0-2 years")
                .location("noida")
                .postedBy("joe")
                .postedDate(new Date())
                .salaryRange("20-30L")
                .title("automation engineer")
                .build();
    }
}
