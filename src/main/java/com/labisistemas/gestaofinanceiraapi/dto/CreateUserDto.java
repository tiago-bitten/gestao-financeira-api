package com.labisistemas.gestaofinanceiraapi.dto;

public record CreateUserDto(
        String name,
        String email,
        String password
) {
}
