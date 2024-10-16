package org.example.service;

import org.example.dao.ContratacaoDao;
import org.example.dao.ContratacaoDaoImpl;
import org.example.model.*;

import java.time.LocalDate;

public class ContratacaoService {

    private final ContratacaoDao dao;

    public ContratacaoService(ContratacaoDaoImpl dao) {
        this.dao = dao;
    }

    public Long criarContratacao(Long idCliente, Long idSeguro) {
        Contratacao contratacao = new Contratacao(null, idCliente, idSeguro, LocalDate.now(), StatusContratacao.ATIVO);
        Long id = dao.create(contratacao);
        if (id != null) {
        System.out.println("Contratacao criada com sucesso!");
            return id;
        } else {
            throw new RuntimeException("Erro ao criar contratacao!");
        }
    }

    public void desativarContratacao(Long id) {
        Contratacao contratacao = dao.findById(id);
        if (contratacao != null) {
            if (contratacao.getStatus() == StatusContratacao.ATIVO) {
                dao.delete(contratacao);
                System.out.println("Contratacao desativada com sucesso!");
            } else {
                System.out.println("Esta contratação já está desativada!");
            }
            return;
        }
        throw new RuntimeException("Contratação não foi encontrada!");
    }
}
