package br.com.scandura.main;

import java.sql.*;
import java.util.Scanner;

public class CreateTest {
    public static void main(String[] args) throws SQLException {

        Scanner scn = new Scanner(System.in);
        System.out.println("Digite o nome do produto que você quer cadastrar no banco de dados:");
        String nomeProduto = scn.nextLine();
        System.out.println("Digite a descrição do produto que você quer cadastrar no banco de dados:");
        String descricaoProduto = scn.nextLine();

        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)");
        stm.setString(1,nomeProduto);
        stm.setString(2, descricaoProduto);

        stm.execute();

        new RetrieveTest().printDatabase(con);

        con.close();
    }
}
