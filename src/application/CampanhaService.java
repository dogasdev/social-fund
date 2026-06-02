package application;
import infrastructure.CampanhaRepository;
import domain.entities.Campanha;
import java.util.ArrayList;
import java.util.List;

public class CampanhaService {
    private final CampanhaRepository campanhaRepo;
    private List<Campanha> campanhas;

    public CampanhaService(CampanhaRepository campanhaRepo) {
        this.campanhaRepo = campanhaRepo;
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

    public Campanha buscarCampanhaPorNome(String nome){

        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        return campanhaRepo.buscarCampanhaPorNome(nome);
    }
}

