package com.labisistemas.gestaofinanceiraapi.model;

import com.labisistemas.gestaofinanceiraapi.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyType currency;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<WalletHistory> walletHistories;

    public Wallet(String name, String description, Double balance, CurrencyType currency, User user) {
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public Wallet(String name, String description, Double balance, CurrencyType currency) {
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.currency = currency;
    }
}
