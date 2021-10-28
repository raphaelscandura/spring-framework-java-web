package br.com.scandura.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();

        PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE id > 1");
        stm.execute();

        new RetrieveTest().printDatabase(con);

        con.close();
    }
}
