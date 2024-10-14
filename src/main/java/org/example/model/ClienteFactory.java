package org.example.model;

import java.time.LocalDate;

public class ClienteFactory {

    public Cliente createCliente(String nome, String cpf, LocalDate dataNascimento, String email, String endereco) {
        return new Cliente(nome, cpf, dataNascimento, email, endereco);
    }
}
