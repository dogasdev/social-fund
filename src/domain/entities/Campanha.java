package domain.entities;

import java.util.Date;

public class Campanha {
    private String nome;
    private Double metaArrecadacao;
    private Date prazo;
    private Boolean status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getMetaArrecadacao() {
        return metaArrecadacao;
    }

    public void setMetaArrecadacao(Double metaArrecadacao) {
        this.metaArrecadacao = metaArrecadacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
