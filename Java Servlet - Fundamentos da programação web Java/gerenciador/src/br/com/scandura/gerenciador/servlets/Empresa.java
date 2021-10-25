package br.com.scandura.gerenciador.servlets;

public class Empresa {

    private int id;
    private String nome;

    public Empresa(String nome)
    {
        this.nome = nome;
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
