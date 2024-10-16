package org.example.model;

public class Sinistro {

    private Long id;
    private Long idContratacao;
    private String descricao;
    private StatusSinistro status;
    private Double valor;

    public Sinistro(Long id, Long idContratacao, String descricao, StatusSinistro status, Double valor) {
        this.id = id;
        this.idContratacao = idContratacao;
        setStatus(status);
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

    public void setStatus(StatusSinistro status) {
        if (getId() == null) {
            this.status = StatusSinistro.EM_ANALISE;
        } else if (this.status == StatusSinistro.RECUSADO) {
            throw new RuntimeException("Esse sinistro esta recusado! Não é possivel foi atualizar seu status!");
        } else if (this.status == StatusSinistro.FECHADO) {
            throw new RuntimeException("Esse sinistro já esta fechado e concluido então não pode ser atualizado!");
        } else {
            this.status = status;
        }
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
