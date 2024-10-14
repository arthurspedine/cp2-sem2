package org.example.model;

public enum StatusSinistro {
    ABERTO("aberto"),
    EM_ANALISE("em analise"),
    FECHADO("fechado");

    private String descricao;

    StatusSinistro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
