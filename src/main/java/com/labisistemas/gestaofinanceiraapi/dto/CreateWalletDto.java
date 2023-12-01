package com.labisistemas.gestaofinanceiraapi.dto;

import com.labisistemas.gestaofinanceiraapi.enums.CurrencyType;

public record CreateWalletDto(
        String name,
        String description,
        Double balance,
        CurrencyType currency
) {
}
