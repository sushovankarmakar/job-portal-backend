package org.tropogo.jobportal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "USER", schema = "TROPOGO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ID", unique = true)
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @OneToMany(targetEntity = Job.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_JOB_FK", referencedColumnName = "USER_ID")
    private List<Job> jobs;
}
