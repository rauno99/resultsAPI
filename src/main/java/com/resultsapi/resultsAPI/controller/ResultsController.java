package com.resultsapi.resultsAPI.controller;

import com.resultsapi.resultsAPI.model.Choice;
import com.resultsapi.resultsAPI.model.Poll;
import com.resultsapi.resultsAPI.repository.ChoiceRepository;
import com.resultsapi.resultsAPI.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ResultsController {

    @Autowired
    PollRepository pollRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    @MessageMapping("/getPoll")
    @SendTo("/topic/poll")
    public Poll sendPoll() {
        Poll poll = pollRepository.findPollByActive(true).orElse(null);
        return poll;
    }

    @MessageMapping("/getResults")
    @SendTo("/topic/results")
    public List<Choice> sendResults(@Payload Long id) {
        List<Choice> choices = choiceRepository.findChoicesByPollId(id);
        return choices;
    }

}
