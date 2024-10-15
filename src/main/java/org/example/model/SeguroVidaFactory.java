package org.example.model;

public class SeguroVidaFactory implements ISeguroFactory{
    @Override
    public ISeguro create(Long id) {return new SeguroVida(id);}
}
