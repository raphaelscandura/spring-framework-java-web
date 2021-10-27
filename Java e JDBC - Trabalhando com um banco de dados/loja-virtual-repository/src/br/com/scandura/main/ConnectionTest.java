package br.com.scandura.main;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();



        con.close();
    }
}
