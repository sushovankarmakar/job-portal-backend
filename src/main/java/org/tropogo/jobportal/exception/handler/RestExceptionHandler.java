package org.tropogo.jobportal.exception.handler;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.tropogo.jobportal.exception.*;
import org.tropogo.jobportal.exception.model.CustomError;
import org.tropogo.jobportal.exception.model.CustomErrorResponse;
import org.tropogo.jobportal.exception.model.Violation;
import org.tropogo.jobportal.exception.model.ViolationErrorResponse;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * DESCRIPTION :
 * {@code RestExceptionHandler} class is responsible for handling various exceptions generated in this programme
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */


@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * handleJobCreationException method handles JobCreationException
     * @param jobCreationException
     * @param webRequest
     * @return CustomErrorResponse
     */

    @ExceptionHandler(value = {JobCreationException.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CustomErrorResponse handleJobCreationException(JobCreationException jobCreationException, WebRequest webRequest) {

        List<CustomError> errors = new ArrayList<>();
        errors.add(CustomError.builder()
                .code(INTERNAL_SERVER_ERROR.value())
                .status(INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(jobCreationException.getMessage())
                .build());


        return CustomErrorResponse.builder()
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * handleJobSearchException method handles JobSearchException
     * @param jobSearchException
     * @param webRequest
     * @return CustomErrorResponse
     */

    @ExceptionHandler(value = {JobSearchException.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CustomErrorResponse handleJobSearchException(JobSearchException jobSearchException, WebRequest webRequest) {

        List<CustomError> errors = new ArrayList<>();
        errors.add(CustomError.builder()
                .code(INTERNAL_SERVER_ERROR.value())
                .status(INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(jobSearchException.getMessage())
                .build());

        return CustomErrorResponse.builder()
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * handleConstraintValidationException method handles constraintViolationException
     * @param constraintViolationException
     * @return ViolationErrorResponse
     */

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    ViolationErrorResponse handleConstraintValidationException(ConstraintViolationException constraintViolationException) {

        List<Violation> violations = new ArrayList<>();
        for (ConstraintViolation violation : constraintViolationException.getConstraintViolations()) {
            violations.add(Violation.builder()
                    .fieldName(violation.getPropertyPath().toString())
                    .message(violation.getMessage())
                    .build());
        }

        return ViolationErrorResponse.builder()
                .violations(violations)
                .code(BAD_REQUEST.value())
                .status(BAD_REQUEST.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * handleMethodArgumentNotValidException method handles methodArgumentNotValidException
     *
     * @param methodArgumentNotValidException
     * @return ViolationErrorResponse
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    ViolationErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        List<Violation> violations = new ArrayList<>();
        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            violations.add(Violation.builder()
                    .fieldName(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build());
        }

        return ViolationErrorResponse.builder()
                .violations(violations)
                .code(BAD_REQUEST.value())
                .status(BAD_REQUEST.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
