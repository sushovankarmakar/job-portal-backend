package org.tropogo.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tropogo.jobportal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
