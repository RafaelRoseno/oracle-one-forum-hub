package com.alura.forum_hub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private Date creationDate;
    private Status status;

    @ManyToOne
    private User author;

    @ManyToOne
    private Course course;

    @ManyToOne(optional = true)
    private Answer answer;

    public Topic(
            String title,
            String message,
            User author,
            Course course){
        this.title = title;
        this.message = message;
        this.author = author;
        this.course = course;
        this.creationDate = new Date();
        this.status = Status.ABERTO;
    }
}
