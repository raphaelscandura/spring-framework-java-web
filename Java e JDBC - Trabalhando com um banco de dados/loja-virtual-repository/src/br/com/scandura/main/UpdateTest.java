package br.com.scandura.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        Scanner scn = new Scanner(System.in);
        System.out.println("Qual o ID do produto que você quer atualizar?");
        String idProduto = scn.nextLine();
        System.out.println("Digite o novo nome do produto com ID " + idProduto);
        String nomeProduto = scn.nextLine();

        PreparedStatement stm = con.prepareStatement("UPDATE PRODUTO SET nome=? WHERE id=?");

        stm.setString(2, idProduto);
        stm.setString(1, nomeProduto);

        stm.execute();

        new RetrieveTest().printDatabase(con);

        con.close();
    }
}
