package com.labisistemas.gestaofinanceiraapi.dto;

import com.labisistemas.gestaofinanceiraapi.enums.ChangeType;

import java.time.Instant;
import java.time.LocalDateTime;

public record ReadUserHistoriesDto(
        Long id,
        String name,
        String email,
        Long userId,
        ChangeType changeType,
        Instant changedAt
) {
}
