package br.com.scandura.model;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "\nNome: " + this.nome + "\nDescrição: " + this.descricao;
    }
}
