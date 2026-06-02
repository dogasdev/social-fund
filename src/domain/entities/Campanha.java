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
    private Double totalArrecadado = 0.0;

    public Campanha(String nome, Double metaArrecadacao, Date prazo, String status){
        this.nome = nome;
        this.metaArrecadacao = metaArrecadacao;
        this.prazo = prazo;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }


    public Double getMetaArrecadacao() {
        return metaArrecadacao;
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

    public void adicionarDoacao(Doador doador, double valorDoacao){
        doadores.add(doador);
        totalArrecadado += valorDoacao;
    }

    public double getTotalArrecadado(){
        return totalArrecadado;
    }

    public String toString(){
        return String.format("Campanha: %s\n" + "Meta de Arrecadação: R$ %.2f\n" + "Prazo: %s\n" + "Status: %s", getNome(), getMetaArrecadacao(), getPrazoFormatado(), getStatus());
    }
}
