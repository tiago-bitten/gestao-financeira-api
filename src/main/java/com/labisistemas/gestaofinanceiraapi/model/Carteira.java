package com.labisistemas.gestaofinanceiraapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "carteiras")
public class Carteira extends EntidadeBase implements Serializable {

    @Column(name = "nome")
    private String nome;

    @Column(name = "saldo")
    private Double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "carteira", cascade = CascadeType.ALL)
    private List<MetodoPagamento> metodosPagamento;

    public Carteira() {
    }

    public Carteira(String nome, Double saldo, Usuario usuario) {
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

    public List<MetodoPagamento> getMetodosPagamento() {
        return metodosPagamento;
    }

    public void setMetodosPagamento(List<MetodoPagamento> metodosPagamento) {
        this.metodosPagamento = metodosPagamento;
    }
}
