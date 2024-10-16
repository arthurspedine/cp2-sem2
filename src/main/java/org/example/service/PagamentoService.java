package org.example.service;

import org.example.dao.PagamentoDao;
import org.example.dao.PagamentoDaoImpl;
import org.example.model.Pagamento;

public class PagamentoService {

    private final PagamentoDao dao;

    public PagamentoService(PagamentoDaoImpl dao) {
        this.dao = dao;
    }

    public Long criarPagamento(Pagamento pagamento) {
        Long id = dao.create(pagamento);
        if (id != null) {
            System.out.println("Pagamento criado com sucesso!");
            return id;
        } else {
            throw new RuntimeException("Erro ao criar pagamento!");
        }
    }

    public Pagamento buscarPagamento(Long id) {
        Pagamento pagamento = dao.findById(id);
        if (pagamento == null) {
            throw new RuntimeException("Pagamento não encontrado!");
        }
        return pagamento;
    }
}
