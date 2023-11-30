package com.labisistemas.gestaofinanceiraapi.controller;

import com.labisistemas.gestaofinanceiraapi.dto.CreateUserDto;
import com.labisistemas.gestaofinanceiraapi.dto.ReadUserDto;
import com.labisistemas.gestaofinanceiraapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ReadUserDto> create(@RequestBody @Valid CreateUserDto dto) {
        ReadUserDto user = userService.create(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReadUserDto> update(@RequestBody @Valid CreateUserDto dto, @PathVariable Long id) {
        ReadUserDto user = userService.update(dto, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
