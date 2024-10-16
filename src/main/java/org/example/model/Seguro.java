package org.example.model;

public class Seguro {

    private final Long id;
    private final Double valor;
    private final TipoSeguro tipo;

    public Seguro(Long id, Double valor, TipoSeguro tipoSeguro) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipoSeguro;
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public TipoSeguro getTipo() {
        return tipo;
    }
}
