package org.example.model;

public class SeguroVida  implements ISeguro{

    private final Long id;

    public SeguroVida(Long id) {
        this.id = id;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValor() {
        return 200.0;
    }

    @Override
    public String getTipo() {
        return TipoSeguro.VIDA;
    }
}
