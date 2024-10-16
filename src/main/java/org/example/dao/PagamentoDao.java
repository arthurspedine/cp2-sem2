package org.example.dao;

import org.example.model.Pagamento;

public interface PagamentoDao {
    Long create(Pagamento pagamento);
    Pagamento findById(Long id);
    void update(Pagamento pagamento);
    void delete(Long id);
}
