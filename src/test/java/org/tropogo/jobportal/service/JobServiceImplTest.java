package org.tropogo.jobportal.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.tropogo.jobportal.converter.JobPostingRequestToJobConverter;
import org.tropogo.jobportal.exception.JobCreationException;
import org.tropogo.jobportal.exception.JobSearchException;
import org.tropogo.jobportal.exchange.JobCreationRequest;
import org.tropogo.jobportal.exchange.JobCreationResponse;
import org.tropogo.jobportal.exchange.JobSearchResponse;
import org.tropogo.jobportal.repository.JobRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.tropogo.jobportal.factory.TestObjectsFactory.*;

@ActiveProfiles("test")
class JobServiceImplTest {

    @InjectMocks
    private JobServiceImpl jobService;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private JobPostingRequestToJobConverter converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createJobTest_WhenJobCreationSuccessful() {
        when(converter.convert(any(JobCreationRequest.class)))
                .thenReturn(getJob());

        assertEquals(JobCreationResponse.class,
                jobService.createJob(getJobCreationRequest()).getClass());
    }

    @Test
    void createJobTest_WhenJobCreationUnSuccessful() {
        when(converter.convert(any(JobCreationRequest.class)))
                .thenReturn(null);

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
