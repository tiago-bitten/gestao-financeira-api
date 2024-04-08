package com.labisistemas.gestaofinanceiraapi.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedBy
    protected String criadoPor;

    @CreatedDate
    protected LocalDateTime criadoEm;

    @LastModifiedBy
    protected String ultimaModificacaoPor;

    @LastModifiedDate
    protected LocalDateTime ultimaModificacaoEm;

    @Column(name = "ativo")
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getUltimaModificacaoPor() {
        return ultimaModificacaoPor;
    }

    public void setUltimaModificacaoPor(String ultimaModificacaoPor) {
        this.ultimaModificacaoPor = ultimaModificacaoPor;
    }

    public LocalDateTime getUltimaModificacaoEm() {
        return ultimaModificacaoEm;
    }

    public void setUltimaModificacaoEm(LocalDateTime ultimaModificacaoEm) {
        this.ultimaModificacaoEm = ultimaModificacaoEm;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @PrePersist
    public void prePersist() {
        this.ativo = true;
    }
}