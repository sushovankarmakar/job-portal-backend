package org.tropogo.jobportal.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.tropogo.jobportal.entity.Job;

import java.util.List;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchResponse {

    @JsonProperty("numberOfJobs")
    private final Integer numberOfJobs;

    @JsonProperty("jobs")
    private final List<Job> jobs;
}
