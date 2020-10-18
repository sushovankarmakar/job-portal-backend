package org.tropogo.jobportal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.tropogo.jobportal.exchange.JobCreationRequest;
import org.tropogo.jobportal.service.JobService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.tropogo.jobportal.factory.TestObjectsFactory.*;

@WebMvcTest(controllers = JobController.class)
@ActiveProfiles("test")
public class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JobService jobService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createJobTest_whenNonNullResponseThenReturnOK() throws Exception {

        RequestBuilder requestBuilder =
                post("/tropogo/createJobs")
                        .content(objectMapper.writeValueAsString(getJobCreationRequest()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON);

        when(jobService.createJob(any(JobCreationRequest.class)))
                .thenReturn(getJobCreationResponse());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    void createJobTest_whenNullResponseThenReturnNotFound() throws Exception {

        RequestBuilder requestBuilder =
                post("/tropogo/createJobs")
                        .content(objectMapper.writeValueAsString(getJobCreationRequest()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON);

        when(jobService.createJob(any(JobCreationRequest.class)))
                .thenReturn(null);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound());
    }

    @Test
    void getJob_whenNonNullResponseThenReturnOK() throws Exception {

        RequestBuilder requestBuilder =
                get("/tropogo/jobs");

        when(jobService.getJob())
                .thenReturn(getJobSearchResponse());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    void getJob_whenNullResponseThenReturnNotFound() throws Exception {

        RequestBuilder requestBuilder =
                get("/tropogo/jobs");

        when(jobService.getJob())
                .thenReturn(null);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound());
    }
}
