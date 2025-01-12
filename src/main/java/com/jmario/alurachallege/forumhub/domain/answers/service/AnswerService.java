package com.jmario.alurachallege.forumhub.domain.answers.service;

import com.jmario.alurachallege.forumhub.domain.answers.models.Answer;
import com.jmario.alurachallege.forumhub.domain.answers.models.AnswerDetails;
import com.jmario.alurachallege.forumhub.domain.answers.models.NewAnswerDTO;
import com.jmario.alurachallege.forumhub.domain.answers.repository.AnswerRepository;

import com.jmario.alurachallege.forumhub.domain.answers.validation.AnswerValidator;
import com.jmario.alurachallege.forumhub.domain.topics.enums.Status;
import com.jmario.alurachallege.forumhub.domain.topics.models.Topic;
import com.jmario.alurachallege.forumhub.domain.topics.models.TopicDetails;
import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.domain.topics.validation.TopicValidator;
import com.jmario.alurachallege.forumhub.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private List<AnswerValidator> validators;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public AnswerDetails createNewValidatedAnswer(NewAnswerDTO newAnswer){
        // validations
        validators.forEach(v->v.validate(newAnswer));


        Answer answer = new Answer(
                null,
                newAnswer.message(),
                LocalDateTime.now(),
                false,
                topicRepository.getReferenceById(newAnswer.topic_id()),
                userRepository.getReferenceById(newAnswer.author_id())
        );
        answerRepository.save(answer);
        return new AnswerDetails(answer);
    }
}
