package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private final String url;
    private final String user;
    private final String password;

    public DatabaseConfig(String url, String user, String password) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
