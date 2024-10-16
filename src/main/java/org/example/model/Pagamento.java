package org.example.model;

import java.time.LocalDate;

public class Pagamento {

    private Long id;
    private Long idContratacao;
    private Double valor;
    private LocalDate dataPagamento;

    public Pagamento(Long id, Long idContratacao, Double valor, LocalDate dataPagamento) {
        this.id = id;
        this.idContratacao = idContratacao;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    public Long getId() {
        return id;
    }

    public Long getContratacao() {
        return idContratacao;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", idContratacao=" + idContratacao +
                ", valor=" + valor +
                ", dataPagamento=" + dataPagamento +
                '}';
    }
}
