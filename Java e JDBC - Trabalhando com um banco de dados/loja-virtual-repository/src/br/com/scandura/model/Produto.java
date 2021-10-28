package br.com.scandura.model;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer idCategoria;

    public Produto(String nome, String descricao, Integer idCategoria){
        this.nome = nome;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
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

    public Integer getIdCategoria(){
        return this.idCategoria;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "\nNome: " + this.nome + "\nDescrição: " + this.descricao + "\nCategoria: " + this.idCategoria;
    }
}
