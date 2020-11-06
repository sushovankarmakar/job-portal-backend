package org.tropogo.jobportal.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@Valid
public class JobCreationRequest {

    @JsonProperty("company")
    @NotBlank(message = "company field is missing")
    private String company;

    @JsonProperty("title")
    @NotBlank(message = "job title field is missing")
    private String title;

    @JsonProperty("description")
    @NotBlank(message = "job description field is missing")
    private String description;

    @JsonProperty("location")
    @NotBlank(message = "job location field is missing")
    private String location;

    @JsonProperty("experienceRange")
    @NotBlank(message = "job experience range field is missing")
    private String experienceRange;

    @JsonProperty("salaryRange")
    @NotBlank(message = "salary range field is missing")
    private String salaryRange;

    @JsonProperty("recruiterId")
    @NotNull
    private Long recruiterId;

    @JsonProperty("postedDate")
    private Date postedDate;
}
