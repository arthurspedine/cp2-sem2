package org.example.model;

public enum StatusSinistro {
    RECUSADO("recusado"),
    EM_ANALISE("em_analise"),
    FECHADO("fechado");

    private String descricao;

    StatusSinistro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
