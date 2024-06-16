package com.alura.forum_hub.mapper;

import com.alura.forum_hub.dto.UserDTO;
import com.alura.forum_hub.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profiles", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User userDTOToUser(UserDTO dto);

    UserDTO userToUserDTO(User user);
}
