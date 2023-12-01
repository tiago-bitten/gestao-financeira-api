package com.labisistemas.gestaofinanceiraapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<ReadWalletDto> create(CreateWalletDto dto) {
        ReadWalletDto wallet = walletService.create(dto);
        return new ResponseEntity<>(wallet, HttpStatus.CREATED);
    }
}
