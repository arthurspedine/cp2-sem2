package org.example.dao;

import org.example.model.ISeguro;

public interface SeguroDao {

    void create(ISeguro seguro);
    void update(ISeguro seguro);
    void delete(ISeguro seguro);


}
