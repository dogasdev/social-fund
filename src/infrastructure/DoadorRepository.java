package infrastructure;

import domain.entities.Doador;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoadorRepository {
    private final List<Doador> doadores = new ArrayList<>();

    public void salvar(Doador doador){
        if (doador == null){
            throw new IllegalArgumentException("Doador não pode ser nulo");
        }
        doadores.add(doador);
    }

    public Doador buscarPorId(Integer id){
        if (id == null){
            return null;
        }

        for (Doador doador : doadores){
            if (id.equals(doador.getId())){
                return doador;
            }
        }
        return null;
    }

    public Doador buscarDoadorPorNome(String nome){
        if (nome == null || nome.isBlank()){
            return null;
        }

        for(Doador doador : doadores){
            if(doador.getNome().equalsIgnoreCase(nome)){
                return doador;
            }
        }
        return null;
    }

    public List<Doador> listarDoadores(){
        return new ArrayList<>(doadores);
    }

}