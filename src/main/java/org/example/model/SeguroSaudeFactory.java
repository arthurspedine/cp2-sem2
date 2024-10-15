package org.example.model;

public class SeguroSaudeFactory implements ISeguroFactory{
    @Override
    public ISeguro create(Long id) {
        return new SeguroSaude(id);
    }
}
