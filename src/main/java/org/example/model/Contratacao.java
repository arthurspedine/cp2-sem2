package org.example.model;

import java.time.LocalDate;

public class Contratacao {
    private Long id;
    private Cliente cliente;
    private ISeguro seguro;
    private LocalDate dataContratacao;
    private StatusContratacao status;

    public Contratacao(Long id, Cliente cliente, ISeguro seguro, LocalDate dataContratacao, StatusContratacao status) {
        this.id = id;
        this.cliente = cliente;
        this.seguro = seguro;
        this.dataContratacao = dataContratacao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ISeguro getSeguro() {
        return seguro;
    }

    public void setSeguro(ISeguro seguro) {
        this.seguro = seguro;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        if(dataContratacao.isBefore(LocalDate.now())){
            throw new RuntimeException("data nao pode ser antorior a data atual!");
        }

        this.dataContratacao = dataContratacao;
    }

    public StatusContratacao getStatus() {
        return status;
    }

    public void setStatus(StatusContratacao status) {
        this.status = status;
    }
}
