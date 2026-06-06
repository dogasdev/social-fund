package infrastructure;
import domain.entities.Campanha;
import domain.entities.Doador;
import java.util.ArrayList;
import java.util.List;

public class CampanhaRepository {
    private final List<Campanha> campanhas = new ArrayList<>();

    public void salvarCampanha(Campanha campanha){
        campanhas.add(campanha);
    }

    public List<Campanha> listarCampanhas(){
        return campanhas;
    }

    public Campanha buscarCampanhaPorNome(String nome){
        for(Campanha campanha : campanhas){
            if(campanha.getNome().equalsIgnoreCase(nome.trim())){
                return campanha;
            }
        }
        return null;
    }

    public List<Campanha> buscarCampanhasAtivas() {
        List<Campanha> campanhasAtivas = new ArrayList<>();

        for (Campanha campanha : campanhas) {
            if ("ATIVA".equals(campanha.getStatus()) && !campanha.isExpirada()) {
                campanhasAtivas.add(campanha);
            }
        }
        return campanhasAtivas;
    }

    public List<Campanha> buscarCampanhasConcluidas() {
        List<Campanha> campanhasConcluidas = new ArrayList<>();

        for (Campanha campanha : campanhas) {
            if (campanha.atingiuMeta() || campanha.isExpirada()) {
                campanhasConcluidas.add(campanha);
            }
        }
        return campanhasConcluidas;
    }

    public void deletarCampanhaPorNome(String nome){
        campanhas.removeIf(campanha -> campanha.getNome().equalsIgnoreCase(nome.trim()));
    }
}
