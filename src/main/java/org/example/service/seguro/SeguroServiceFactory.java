package org.example.service.seguro;

import org.example.dao.SeguroDaoImpl;

public class SeguroServiceFactory implements ISeguroServiceFactory{
    @Override
    public ISeguroService create(SeguroDaoImpl dao) {
        return new SeguroService(dao);
    }
}
