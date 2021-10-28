package br.com.scandura.main;

import br.com.scandura.dao.CategoriaDAO;
import br.com.scandura.jdbc.ConnectionFactory;
import br.com.scandura.dao.ProdutoDAO;
import br.com.scandura.model.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = new ConnectionFactory().getConnection()){
            ProdutoDAO pdao = new ProdutoDAO(connection);

//            Scanner scn = new Scanner(System.in);
//            System.out.println("Digite o nome do produto que você quer cadastrar no banco de dados:");
//            String nomeProduto = scn.nextLine();
//            System.out.println("Digite a descrição do produto que você quer cadastrar no banco de dados:");
//            String descricaoProduto = scn.nextLine();
//
//            Produto novoProduto = new Produto(nomeProduto, descricaoProduto);

//            pdao.create(novoProduto);
//            pdao.retrieveAll().forEach(System.out::println);
//            pdao.update(novoProduto, "Arroz Branco");
//            System.out.println(pdao.retrieve(novoProduto));
            //pdao.delete(novoProduto);

            CategoriaDAO cdao = new CategoriaDAO(connection);
            cdao.retrieveProdutoByCategoria().stream().forEach(categoria -> {
                System.out.println(categoria.getNome());
                if(categoria.getProdutoList() != null){
                    for(Produto produto : categoria.getProdutoList()){
                        System.out.println(produto);
                    }
                }
            });
        }
    }
}
