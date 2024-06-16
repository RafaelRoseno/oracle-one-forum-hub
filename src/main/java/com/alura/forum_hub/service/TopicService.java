package com.alura.forum_hub.service;

import com.alura.forum_hub.dto.TopicRequestDTO;
import com.alura.forum_hub.mapper.CourseMapper;
import com.alura.forum_hub.mapper.TopicMapper;
import com.alura.forum_hub.model.Course;
import com.alura.forum_hub.model.Status;
import com.alura.forum_hub.model.Topic;
import com.alura.forum_hub.model.User;
import com.alura.forum_hub.repository.CourseRepository;
import com.alura.forum_hub.repository.TopicRepository;
import com.alura.forum_hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public TopicRequestDTO createTopic(TopicRequestDTO topicRequest) {
        Optional<User> user = userRepository.findById(topicRequest.getAuthor().getId());

        Course course = CourseMapper.INSTANCE.courseDTOToCourse(topicRequest.getCourse());
        var courseSaved = courseRepository.save(course);

        Topic topic = TopicMapper.INSTANCE.topicRequestDTOToTopic(topicRequest);
        user.ifPresent(u -> {
            topic.setAuthor(u);
            topic.setStatus(Status.ABERTO);
            topic.setCreationDate(new Date());
            topic.setCourse(courseSaved);
        });
        topicRepository.save(topic);

        return topicRequest;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public Topic updateTopic(Long id, TopicRequestDTO topicRequest) {
        return topicRepository.findById(id).map(topic -> {
            topic.setTitle(topicRequest.getTitle());
            topic.setMessage(topicRequest.getMessage());
            userRepository.findById(topicRequest.getAuthor().getId()).ifPresent(newAuthor -> topic.setAuthor(newAuthor));
            courseRepository.findByName(topicRequest.getCourse().getName()).ifPresent(courseSaved -> topic.setCourse(courseSaved));
            return topicRepository.save(topic);
        }).orElse(null);
    }

    public String deleteTopic(Long id) {
        return topicRepository.findById(id).map(topic -> {
            topicRepository.deleteById(id);
            return "Deletado com sucesso";
        }).orElseGet(() -> "Não encontrado tópico com id: " + id);
    }
}

