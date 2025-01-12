package com.jmario.alurachallege.forumhub.domain.topics.controller;

import com.jmario.alurachallege.forumhub.domain.topics.models.ModifyTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.models.TopicDetails;
import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.domain.topics.service.TopicService;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topic")
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public ResponseEntity<Page<TopicDetails>> listOfTopics(@PageableDefault(size = 5) Pageable pagination){
        return topicService.topicListSorted(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetails> getTopic(@PathVariable Long id){
        return topicService.getTopicById(id);
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<TopicDetails> createNewTopic(@RequestBody @Valid NewTopicDTO newTopic){
        TopicDetails newTopicDetails = topicService.createNewValidatedTopic(newTopic);
        return ResponseEntity.ok(newTopicDetails);
    }

    @PutMapping("/modify")
    @Transactional
    public  ResponseEntity<TopicDetails> modifyTopic(@RequestBody @Valid ModifyTopicDTO modifyTopicData){
        return topicService.modifyTopic(modifyTopicData);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public  ResponseEntity<String> deleteTopic(@PathVariable Long id){
        return topicService.deleteTopicAndAnswers(id);
    }
}
