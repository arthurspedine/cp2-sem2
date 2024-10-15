package org.example.model;

import java.time.LocalDate;

public class Contratacao {
    private Long id;
    private Cliente cliente;
    private ISeguro seguro;
    private LocalDate dataContratacao;
    private StatusContratacao status;
}
