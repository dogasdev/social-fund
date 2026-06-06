package domain.entities;

public class Doador {
    private static int contadorId = 1;
    private String nome;
    private Integer id;

    public Doador(String nome){
        this.nome = nome;
        this.id = contadorId++;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public String toString() {
        return String.format("%d | %s", id, nome);
    }
}
