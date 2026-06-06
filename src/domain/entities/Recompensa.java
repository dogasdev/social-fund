package domain.entities;

public class Recompensa {
    private final String nomeGanhador;
    private final String mensagem;

    public Recompensa(String nomeGanhador, Double valorRecompensa) {
        this.nomeGanhador = nomeGanhador;
        this.mensagem = "Meta atingida! O ganhador do sorteio foi: " + nomeGanhador + " e recebeu R$" + String.format("%.2f", valorRecompensa);
    }

    public String getNomeGanhador(){
        return nomeGanhador;
    }

    public String getMensagem(){
        return mensagem;
    }
}
