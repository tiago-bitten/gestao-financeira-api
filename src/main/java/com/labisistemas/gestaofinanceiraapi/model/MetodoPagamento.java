package com.labisistemas.gestaofinanceiraapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "metodos_pagamento")
public class MetodoPagamento extends EntidadeBase {

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;

    public MetodoPagamento() {
    }

    public MetodoPagamento(String nome) {
        this.nome = nome;
    }

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

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
}
