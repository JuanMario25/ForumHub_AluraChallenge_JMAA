package com.jmario.alurachallege.forumhub.domain.topics.repository;


import com.jmario.alurachallege.forumhub.domain.topics.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    boolean existsByTitle(String title);

    boolean existsByMessage(String message);

//    @Query("SELECT new TopicDetails(t) FROM Topic t ORDER BY t.title ASC,t.dateTimeStamp ASC")
//    Page<TopicDetails> findAllOrderedByTitleAndDatetimeStamp(Pageable pageable);


}
