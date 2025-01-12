package com.jmario.alurachallege.forumhub.domain.topics.service;

import com.jmario.alurachallege.forumhub.domain.answers.models.Answer;
import com.jmario.alurachallege.forumhub.domain.answers.repository.AnswerRepository;
import com.jmario.alurachallege.forumhub.domain.answers.validation.additional.WinnerAnswerValidator;
import com.jmario.alurachallege.forumhub.domain.courses.repository.CourseRepository;
import com.jmario.alurachallege.forumhub.domain.topics.enums.Status;
import com.jmario.alurachallege.forumhub.domain.topics.models.ModifyTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.models.NewTopicDTO;
import com.jmario.alurachallege.forumhub.domain.topics.models.Topic;
import com.jmario.alurachallege.forumhub.domain.topics.models.TopicDetails;
import com.jmario.alurachallege.forumhub.domain.topics.repository.TopicRepository;
import com.jmario.alurachallege.forumhub.domain.topics.validation.TopicValidator;
import com.jmario.alurachallege.forumhub.domain.topics.validation.additional.ExistsTopicByIdValidator;
import com.jmario.alurachallege.forumhub.domain.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private List<TopicValidator> validators;
    @Autowired
    private ExistsTopicByIdValidator existsTopicValidator;
    @Autowired
    private WinnerAnswerValidator winnerAnswerValidator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public TopicDetails createNewValidatedTopic(NewTopicDTO newTopic){
        // validations
        validators.forEach(v->v.validate(newTopic));

        Topic topic = new Topic(
                null,
                newTopic.title(),
                newTopic.message(),
                LocalDateTime.now(),
                Status.OPEN,
                userRepository.getReferenceById(newTopic.author_id()),
                courseRepository.getReferenceById(newTopic.course_id()),
                null
        );
        topicRepository.save(topic);
        return new TopicDetails(topic);
    }

    public ResponseEntity<Page<TopicDetails>> topicListSorted(Pageable pagination) {
        // Define default sorting if none is provided in the request
        if (pagination.getSort().isUnsorted()) {
            pagination = PageRequest.of(
                    pagination.getPageNumber(),
                    pagination.getPageSize(),
                    Sort.by(Sort.Order.asc("title"), Sort.Order.desc("dateTimeStamp")));
        }
        return ResponseEntity.ok(topicRepository.findAll(pagination).map(TopicDetails::new));
    }

    public ResponseEntity<TopicDetails> getTopicById(Long id) {
        existsTopicValidator.validate(id);
        return ResponseEntity.ok(new TopicDetails(topicRepository.getReferenceById(id)));
    }

    public ResponseEntity<TopicDetails> modifyTopic(ModifyTopicDTO modifyTopicData) {
        existsTopicValidator.validate(modifyTopicData.topic_id());
        Topic topic = topicRepository.getReferenceById(modifyTopicData.topic_id());
        if(!modifyTopicData.title().isBlank()) topic.setTitle(modifyTopicData.title());
        if(!modifyTopicData.message().isBlank()) topic.setMessage(modifyTopicData.message());
        if(modifyTopicData.status() != null){
            topic.setStatus(modifyTopicData.status());
            if(topic.getStatus() == Status.CLOSE){
                winnerAnswerValidator.validate(modifyTopicData);
                Answer winnerAnswer = answerRepository.getReferenceById(modifyTopicData.winner_answer_id());
                winnerAnswer.setSolution(true);
            }
        }
        return ResponseEntity.ok(new TopicDetails(topic));
    }

    public ResponseEntity<String> deleteTopicAndAnswers(Long id){
        existsTopicValidator.validate(id);
        Topic topic = topicRepository.getReferenceById(id);

        List<Answer> relatedAnswers = answerRepository.findAllByTopicId(id);
        if (relatedAnswers == null) {
            // setAnswer as empty list
            topic.setAnswer(new ArrayList<Answer>());
        }else {
            topic.setAnswer(relatedAnswers);
        }
        if(!topic.getAnswer().isEmpty()) answerRepository.deleteAll(topic.getAnswer());

        topicRepository.delete(topic);

        String deletedEntitiesData =
                """
                Topic Deleted:
                %S
                %d Answers related have been deleted
                """.formatted(topic.getTitle(),topic.getAnswer().size());

        return ResponseEntity.ok(deletedEntitiesData);
    }
}
