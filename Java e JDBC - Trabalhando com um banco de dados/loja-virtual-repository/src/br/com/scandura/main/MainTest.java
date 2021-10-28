package br.com.scandura.main;

import br.com.scandura.jdbc.ProdutoDAO;
import br.com.scandura.model.Produto;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        ProdutoDAO pdao = new ProdutoDAO();

        Scanner scn = new Scanner(System.in);
        System.out.println("Digite o nome do produto que você quer cadastrar no banco de dados:");
        String nomeProduto = scn.nextLine();
        System.out.println("Digite a descrição do produto que você quer cadastrar no banco de dados:");
        String descricaoProduto = scn.nextLine();

        Produto novoProduto = new Produto(nomeProduto, descricaoProduto);

        pdao.create(novoProduto);
        pdao.retrieveAll().forEach(produto -> System.out.println(produto));
        pdao.update(novoProduto, "Arroz Branco");
        System.out.println(pdao.retrieve(novoProduto));
        pdao.delete(novoProduto);
    }
}
