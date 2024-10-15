package org.example.model;

class SeguroSaude implements ISeguro {

    private final Long id;

    public SeguroSaude(Long id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValor() {
        return 1200.0d;
    }

    @Override
    public String getTipo() {
        return TipoSeguro.SAUDE;
    }
}
