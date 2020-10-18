package org.tropogo.jobportal.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.WebRequest;
import org.tropogo.jobportal.exception.handler.RestExceptionHandler;
import org.tropogo.jobportal.exception.model.CustomErrorResponse;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tropogo.jobportal.constant.ErrorCode.*;

@ActiveProfiles("test")
class RestExceptionHandlerTest {

    @InjectMocks
    private RestExceptionHandler handler;

    @MockBean
    private WebRequest webRequest;

    @MockBean
    private ConstraintViolationException constraintViolationException;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testHandleJobCreationException() {
        assertEquals(CustomErrorResponse.class, handler.handleJobCreationException(
                new JobCreationException(JOB_CREATION_FAILURE, new Exception()), webRequest).getClass());
    }

    @Test
    void testHandleJobSearchException() {
        assertEquals(CustomErrorResponse.class, handler.handleJobSearchException(
                new JobSearchException(JOB_SEARCH_FAILURE, new Exception()), webRequest).getClass());
    }

    /*@Test
    void testHandleConstraintValidationException() {
        assertEquals(ViolationErrorResponse.class,
                handler.handleConstraintValidationException(constraintViolationException).getClass());
    }*/

}
