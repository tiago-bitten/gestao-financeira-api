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
@Table(name = "WalletHistories")
public class WalletHistory extends EntityId {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyType currency;

    @Column(name = "change_type", nullable = false)
    private Instant changeType;

    @Column(name = "changed_at", nullable = false)
    private Instant changedAt;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    public WalletHistory(String name, String description, Double balance, CurrencyType currency, Instant changeType) {
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.currency = currency;
        this.changeType = changeType;
        this.changedAt = Instant.now();
    }

    public WalletHistory(String name, Double balance, CurrencyType currency, Instant changeType) {
        this.name = name;
        this.balance = balance;
        this.currency = currency;
        this.changeType = changeType;
        this.changedAt = Instant.now();
    }
}
