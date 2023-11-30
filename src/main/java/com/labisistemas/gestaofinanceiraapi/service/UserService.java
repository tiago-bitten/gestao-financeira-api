package com.labisistemas.gestaofinanceiraapi.service;

import com.labisistemas.gestaofinanceiraapi.dto.CreateUserDto;
import com.labisistemas.gestaofinanceiraapi.dto.ReadUserDto;
import com.labisistemas.gestaofinanceiraapi.model.User;
import com.labisistemas.gestaofinanceiraapi.repository.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryService userHistoryService;

    public ReadUserDto create(CreateUserDto dto) {
        userRepository.findByEmail(dto.email())
                .ifPresent(user -> {
                    throw new ValidationException("Email already exists");
                });

        User user = new User(dto.name(), dto.email(), dto.password());

        userRepository.save(user);
        userHistoryService.insert(user);

        return new ReadUserDto(user.getId(), user.getName(), user.getEmail());
    }
}
