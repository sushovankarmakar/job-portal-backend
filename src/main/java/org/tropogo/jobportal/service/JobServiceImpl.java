package org.tropogo.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.tropogo.jobportal.converter.JobPostingRequestToJobEntityConverter;
import org.tropogo.jobportal.entity.Job;
import org.tropogo.jobportal.entity.User;
import org.tropogo.jobportal.exception.JobCreationException;
import org.tropogo.jobportal.exception.JobSearchException;
import org.tropogo.jobportal.exchange.JobCreationRequest;
import org.tropogo.jobportal.exchange.JobCreationResponse;
import org.tropogo.jobportal.exchange.JobSearchResponse;
import org.tropogo.jobportal.repository.JobRepository;
import org.tropogo.jobportal.repository.UserRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.tropogo.jobportal.constant.ErrorCode.*;
import static org.tropogo.jobportal.constant.SuccessCode.*;

/**
 * DESCRIPTION :
 * {@code JobServiceImpl} class is the implementation of JobService interface
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

@Service
@Validated
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JobPostingRequestToJobEntityConverter converter;

    /**
     * createJob() method creates jobs
     * @param jobCreationRequest
     * @return JobCreationResponse
     */

    @Override
    public JobCreationResponse createJob(@Valid JobCreationRequest jobCreationRequest) {

        if (Objects.isNull(jobCreationRequest.getPostedDate())) {
            jobCreationRequest.setPostedDate(new Date());
        }

        Job job = Objects.requireNonNull(converter.convert(jobCreationRequest),
                JOB_CREATION_IS_NULL.getMessage());

        userRepository.findById(jobCreationRequest.getRecruiterId())
                .ifPresentOrElse(
                        user -> {
                            user.getJobs().add(job);
                        },
                        () -> {
                            throw new JobCreationException(USER_ID_NOT_FOUND);
                        }
                );

        try {
            jobRepository.save(job);
        } catch (IllegalArgumentException exception) {
            throw new JobCreationException(JOB_CREATION_FAILURE);
        }

        return JobCreationResponse.builder()
                .message(JOB_CREATION_SUCCESS.getMessage())
                .build();
    }

    /**
     * getJob() method searches all the jobs present in the database
     * @return JobSearchResponse
     */

    @Override
    public JobSearchResponse getJob() {
        try {
            List<Job> allJobs = Objects.requireNonNull(jobRepository.findAll(),
                    LIST_OF_JOBS_IS_NULL.getMessage());

            return JobSearchResponse.builder()
                    .numberOfJobs(allJobs.size())
                    .jobs(allJobs)
                    .build();
        } catch (Exception exception) {
            throw new JobSearchException(JOB_SEARCH_FAILURE, exception);
        }
    }
}
