package com.resultsapi.resultsAPI.repository;

import com.resultsapi.resultsAPI.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    List<Choice> findChoicesByPollId(Long pollId);
}
