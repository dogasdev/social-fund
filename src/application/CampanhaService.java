package application;
import domain.entities.Doacao;
import infrastructure.CampanhaRepository;
import domain.entities.Campanha;
import domain.entities.Doador;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CampanhaService {
    private final CampanhaRepository campanhaRepo;

    public CampanhaService(CampanhaRepository campanhaRepo) {
        this.campanhaRepo = campanhaRepo;
    }

    public void cadastrarCampanha(Campanha campanha){
        if (campanha == null) {
            throw new IllegalStateException("Campanha não pode ser nula");
        }
        campanhaRepo.salvarCampanha(campanha);
    }

    public List<Campanha> listarCampanhas(){
        List<Campanha> campanhas = campanhaRepo.listarCampanhas();

        if (campanhas.isEmpty()){
            System.out.println("Não há campanhas cadastradas");
        }

        return new ArrayList<>(campanhas);
    }

    public Campanha buscarCampanhaPorNome(String nome){

        if(nome == null || nome.isBlank()){
            throw new IllegalStateException("Nome inválido.");
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

    public void realizarDoacao(String nomeCampanha, Doador doador, double valorDoacao){
        if(doador == null){
            System.out.println("Doador inválido!");
            return;
        }

        Campanha campanha = campanhaRepo.buscarCampanhaPorNome(nomeCampanha);

        if(campanha == null){
            System.out.println("Campanha não encontrada!");
            return;
        }

        if(valorDoacao <= 0){
            System.out.println("Valor inválido!");
            return;
        }
        if (!doador.doar(valorDoacao)) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        campanha.adicionarDoacao(doador, valorDoacao);
        System.out.println("Doações registradas: " + campanha.getDoacoes().size());
    }

    public List<Doacao> listarDoacoesCampanha(String nomeCampanha){
        Campanha campanha = campanhaRepo.buscarCampanhaPorNome(nomeCampanha);

        if(campanha == null){
            throw new IllegalArgumentException("Campanha não encontrada!");
        }

        return campanha.getDoacoes();
    }

    public void verificarPrazo(Campanha campanha){
        Date hoje = new Date();

        if(hoje.after(campanha.getPrazo())){
            if(campanha.getTotalArrecadado() >= campanha.getMetaArrecadacao()){
                campanha.setStatus("SUCESSO");
            }
        }else{
            campanha.setStatus("CANCELADA");
        }
    }
    public void cancelarCampanha(String nomeCampanha) {
        Campanha campanha = campanhaRepo.buscarCampanhaPorNome(nomeCampanha);

        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não encontrada!");
        }

        if (!"ATIVA".equals(campanha.getStatus())) {
            throw new IllegalStateException("Apenas campanhas ativas podem ser canceladas!");
        }

        if (campanha.isExpirada()) {
            throw new IllegalStateException("Campanha expirada não pode ser cancelada!");
        }


        List<Doacao> doacoes = campanha.getDoacoes();
        double totalEstornado = 0.0;

        for (Doacao doacao : doacoes) {
            if (!doacao.isEstornada()) {
                Doador doador = doacao.getDoador();
                double valor = doacao.getValor();
                doador.depositar(valor);
                doacao.setEstornada(true);
                totalEstornado += valor;
            }
        }

        campanha.setStatus("CANCELADA");
        System.out.printf("Campanha '%s' cancelada! Total estornado: R$ %.2f para %d doador(es)%n",
                nomeCampanha, totalEstornado, doacoes.size());
    }
}

