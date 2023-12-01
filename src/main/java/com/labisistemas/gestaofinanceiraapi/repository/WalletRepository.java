package com.labisistemas.gestaofinanceiraapi.repository;


import com.labisistemas.gestaofinanceiraapi.enterprise.CustomQuerydslPredicateExecutor;
import com.labisistemas.gestaofinanceiraapi.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long>, CustomQuerydslPredicateExecutor<Wallet> {
    Optional<Wallet> findByName(String name);
}
