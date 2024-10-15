package org.example.model;

public class SeguroVida  implements ISeguro{

    private final Long id;

    public SeguroVida(Long id) {
        this.id = id;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Double getValor() {
        return 200.0;
    }

    @Override
    public TipoSeguro getTipo() {
        return TipoSeguro.VIDA;
    }
}
