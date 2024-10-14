package org.example.model;

import java.time.LocalDate;

public class Contratacao {
    private Long id;
    private Cliente cliente;
    private Seguro seguro;
    private LocalDate dataContratacao;
    private StatusContratacao status;
}
