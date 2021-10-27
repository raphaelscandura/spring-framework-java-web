package br.com.scandura.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTest {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        Statement stm = con.createStatement();
        stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Arroz Integral', 'Arroz integral marcas variadas')", Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();

        while(rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("O ID usado na criação da nova listagem foi: " + id);
        }

        con.close();
    }
}
