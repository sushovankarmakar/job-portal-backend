package org.tropogo.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tropogo.jobportal.entity.Job;

/**
 * DESCRIPTION :
 * This is the repository layer.
 * {@code JobRepository} interface is responsible for storing the jobs in the PostgreSQL database
 *
 * @author Sushovan Karmakar
 * @version 0.0.1
 */

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
