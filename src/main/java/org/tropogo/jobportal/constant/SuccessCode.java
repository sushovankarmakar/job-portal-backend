package org.tropogo.jobportal.constant;

import lombok.Getter;

@Getter
public enum SuccessCode {

    JOB_CREATION_SUCCESS("Job creation is successful");

    private final String message;

    SuccessCode (String message) {
        this.message = message;
    }
}
