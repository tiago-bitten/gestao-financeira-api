package com.labisistemas.gestaofinanceiraapi.model;

import com.labisistemas.gestaofinanceiraapi.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Wallets")
public class Wallet extends EntityId {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "currency", nullable = false)
    private CurrencyType currency;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Wallet(String name, String description, Double balance, CurrencyType currency) {
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.currency = currency;
        this.createdAt = Instant.now();
    }
}
