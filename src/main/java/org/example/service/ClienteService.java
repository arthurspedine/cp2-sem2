package org.example.service;

import org.example.dao.ClienteDao;
import org.example.dao.ClienteDaoImpl;
import org.example.model.Cliente;
import org.example.model.ClienteFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ClienteService {

    private final ClienteFactory factory;

    private final ClienteDao dao;

    public ClienteService(ClienteFactory factory, ClienteDaoImpl dao) {
        this.factory = factory;
        this.dao = dao;
    }

    public void criarCliente(String nome, String cpf, LocalDate dataNascimento, String email, String endereco) {
        Cliente novoCliente = factory.createCliente(nome, cpf, dataNascimento, email, endereco);

        dao.create(novoCliente);
        System.out.println("Cliente criado com sucesso!");
    }

    public List<Cliente> listarClientes() {
        return dao.findAll(factory);
    }
}
