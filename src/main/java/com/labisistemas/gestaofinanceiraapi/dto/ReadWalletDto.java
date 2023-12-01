package com.labisistemas.gestaofinanceiraapi.dto;

import com.labisistemas.gestaofinanceiraapi.enums.CurrencyType;

public record ReadWalletDto(
        Long id,
        String name,
        String description,
        Double balance,
        CurrencyType currency,
        Long userId
) {
}
