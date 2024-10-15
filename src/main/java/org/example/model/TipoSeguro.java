package org.example.model;

public enum TipoSeguro {
    SAUDE("saude"),
    AUTOMOVEL("automovel"),
    VIDA("vida");

    private String descricao;

    TipoSeguro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
