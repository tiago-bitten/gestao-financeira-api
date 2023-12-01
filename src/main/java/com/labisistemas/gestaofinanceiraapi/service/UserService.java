package com.labisistemas.gestaofinanceiraapi.service;

import com.labisistemas.gestaofinanceiraapi.dto.CreateUserDto;
import com.labisistemas.gestaofinanceiraapi.dto.ReadUserDto;
import com.labisistemas.gestaofinanceiraapi.dto.UpdateUserDto;
import com.labisistemas.gestaofinanceiraapi.model.User;
import com.labisistemas.gestaofinanceiraapi.repository.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.labisistemas.gestaofinanceiraapi.enums.ChangeType.*;

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
        userHistoryService.log(user, INSERT);

        return new ReadUserDto(user.getId(), user.getName(), user.getEmail());
    }

    public Page<ReadUserDto> findAll(String filter, Pageable pageable) {
        Page<User> users = userRepository.findAll(filter, User.class, pageable);
        return users.map(user -> new ReadUserDto(user.getId(), user.getName(), user.getEmail()));
    }

    public ReadUserDto update(UpdateUserDto dto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User not found"));

        userRepository.findByEmail(dto.email())
                .ifPresent(userFound -> {
                    if (!userFound.getId().equals(id)) {
                        throw new ValidationException("Email already exists");
                    }
                });

        if (!dto.password().equalsIgnoreCase(user.getPassword())) {
            throw new ValidationException("Password does not match");
        }

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());

        userRepository.save(user);
        userHistoryService.log(user, UPDATE);

        return new ReadUserDto(user.getId(), user.getName(), user.getEmail());
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User not found"));

        userHistoryService.log(user, DELETE);
    }
}
