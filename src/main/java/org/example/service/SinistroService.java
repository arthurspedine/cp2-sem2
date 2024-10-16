package org.example.service;

import org.example.dao.SinistroDao;
import org.example.model.Sinistro;

public class SinistroService {
    private final SinistroDao dao;
    public SinistroService(SinistroDao dao) {
        this.dao = dao;
    }

    public Long criarSinistro(Sinistro sinistro) {
        Long id = dao.create(sinistro);
        if (id != null) {
            System.out.println("Sinistro criado com sucesso!");
            return id;
        } else {
            throw new RuntimeException("Erro ao criar sinistro!");
        }
    }

    public Sinistro buscarSinistro(Long id) {
        Sinistro sinistro = dao.findById(id);
        if (sinistro == null) {
            throw new RuntimeException("Sinistro não encontrado!");
        }
        return sinistro;
    }
}
