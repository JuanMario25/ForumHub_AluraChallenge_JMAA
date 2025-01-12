package com.jmario.alurachallege.forumhub.domain.answers.models;


import com.jmario.alurachallege.forumhub.domain.topics.models.Topic;
import com.jmario.alurachallege.forumhub.domain.users.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "answer_table")
@Entity(name = "Answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String message;

    private LocalDateTime dateTimeStamp;

    private boolean solution; // Indicates if it's the accepted answer

    @ManyToOne
    @JoinColumn(name = "topic_id") // Foreign key column for the topic
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "author_id") // Foreign key column for the user who wrote the answer
    private User author;

}
