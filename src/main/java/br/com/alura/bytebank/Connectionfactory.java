package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionfactory {

    public Connection recuperarCnexao() {

        // recurso da biblioteca para acessar o banco de dados
        try {
            // abre a conexao
            //return DriverManager
              //      .getConnection("jdbc:mysql://localhost:3306/byte_bank?user=root&password=Mateus@2022");
            // System.out.println("Recuperei a conexão");

            // connection.close();
            // fecha a conexao

            return createDataSource().getConnection();

        } catch (SQLException e) {

            throw new RuntimeException(e);

            // se der erro, imprime o erro
            // System.out.println(e);
        }

    }

    public HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername("root");
        config.setPassword("Mateus@2022");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
