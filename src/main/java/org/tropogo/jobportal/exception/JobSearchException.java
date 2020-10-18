package org.tropogo.jobportal.exception;

import lombok.Getter;
import org.tropogo.jobportal.constant.ErrorCode;

@Getter
public class JobSearchException extends RuntimeException {

    private final Exception exception;
    private final String message;

    public JobSearchException(ErrorCode errorCode, Exception exception) {
        super(errorCode.getMessage(), exception);
        this.exception = exception;
        this.message = errorCode.getMessage();
    }
}
