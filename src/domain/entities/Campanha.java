package domain.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Campanha {
    private List<Doador> doadores = new ArrayList<>();
    private String nome;
    private Double metaArrecadacao;
    private Date prazo;
    private String status;

    public Campanha(String nome, Double metaArrecadacao, Date prazo, String status){
        this.nome = nome;
        this.metaArrecadacao = metaArrecadacao;
        this.prazo = prazo;
        this.status = status;
    }

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

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrazoFormatado(){
        SimpleDateFormat prazoFormatado = new SimpleDateFormat("dd/MM/yyyy");
        return prazoFormatado.format(prazo);
    }

    public void adicionarDoador(Doador doador){
        this.doadores.add(doador);
    }

    public String toString(){
        return String.format("Campanha: %s\n" + "Meta de Arrecadação: R$ %.2f\n" + "Prazo: %s\n" + "Status: %s", getNome(), getMetaArrecadacao(), getPrazoFormatado(), getStatus());
    }
}
