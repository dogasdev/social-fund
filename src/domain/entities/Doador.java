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

    public boolean depositar(Double valor){
        if(valor > 0){
            dinheiro += valor;
            return true;
        }
        return false;
    }

    public String toString(){
        return String.format("%d | %s | %.2f", getId(), getNome(), getDinheiro());
    }
}
