package com.labisistemas.gestaofinanceiraapi.model;

import com.labisistemas.gestaofinanceiraapi.enums.ChangeType;
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
@Table(name = "UserHistories")
public class UserHistory extends EntityId {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", nullable = false)
    private ChangeType changeType;

    @Column(name = "changed_at", nullable = false)
    private Instant changedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public UserHistory(String name, String email, String password, ChangeType changeType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.changeType = changeType;
        this.changedAt = Instant.now();
    }
}
