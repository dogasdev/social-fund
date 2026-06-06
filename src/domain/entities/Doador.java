package domain.entities;

public class Doador {
    private static int contadorId = 1;
    private String nome;
    private Integer id;
    private double dinheiro;

    public Doador(String nome, double dinheiroInicial){
        this.nome = nome;
        this.id = contadorId++;
        this.dinheiro = dinheiroInicial;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public double getDinheiro(){
        return dinheiro;
    }

    public double getSaldo() {
        return dinheiro;
    }

    public boolean depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            return false;
        }
        dinheiro += valorDeposito;
        return true;
    }

    public boolean doar(double valorDoacao) {
        if (valorDoacao <= 0) {
            return false;
        }
        if (dinheiro < valorDoacao) {
            return false;
        }
        dinheiro -= valorDoacao;
        return true;
    }

    public String toString() {
        return String.format("%d | %s | R$ %.2f", getId(), getNome(), getDinheiro());
    }
}
