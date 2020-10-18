package org.tropogo.jobportal.constant;

import lombok.Getter;

@Getter
public enum ErrorCode {

    JOB_CREATION_FAILURE("Job creation has been failed"),
    JOB_SEARCH_FAILURE("Job search has been failed"),
    JOB_CREATION_IS_NULL("Job creation request should not be null"),
    LIST_OF_JOBS_IS_NULL("List of jobs should not be null");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
