package infrastructure;

import domain.entities.Campanha;
import domain.entities.Doacao;
import domain.entities.Doador;
import java.util.ArrayList;
import java.util.List;

public class DoacoesRepository {
    private final List<Doacao> doacoes = new ArrayList<>();

    public void salvarDoacao(Doacao doacao) {
        if (doacao == null) {
            throw new IllegalArgumentException("Doação não pode ser nula");
        }
        doacoes.add(doacao);
    }

    public List<Doacao> listarDoacoes() {
        return new ArrayList<>(doacoes);
    }

    public List<Doacao> buscarPorCampanha(Campanha campanha) {
        if (campanha == null) {
            return new ArrayList<>();
        }

        List<Doacao> resultado = new ArrayList<>();
        for (Doacao doacao : doacoes) {
            if (doacao.getCampanha() != null && doacao.getCampanha().equals(campanha)) {
                resultado.add(doacao);
            }
        }
        return resultado;
    }

    public List<Doador> listarDoadoresPorCampanha(Campanha campanha) {
        List<Doacao> doacoesDaCampanha = buscarPorCampanha(campanha);
        List<Doador> doadores = new ArrayList<>();

        for (Doacao doacao : doacoesDaCampanha) {
            Doador doador = doacao.getDoador();
            if (!doadores.contains(doador)) {
                doadores.add(doador);
            }
        }
        return doadores;
    }

    public double calcularTotalDoadoPor(Doador doador, Campanha campanha) {
        List<Doacao> doacoesDaCampanha = buscarPorCampanha(campanha);
        double total = 0.0;

        for (Doacao doacao : doacoesDaCampanha) {
            if (doacao.getDoador().equals(doador)) {
                total += doacao.getValor();
            }
        }
        return total;
    }

    public int contarDoacoesPorCampanha(Campanha campanha) {
        return buscarPorCampanha(campanha).size();
    }
}