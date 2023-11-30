package com.labisistemas.gestaofinanceiraapi.dto;

public record UpdateUserDto(
        String name,
        String email,
        String password,
        String confirmPassword
) {
}
