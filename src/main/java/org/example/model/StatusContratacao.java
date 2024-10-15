package org.example.model;

public enum StatusContratacao {
    ATIVO("ativo"),
    INATIVO("inativo");

    private String descricao;

    StatusContratacao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
