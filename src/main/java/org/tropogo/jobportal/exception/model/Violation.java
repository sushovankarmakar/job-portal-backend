package org.tropogo.jobportal.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Violation {

    @JsonProperty("field")
    private String fieldName;

    @JsonProperty("message")
    private String message;
}
