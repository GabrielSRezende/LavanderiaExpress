/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saojudas.sistemalavanderia.Model;

/**
 *
 * @author Gabriel
 */
public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;

    // Construtor
    public Cliente(int id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
}

