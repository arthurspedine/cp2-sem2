package org.example.service;

import org.example.dao.ClienteDao;
import org.example.dao.ClienteDaoImpl;
import org.example.model.Cliente;
import org.example.model.ClienteFactory;

import java.time.LocalDate;
import java.util.List;

public class ClienteService {

    private static ClienteService clienteService;

    private final ClienteFactory factory;

    private final ClienteDao dao;

    private ClienteService(ClienteFactory factory, ClienteDaoImpl dao) {
        this.factory = factory;
        this.dao = dao;
    }

    public static synchronized ClienteService getInstacia(ClienteFactory factory, ClienteDaoImpl dao){
        if(clienteService == null){
            clienteService = new ClienteService(factory, dao);
        }
        return clienteService;
    }

    public void criarCliente(String nome, String cpf, LocalDate dataNascimento, String email, String endereco) {
        Cliente novoCliente = factory.createCliente(null, nome, cpf, dataNascimento, email, endereco);

        dao.create(novoCliente);
        System.out.println("Cliente criado com sucesso!");
    }

    public List<Cliente> listarClientes() {
        return dao.findAll(factory);
    }
}
