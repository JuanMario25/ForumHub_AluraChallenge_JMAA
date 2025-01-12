package com.jmario.alurachallege.forumhub.domain.answers.controller;

import com.jmario.alurachallege.forumhub.domain.answers.models.AnswerDetails;
import com.jmario.alurachallege.forumhub.domain.answers.models.NewAnswerDTO;
import com.jmario.alurachallege.forumhub.domain.answers.service.AnswerService;
import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.models.TopicDetails;
import com.jmario.alurachallege.forumhub.domain.topics.service.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ans")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    @Transactional
    public ResponseEntity<AnswerDetails> createNewTopic(@RequestBody @Valid NewAnswerDTO newAnswer){
        AnswerDetails newAnswerDetails = answerService.createNewValidatedAnswer(newAnswer);
        return ResponseEntity.ok(newAnswerDetails);
    }
}
