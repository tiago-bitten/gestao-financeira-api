package com.labisistemas.gestaofinanceiraapi.service;

import com.labisistemas.gestaofinanceiraapi.dto.CreateWalletDto;
import com.labisistemas.gestaofinanceiraapi.dto.ReadWalletDto;
import com.labisistemas.gestaofinanceiraapi.model.User;
import com.labisistemas.gestaofinanceiraapi.model.Wallet;
import com.labisistemas.gestaofinanceiraapi.repository.WalletRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserService userService;

    public ReadWalletDto create(CreateWalletDto dto, Long userId) {
        walletRepository.findByName(dto.name())
                .ifPresent(wallet -> {
                    throw new ValidationException("Wallet already exists");
                });

        User user = userService.findById(userId)
                .orElseThrow(() -> new ValidationException("User not found"));
        Wallet wallet = new Wallet(dto.name(), dto.description(), dto.balance(), dto.currency(), user);

        walletRepository.save(wallet);

        return new ReadWalletDto(wallet.getId(), wallet.getName(), wallet.getDescription(), wallet.getBalance(), wallet.getCurrency(), wallet.getUser().getId());
    }
}
