package org.example.dao;

import org.example.model.Contratacao;

import java.util.List;

public interface ContratacaoDao {

    Long create(Contratacao contratacao);
    List<Contratacao> findAll();
    Contratacao findById(Long id);
    void delete(Contratacao contratacao);
}
