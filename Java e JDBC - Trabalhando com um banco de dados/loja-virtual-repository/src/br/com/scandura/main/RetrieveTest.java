package br.com.scandura.main;

import java.sql.*;

public class RetrieveTest {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        Statement stm = con.createStatement();
        stm.execute("SELECT id, nome, descricao FROM PRODUTO");

        ResultSet rst = stm.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");
            System.out.println("ID: " + id + "\nNome: " + nome + "\nDescrição: " + descricao);
        }

        con.close();
    }
}
