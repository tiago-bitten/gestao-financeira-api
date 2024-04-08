package com.labisistemas.gestaofinanceiraapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "metodos_pagamento")
public class MetodoPagamento extends EntidadeBase {

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "metodoPagamento", cascade = CascadeType.ALL)
    private Set<Transacao> transacoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Set<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
