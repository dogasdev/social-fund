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
            if(campanha.getNome().equalsIgnoreCase(nome)){
                return campanha;
            }
        }
        return null;
    }

    public void deletarCampanhaPorNome(String nome){
        campanhas.removeIf(campanha -> campanha.getNome().equalsIgnoreCase(nome));
    }
}
