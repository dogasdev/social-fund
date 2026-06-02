package domain.entities;

import java.math.BigDecimal;

public class Doador {
    private static int contadorId = 1;

    private String nome;
    private Integer id;
    private double dinheiro;

    public Doador(String nome, double dinheiro){
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.id = contadorId;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public boolean depositar(Double valorDeposito){
        if(valorDeposito > 0){
            dinheiro += valorDeposito;
            return true;
        }
        return false;
    }

    public boolean doar(Double valorDoacao){
        if(valorDoacao <= 0 || dinheiro < valorDoacao){
            return false;
        }
        dinheiro -= valorDoacao;
        return true;
    }

    public String toString(){
        return String.format("%d | %s | %.2f", getId(), getNome(), getDinheiro());
    }
}
