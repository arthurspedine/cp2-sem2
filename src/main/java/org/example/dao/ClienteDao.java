package org.example.dao;

import org.example.model.Cliente;
import org.example.model.ClienteFactory;

import java.util.List;

public interface ClienteDao {

    void create(Cliente cliente);
    List<Cliente> findAll(ClienteFactory clienteFactory);
    Cliente findById(Long id, ClienteFactory clienteFactory);
    void update(Cliente cliente);
    void delete(Long id);
}
