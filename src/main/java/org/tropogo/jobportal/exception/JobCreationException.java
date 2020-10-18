package org.tropogo.jobportal.exception;

import lombok.Getter;
import org.tropogo.jobportal.constant.ErrorCode;

@Getter
public class JobCreationException extends RuntimeException {

    private final Exception exception;
    private final String message;

    public JobCreationException(ErrorCode errorCode, Exception exception) {
        super(errorCode.getMessage(), exception);
        this.exception = exception;
        this.message = errorCode.getMessage();
    }
}
