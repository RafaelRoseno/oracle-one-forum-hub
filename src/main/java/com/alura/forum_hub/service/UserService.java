package com.alura.forum_hub.service;

import com.alura.forum_hub.dto.UserDTO;
import com.alura.forum_hub.mapper.UserMapper;
import com.alura.forum_hub.model.User;
import com.alura.forum_hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(UserDTO request) {
        User user = UserMapper.INSTANCE.userDTOToUser(request);

        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Campos obrigatórios não podem ser nulos");
        }

        return repository.save(user);
    }
}
