package br.com.scandura.gerenciador.servlets;

import java.util.Date;

public class Empresa {

    private int id;
    private String nome;
    private Date dataCadastro = new Date();

    public Empresa(String nome)
    {
        this.nome = nome;
    }

    public Date getDataCadastro()
    {
        return this.dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private int getId()
    {
        return this.id;
    }
}
