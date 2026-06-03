package domain.entities;


public class Doacao {
    private Doador doador;
    private double valor;


    public Doacao(Doador doador, double valor) {
        this.doador = doador;
        this.valor = valor;

    }

    public Doador getDoador() {
        return doador;
    }

    public double getValor() {
        return valor;
    }

    public String toString(){
        return String.format("%s | %.2f", getDoador(), getValor());
    }
}