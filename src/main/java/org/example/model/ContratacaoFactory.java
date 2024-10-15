package org.example.model;

import java.time.LocalDate;

public class ContratacaoFactory{

    public Contratacao createContratacao(Long id, Cliente cliente, ISeguro seguro, LocalDate dataContratacao,StatusContratacao status ){
        return new Contratacao(id, cliente, seguro, dataContratacao, status);
    }
}
