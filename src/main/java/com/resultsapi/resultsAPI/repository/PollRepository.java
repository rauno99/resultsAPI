package com.resultsapi.resultsAPI.repository;

import com.resultsapi.resultsAPI.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PollRepository extends JpaRepository<Poll, Long> {
    Optional<Poll> findPollByActive(Boolean active);
}
