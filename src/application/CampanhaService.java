package application;


import domain.entities.Campanha;
import java.util.ArrayList;
import java.util.List;

public class CampanhaService {
    private List<Campanha> campanhas;

    public CampanhaService() {
        this.campanhas = new ArrayList<>();
    }

    public void cadastrarCampanha(Campanha campanha) {
        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não pode ser nula");
        }
        campanhas.add(campanha);
    }

    public List<Campanha> listarCampanhas() {
        return new ArrayList<>(campanhas);
    }

    public Campanha buscarCampanhaPorNome(String nome) {
        return campanhas.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public boolean existsById(Long id) {
        return campanhas.stream().anyMatch(c -> c.getId().equals(id));
    }
}