package org.tropogo.jobportal.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.tropogo.jobportal.entity.Job;
import org.tropogo.jobportal.exchange.JobCreationRequest;

/**
 * DESCRIPTION :
 * {@code JobPostingRequestToJobConverter} class is responsible for converting {@code JobCreationRequest} to {@code Job}
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

@Component
public class JobPostingRequestToJobEntityConverter implements Converter<JobCreationRequest, Job> {

    /**
     * convert method converts {@code JobCreationRequest} to {@code Job}
     * @param request
     * @return job
     */

    @Override
    public Job convert(@NonNull JobCreationRequest request) {
        return Job.builder()
                .company(request.getCompany())
                .description(request.getDescription())
                .experienceRange(request.getExperienceRange())
                .location(request.getLocation())
                .recruiterId(request.getRecruiterId())
                .postedDate(request.getPostedDate())
                .salaryRange(request.getSalaryRange())
                .title(request.getTitle())
                .build();
    }
}
