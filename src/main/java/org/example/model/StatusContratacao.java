package org.example.model;

public enum StatusContratacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String descricao;

    StatusContratacao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
