package com.jmario.alurachallege.forumhub.domain.answers.validation.additional;

import com.jmario.alurachallege.forumhub.domain.answers.models.Answer;
import com.jmario.alurachallege.forumhub.domain.answers.repository.AnswerRepository;
import com.jmario.alurachallege.forumhub.domain.topics.models.ModifyTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.exceptions.ValidationFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WinnerAnswerValidator {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private TopicRepository topicRepository;

    public void validate(ModifyTopicDTO modifyTopicData){
        if(modifyTopicData.winner_answer_id() == null || !answerRepository.existsById(modifyTopicData.winner_answer_id())) throw new ValidationFailureException("This answer does not exist, It has been deleted or it has not been chosen correctly");

        Answer answer = answerRepository.getReferenceById(modifyTopicData.winner_answer_id());
        if(modifyTopicData.topic_id() != answer.getTopic().getId()) throw new ValidationFailureException("This answer is not related with this topic");
    }
}
