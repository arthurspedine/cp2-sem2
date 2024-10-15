package org.example.model;

public class SeguroAutomovelFactory implements ISeguroFactory{
    @Override
    public ISeguro create(Long id) {return new SeguroAutomovel(id);}
}
