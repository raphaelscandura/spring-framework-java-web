package br.com.scandura.main;

import java.sql.*;

public class RetrieveTest {
    public void printDatabase(Connection con) throws SQLException {
        PreparedStatement stm = con.prepareStatement("SELECT id, nome, descricao FROM PRODUTO", Statement.RETURN_GENERATED_KEYS);

        stm.execute();

        ResultSet rst = stm.getResultSet();

        while(rst.next()){
            int id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");
            System.out.println("ID: " + id + "\nNome: " + nome + "\nDescrição: " + descricao);
        }
    }
}
