package org.tropogo.jobportal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * DESCRIPTION :
 * {@code Job} class represents an entity which stores all the details related to a particular job
 *
 * The details are as followed -
 * 1. id - job id which is unique throughout the database
 * 2. company - name of the company who has posted this job
 * 3. title - title of the job
 * 4. description - detailed explanation and requirements for this job
 * 5. location - location of this job
 * 6. experience range - experience range this job demands
 * 7. salary range - salary range this job can offer
 * 8. posted by - name of the job poster
 * 9. posted date - date on which this job was posted
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

@Entity
@Builder
@Table(name = "JOB_HISTORY", schema = "TROPOGO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String company;
    private String title;
    private String description;
    private String location;
    private String experienceRange;
    private String salaryRange;
    private String postedBy;
    private Date postedDate;
}