package com.labisistemas.gestaofinanceiraapi.controller;

import com.labisistemas.gestaofinanceiraapi.dto.CreateWalletDto;
import com.labisistemas.gestaofinanceiraapi.dto.ReadWalletDto;
import com.labisistemas.gestaofinanceiraapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<ReadWalletDto> create(@RequestBody CreateWalletDto dto,
                                                @RequestParam Long userId) {
        ReadWalletDto wallet = walletService.create(dto, userId);
        return new ResponseEntity<>(wallet, HttpStatus.CREATED);
    }
}
