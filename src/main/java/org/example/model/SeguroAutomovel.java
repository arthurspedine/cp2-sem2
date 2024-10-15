package org.example.model;

public class SeguroAutomovel implements ISeguro{

   private final Long id;

    public SeguroAutomovel(Long id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValor() {
        return 1440.0;
    }

    @Override
    public String getTipo() {
        return TipoSeguro.AUTOMOVEL;
    }
}
