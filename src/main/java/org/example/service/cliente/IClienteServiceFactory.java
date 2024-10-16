package org.example.service.cliente;

import org.example.dao.ClienteDaoImpl;

public interface IClienteServiceFactory {
    IClienteService create(ClienteDaoImpl dao);
}
