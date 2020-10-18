package org.tropogo.jobportal.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.tropogo.jobportal.entity.Job;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tropogo.jobportal.factory.TestObjectsFactory.getJobCreationRequest;

@ActiveProfiles("test")
class JobPostingRequestToJobConverterTest {

    @InjectMocks
    private JobPostingRequestToJobConverter converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void convertTest() {
        assertEquals(Job.class, converter.convert(getJobCreationRequest()).getClass());
    }
}
