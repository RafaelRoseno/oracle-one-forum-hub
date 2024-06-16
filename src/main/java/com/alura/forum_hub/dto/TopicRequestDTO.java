package com.alura.forum_hub.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;

@Getter
public class TopicRequestDTO {
    @JsonAlias("titulo")
    String title;
    @JsonAlias("mensagem")
    String message;
    @JsonAlias("autor")
    UserDTO author;
    @JsonAlias("curso")
    CourseDTO course;
}
