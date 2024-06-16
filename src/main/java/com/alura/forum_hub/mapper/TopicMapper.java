package com.alura.forum_hub.mapper;

import com.alura.forum_hub.dto.TopicRequestDTO;
import com.alura.forum_hub.model.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicMapper {

    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    Topic topicRequestDTOToTopic(TopicRequestDTO dto);
}
