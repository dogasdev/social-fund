package domain.entities;

public class Doacao {
    private Doador doador;
    private double valor;
    private Campanha campanha;
    private boolean estornada;

    public Doacao(Doador doador, double valor) {
        this.doador = doador;
        this.valor = valor;
        this.estornada = false;
    }

    public Doador getDoador() {
        return doador;
    }

    public double getValor() {
        return valor;
    }

    public Campanha getCampanha(){
        return campanha;
    }

    public boolean isEstornada() {
        return estornada;
    }

    public void setEstornada(boolean estornada) {
        this.estornada = estornada;
    }

    public String getStatus() {
        if(estornada){
            return "Doação Estornada!";
        }
        return "REGISTRADA";
    }

    public String toString() {
        return String.format("%s | R$ %.2f | %s", doador.getNome(), getValor(), getStatus());
    }
}