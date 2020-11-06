package org.tropogo.jobportal.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.tropogo.jobportal.factory.TestObjectsFactory.*;

@ActiveProfiles("test")
class JobServiceImplTest {

    @InjectMocks
    private JobServiceImpl jobService;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @Mock
    private JobPostingRequestToJobEntityConverter converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createJobTest_WhenJobCreationSuccessful() {
        when(converter.convert(any(JobCreationRequest.class))).thenReturn(getJob());

        List<Job> jobs = new ArrayList<>();

        when(user.getJobs()).thenReturn(jobs);

        when(userRepository.findById(any())).thenReturn(getUser());

        assertEquals(JobCreationResponse.class,
                jobService.createJob(getJobCreationRequest()).getClass());
    }

    @Test
    void createJobTest_WhenJobCreationUnSuccessful() {
        when(converter.convert(any(JobCreationRequest.class)))
                .thenReturn(getJob());

        assertThrows(JobCreationException.class, () -> {
            jobService.createJob(getJobCreationRequest());
        });
    }

    @Test
    void getJobTest_WhenJobSearchSuccessful() {

        assertEquals(JobSearchResponse.class,
                jobService.getJob().getClass());
    }

    @Test
    void getJobTest_WhenJobSearchUnSuccessful() {

        when(jobRepository.findAll())
                .thenReturn(null);

        assertThrows(JobSearchException.class, () -> {
            jobService.getJob();
        });
    }

}
