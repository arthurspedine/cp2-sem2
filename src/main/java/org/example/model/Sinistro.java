package org.example.model;

public class Sinistro {

    private Long id;
    private Long idContratacao;
    private String descricao;
    private StatusSinistro status;
    private Double valor;

    public Sinistro(Long id, Long idContratacao, String descricao, StatusSinistro status, Double valor) {
        if (id == null) {
            this.status = StatusSinistro.EM_ANALISE;
        } else {
            this.status = status;
        }
        this.id = id;
        this.idContratacao = idContratacao;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public Long getContratacao() {
        return idContratacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusSinistro getStatus() {
        return status;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Sinistro{" +
                "id=" + id +
                ", idContratacao=" + idContratacao +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", valor=" + valor +
                '}';
    }
}
