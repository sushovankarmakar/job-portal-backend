package org.tropogo.jobportal.constant;

import lombok.Getter;

@Getter
public enum SuccessCode {

    USER_CREATION_SUCCESS("Your user account has been created successfully"),
    JOB_CREATION_SUCCESS("Job creation is successful");

    private final String message;

    SuccessCode (String message) {
        this.message = message;
    }
}
