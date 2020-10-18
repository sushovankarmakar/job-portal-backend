package org.tropogo.jobportal.exchange;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
@Valid
public class JobCreationRequest {

    @NotBlank(message = "company field is missing")
    private String company;

    @NotBlank(message = "job title field is missing")
    private String title;

    @NotBlank(message = "job description field is missing")
    private String description;

    @NotBlank(message = "job location field is missing")
    private String location;

    @NotBlank(message = "job experience range field is missing")
    private String experienceRange;

    @NotBlank(message = "salary range field is missing")
    private String salaryRange;

    @NotBlank(message = "postedBy field is missing")
    private String postedBy;

    private Date postedDate;
}
