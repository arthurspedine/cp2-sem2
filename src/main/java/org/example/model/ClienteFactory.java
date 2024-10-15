package org.example.model;

import java.time.LocalDate;

public class ClienteFactory {

    public Cliente createCliente(Long id, String nome, String cpf, LocalDate dataNascimento, String email, String endereco) {
        return new Cliente(id, nome, cpf, dataNascimento, email, endereco);
    }

}
