package org.example.model;

import java.time.LocalDate;

public class Contratacao {
    private Long id;
    private Long idCliente;
    private Long idSeguro;
    private LocalDate dataContratacao;
    private StatusContratacao status;

    public Contratacao(Long id, Long idCliente, Long idSeguro, LocalDate dataContratacao, StatusContratacao status) {
        this.id = id;
        this.idCliente = idCliente;
        this.idSeguro = idSeguro;
        this.status = status;
        if (id == null) {
            setDataContratacao(dataContratacao);
        } else {
            this.dataContratacao = dataContratacao;
        }
    }

    public Long getId() {
        return id;
    }

    public Long getCliente() {
        return idCliente;
    }

    public Long getSeguro() {
        return idSeguro;
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

    public boolean isContratacaoAtiva() {
        return status.equals(StatusContratacao.ATIVO);
    }

    public StatusContratacao getStatus() {
        return status;
    }

    public void setStatus(StatusContratacao status) {
        this.status = status;
    }
}
