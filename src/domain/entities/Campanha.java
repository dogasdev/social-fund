package domain.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Campanha {
    private List<Doacao> doacoes = new ArrayList<>();
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

    public Date getPrazo() {
        return prazo;
    }

    public String getPrazoFormatado(){
        SimpleDateFormat prazoFormatado = new SimpleDateFormat("dd/MM/yyyy");
        return prazoFormatado.format(prazo);
    }

    public boolean atingiuMeta() {
        return totalArrecadado >= metaArrecadacao;
    }

    public boolean isExpirada() {
        return new Date().after(prazo);
    }

    public void adicionarDoacao(Doador doador, double valorDoacao) {
        if (isExpirada()) {
            throw new IllegalStateException("Campanha expirada! Não é possível receber doações.");
        }
        if (atingiuMeta()) {
            throw new IllegalStateException("Campanha já atingiu a meta! Não é possível receber mais doações.");
        }

        Doacao doacao = new Doacao(doador, valorDoacao);
        doacoes.add(doacao);
        totalArrecadado += valorDoacao;
    }

    public double getProgresso() {
        if (metaArrecadacao == null || metaArrecadacao <= 0) {
            return 0;
        }
        return (totalArrecadado / metaArrecadacao) * 100;
    }

    public List<Doacao> getDoacoes(){
        return doacoes;
    }

    public double calcularTotalDoadoPor(Doador doador){
        double total = 0;

        for(Doacao doacao : doacoes){
            if(doacao.getDoador().equals(doador)){
                total += doacao.getValor();
            }
        }
        return total;
    }

    public double getTotalArrecadado(){
        return totalArrecadado;
    }

    public String toString(){
        return String.format("Campanha: %s\nMeta de Arrecadação: R$ %.2f\nTotal arrecadado: %.2f\n" + "Prazo: %s\n" + "Status: %s\n\n", getNome(), getMetaArrecadacao(), getTotalArrecadado(), getPrazoFormatado(), getStatus());
    }
}
