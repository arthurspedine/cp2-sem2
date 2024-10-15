package org.example.model;

class SeguroSaude implements ISeguro {

    private final Long id;

    public SeguroSaude(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Double getValor() {
        return 1200.0d;
    }

    @Override
    public TipoSeguro getTipo() {
        return TipoSeguro.SAUDE;
    }
}
