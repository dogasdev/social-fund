package application;
import infrastructure.CampanhaRepository;
import domain.entities.Campanha;
import domain.entities.Doador;
import java.util.ArrayList;
import java.util.List;

public class CampanhaService {
    private final CampanhaRepository campanhaRepo;

    public CampanhaService(CampanhaRepository campanhaRepo) {
        this.campanhaRepo = campanhaRepo;
    }

    public void cadastrarCampanha(Campanha campanha) {
        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não pode ser nula");
        }
        campanhaRepo.salvarCampanha(campanha);
    }

    public List<Campanha> listarCampanhas() {
        return new ArrayList<>(campanhaRepo.listarCampanhas());
    }

    public Campanha buscarCampanhaPorNome(String nome){

        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        return campanhaRepo.buscarCampanhaPorNome(nome);
    }

    public void deletarCampanhaPorNome(String nome){
        if(campanhaRepo.listarCampanhas().isEmpty()){
            System.out.println("Nenhuma campanha registrada");
        }else{
            campanhaRepo.deletarCampanhaPorNome(nome);
        }
    }

    public void realizarDoacao(String nomeCampanha, Doador doador){
        if(doador == null){
            System.out.println("Doador inválido!");
            return;
        }
        Campanha campanha = campanhaRepo.buscarCampanhaPorNome(nomeCampanha);

        if(campanha == null){
            System.out.println("Campanha não encontrada!");
            return;
        }
        campanha.adicionarDoacao(doador);
    }
}

