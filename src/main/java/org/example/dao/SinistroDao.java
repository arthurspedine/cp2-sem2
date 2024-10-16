package org.example.dao;

import org.example.model.Sinistro;

import java.util.List;

public interface SinistroDao {
    Long create(Sinistro sinistro);
    List<Sinistro> findAll();
    Sinistro findById(Long id);
    void update(Sinistro sinistro);
    void delete(Sinistro sinistro);
}
