package br.com.scandura.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer id;
    private String nome;
    private List<Produto> produtoList = new ArrayList<>();


    public Categoria(Integer id, String nome){
        this.nome = nome;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionaProduto(Produto p ){
        this.produtoList.add(p);
    }

    public List<Produto> getProdutoList(){
        return this.produtoList;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "Nome: " + this.nome;
    }
}
