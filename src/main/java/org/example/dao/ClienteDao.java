package org.example.dao;

import org.example.model.Cliente;

import java.util.List;

public interface ClienteDao {

    Long create(Cliente cliente);
    List<Cliente> findAll();
    Cliente findById(Long id);
    void update(Cliente cliente);
    void delete(Long id);
}
