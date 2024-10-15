package org.example.model;

public class SeguroAutomovel implements ISeguro{

   private final Long id;

    public SeguroAutomovel(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Double getValor() {
        return 1440.0;
    }

    @Override
    public TipoSeguro getTipo() {
        return TipoSeguro.AUTOMOVEL;
    }
}
