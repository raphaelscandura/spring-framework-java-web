package br.com.scandura.main;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimeZone=UTC");
        cpds.setUser("root");
        cpds.setPassword("root");
        cpds.setMaxPoolSize(5);

        this.dataSource = cpds;
    }
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
