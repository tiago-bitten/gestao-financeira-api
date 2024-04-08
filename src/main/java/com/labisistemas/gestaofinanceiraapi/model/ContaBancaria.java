package com.labisistemas.gestaofinanceiraapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria extends EntidadeBase {

    @Column(name = "nome")
    private String nome;

    @Column(name = "saldo")
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "carteira_id")
    private Carteira carteira;

    public ContaBancaria() {
    }

    public ContaBancaria(String nome, Double saldo, Usuario usuario, Carteira carteira) {
        this.nome = nome;
        this.saldo = saldo;
        this.usuario = usuario;
        this.carteira = carteira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
