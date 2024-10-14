package org.example.model;

import java.time.LocalDate;

public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String endereco;

    protected Cliente() {
    }

    protected Cliente(Long id, String nome, String cpf, LocalDate dataNascimento, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
    }

    protected Cliente(String nome, String cpf, LocalDate dataNascimento, String email, String endereco) {
        this.nome = nome;
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        this.email = email;
        this.endereco = endereco;
    }

    private void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now().minusYears(18))) {
            throw new RuntimeException("Cliente menor de idade!");
        }
        this.dataNascimento = dataNascimento;
    }

    private void setCpf(String cpf) {
        try {
            int sum = 0;
            int weight = 10;

            // First verification digit
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }
            int firstDigit = calculateDigit(sum);
            if (firstDigit != (cpf.charAt(9) - '0'))
                throw new RuntimeException();

            // Reset for second verification digit
            sum = 0;
            weight = 11;

            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }
            int secondDigit = calculateDigit(sum);
            if (secondDigit != (cpf.charAt(10) - '0'))
                throw new RuntimeException();

            this.cpf = cpf;
        } catch (RuntimeException e) {
            throw new RuntimeException("CPF invalido!");
        }
    }

    private int calculateDigit(int sum) {
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
