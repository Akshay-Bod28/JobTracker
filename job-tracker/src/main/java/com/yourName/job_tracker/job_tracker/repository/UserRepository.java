package com.yourName.job_tracker.job_tracker.repository;

import com.yourName.job_tracker.job_tracker.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);   
    boolean existsByEmail(String email);
    boolean existsByDisplayName(String displayName);
}
