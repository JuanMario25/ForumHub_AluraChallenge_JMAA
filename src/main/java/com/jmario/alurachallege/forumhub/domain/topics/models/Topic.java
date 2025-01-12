package com.jmario.alurachallege.forumhub.domain.topics.models;

import com.jmario.alurachallege.forumhub.domain.answers.models.Answer;
import com.jmario.alurachallege.forumhub.domain.courses.models.Course;
import com.jmario.alurachallege.forumhub.domain.topics.enums.Status;
import com.jmario.alurachallege.forumhub.domain.users.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topic_table")
@Entity(name = "Topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String message;

    private LocalDateTime dateTimeStamp;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "author_id") // Foreign key column for the author
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id") // Foreign key column for the course
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answer; // Replies related to this topic


}
