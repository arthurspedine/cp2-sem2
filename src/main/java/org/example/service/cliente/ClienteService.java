package org.example.service.cliente;

import org.example.dao.ClienteDao;
import org.example.dao.ClienteDaoImpl;
import org.example.model.Cliente;

public class ClienteService implements IClienteService {

    private final ClienteDao dao;

    protected ClienteService(ClienteDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public Long criarCliente(Cliente cliente) {
        Long id = dao.create(cliente);

        if (id != null) {
            System.out.println("Cliente criado com sucesso!");
            return id;
        } else {
            throw new RuntimeException("Erro ao criar cliente!");
        }
    }
}
