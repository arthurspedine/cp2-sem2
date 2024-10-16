package org.example.dao;

import org.example.model.Seguro;

import java.util.List;

public interface SeguroDao {

    Long create(Seguro seguro);
    List<Seguro> findAll();
    void update(Seguro seguro);
    void delete(Seguro seguro);


}
