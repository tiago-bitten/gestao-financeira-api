package com.labisistemas.gestaofinanceiraapi.service;

import com.labisistemas.gestaofinanceiraapi.model.Wallet;
import com.labisistemas.gestaofinanceiraapi.repository.WalletRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public ReadWalletDto create(CreateWalletDto dto) {
        walletRepository.findByName(dto.name())
                .ifPresent(wallet -> {
                    throw new ValidationException("Wallet already exists");
                });

        Wallet wallet = new Wallet(dto.name(), dto.description(), dto.balance(), dto.user());

        walletRepository.save(wallet);

        return new ReadWalletDto(wallet.getId(), wallet.getName(), wallet.getDescription(), wallet.getBalance(), wallet.getCurrency(), wallet.getUser().getId());
    }
}
