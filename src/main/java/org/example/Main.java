package org.example;

import org.example.config.DatabaseConfig;
import org.example.dao.ClienteDaoImpl;
import org.example.model.Cliente;
import org.example.model.ClienteFactory;
import org.example.service.ClienteService;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public static final String USER = "rm554489";
    public static final String PASSWORD = "280606";

    public static void main(String[] args) throws SQLException {
        DatabaseConfig db = new DatabaseConfig(URL, USER, PASSWORD);
        Connection connection = db.getConnection();
        System.out.println("Conexão realizada com sucesso!");


        ClienteFactory clienteFactory = new ClienteFactory();
        ClienteService service = new ClienteService(clienteFactory, new ClienteDaoImpl(connection));
        System.out.println(service.listarClientes());
        service.criarCliente(
                "Arthur", "49076311897", LocalDate.parse("28/06/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "arthur@gmail.com", "Rua Teste 392");

        System.out.println(service.listarClientes());
    }
}