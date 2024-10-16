package org.example.service.cliente;

import org.example.dao.ClienteDaoImpl;

public class ClienteServiceFactory implements IClienteServiceFactory{
    @Override
    public IClienteService create(ClienteDaoImpl dao) {
        return new ClienteService(dao);
    }

}
