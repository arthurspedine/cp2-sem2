package org.example.service.seguro;

import org.example.dao.SeguroDaoImpl;

public interface ISeguroServiceFactory {
    ISeguroService create(SeguroDaoImpl dao);
}
