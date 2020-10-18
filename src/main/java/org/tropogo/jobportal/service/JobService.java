package org.tropogo.jobportal.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.tropogo.jobportal.exchange.JobCreationRequest;
import org.tropogo.jobportal.exchange.JobCreationResponse;
import org.tropogo.jobportal.exchange.JobSearchResponse;

import javax.validation.Valid;

@Service
@Validated
public interface JobService {

    JobCreationResponse createJob(@Valid JobCreationRequest jobCreationRequest);

    JobSearchResponse getJob();
}
