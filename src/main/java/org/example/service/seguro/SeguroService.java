package org.example.service.seguro;

import org.example.dao.SeguroDao;
import org.example.model.Seguro;

public class SeguroService implements ISeguroService {

    private final SeguroDao dao;

    protected SeguroService(SeguroDao dao) {
        this.dao = dao;
    }

    @Override
    public Long criarSeguro(Seguro seguro) {
        Long idCriado = dao.create(seguro);
        if (idCriado != null) {
            System.out.println("Seguro cadastrado com sucesso!");
            return idCriado;
        } else {
            throw new RuntimeException("Erro ao criar seguro");
        }
    }
}
