package com.labisistemas.gestaofinanceiraapi.model;

import jakarta.persistence.*;

import java.util.Set;

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

    @OneToMany(mappedBy = "contaBancaria", cascade = CascadeType.ALL)
    private Set<Transacao> transacoes;

    public ContaBancaria() {
    }

    public ContaBancaria(String nome, Double saldo, Usuario usuario) {
        this.nome = nome;
        this.saldo = saldo;
        this.usuario = usuario;
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

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(Set<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
