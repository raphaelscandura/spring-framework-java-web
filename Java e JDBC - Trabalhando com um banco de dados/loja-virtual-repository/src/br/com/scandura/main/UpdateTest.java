package br.com.scandura.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        Statement stm = con.createStatement();
        stm.execute("UPDATE PRODUTO SET nome='Arroz Branco' WHERE id=1");

        Integer modifiedLines = stm.getUpdateCount();

        System.out.println(modifiedLines + " linhas foram modificadas do banco de dados");

        con.close();
    }
}
