package com.alura.forum_hub.mapper;

import com.alura.forum_hub.dto.CourseDTO;
import com.alura.forum_hub.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "id", ignore = true)
    Course courseDTOToCourse(CourseDTO dto);
}
