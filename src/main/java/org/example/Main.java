package org.example;

import org.example.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public static final String USER = "rm554489";
    public static final String PASSWORD = "280606";

    public static void main(String[] args) throws SQLException {
        DatabaseConfig db = new DatabaseConfig(URL, USER, PASSWORD);
        Connection connection = db.getConnection();
        System.out.println("Conexão realizada com sucesso!");
    }
}