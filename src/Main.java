import application.CampanhaService;
import domain.entities.Campanha;
import domain.entities.Doador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import infrastructure.CampanhaRepository;
import infrastructure.DoacoesRepository;
import infrastructure.DoadorRepository;
import java.util.List;

public class Main {
    private static CampanhaRepository campanhaRepo = new CampanhaRepository();
    private static DoacoesRepository doacoesRepo = new DoacoesRepository();
    private static DoadorRepository doadorRepo = new DoadorRepository();
    private static CampanhaService campanhaService = new CampanhaService(campanhaRepo);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner userInput = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao(userInput);
            processarOpcao(userInput, opcao);
        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║          FUNDOS SOCIAIS - MENU PRINCIPAL          ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("(1) Cadastrar Projeto Social \n(2) Fazer doação \n(3) Buscar Campanha \n(4) Listar campanhas \n" +
                "(5) Listar doações \n(6) Listar campanhas concluídas");
        System.out.println("Escolha uma opção: ");
    }

    public static int lerOpcao(Scanner userInput) {
        try {

            return Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void processarOpcao(Scanner userInput, int opcao) {
        switch (opcao) {
            case 1:
                criarCampanha(userInput);
                break;
            case 2:
                fazerDoacao(userInput);
                break;
            case 3:
                buscarCampanha(userInput);
                break;
            case 4:
                listarCampanhas();
                break;
            case 5:
                listarDoacoes(userInput);
                break;
            case 6:
                listarCampanhasConcluidas();
                break;
        }
    }

    public static void criarCampanha(Scanner userInput) {
        System.out.println("╔════════════════╗");
        System.out.println("║  NOVO PROJETO  ║ ");
        System.out.println("╠════════════════╣");
        System.out.println("Insira o nome do Projeto: ");
        String nome = userInput.nextLine();
        System.out.println("Meta de Arrecadação: ");
        Double metaArrecadacao = Double.parseDouble(userInput.nextLine());
        System.out.println("Prazo: (dd/MM/yyyy)");
        String prazoTexto = userInput.nextLine();
        System.out.println("Valor da Recompensa do Sorteio: ");
        Double valorRecompensa = Double.parseDouble(userInput.nextLine());

        Date prazo;

        try {
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            prazo = dataFormatada.parse(prazoTexto);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
            return;
        }

        String status = "ATIVA";

        Campanha campanha = new Campanha(nome, metaArrecadacao, prazo, status, valorRecompensa);
        campanhaService.cadastrarCampanha(campanha);
        System.out.println(campanha);
    }

    public static void fazerDoacao(Scanner userInput) {
        System.out.println("Insira o nome da Campanha: ");
        String nomeCampanha = userInput.nextLine();

        Campanha campanha = campanhaService.buscarCampanhaPorNome(nomeCampanha);

        if(campanha == null){
            System.out.println("Campanha não encontrada!");
            return;
        }

        System.out.println("Insira seu Nome: ");
        String nome = userInput.nextLine();

        System.out.println("Insira o valor da doação: ");
        double valorDoacao = Double.parseDouble(userInput.nextLine());

        Doador doador = new Doador(nome, valorDoacao);

        campanhaService.realizarDoacao(nomeCampanha, doador, valorDoacao);
        System.out.printf("[!] %s doou %.2f para a campanha %s%n%n", nome, valorDoacao, nomeCampanha);

        if (campanha.getRecompensa() != null) {
            System.out.println(campanha.getRecompensa().getMensagem());
        }

    }

    public static void buscarCampanha(Scanner userInput){
        System.out.println("Insira o nome da campanha: ");
        String nomeCampanha = userInput.nextLine();

        Campanha campanha = campanhaService.buscarCampanhaPorNome(nomeCampanha);

        if(campanha == null){
            System.out.println("Campanha não encontrada");
            return;
        }

        System.out.println(campanha);
    }

    public static void listarCampanhas(){
        List<Campanha> campanhas = campanhaService.listarCampanhas();

        if(campanhas.isEmpty()){
            System.out.println("Nenhuma campanha cadastrada");
            return;
        }

        System.out.println("╔════════════════════╗");
        System.out.println("║ LISTA DE CAMPANHAS ║");
        System.out.println("╠════════════════════╠");
        System.out.println();

        for (Campanha camp : campanhas) {
            System.out.printf("Nome: %s\n| Meta: R$%.2f\n| Prazo: %s\n| Status: %s\n\n", camp.getNome(), camp.getMetaArrecadacao(), camp.getPrazoFormatado(), camp.getStatus());
        }
    }

    public static void listarDoacoes(Scanner userInput){
        System.out.println("Insira o nome da campanha: ");
        String nome = userInput.nextLine();

        Campanha campanha = campanhaService.buscarCampanhaPorNome(nome);

        if(campanha == null){
            System.out.println("Campanha não encontrada!");
        }

        System.out.println(doacoesRepo.listarDoacoes());
    }

    public static void listarCampanhasConcluidas(){
        List<Campanha> campanhasConcluidas = campanhaRepo.buscarCampanhasConcluidas();

        for(Campanha campanha : campanhasConcluidas){
            System.out.println(campanha);
        }
    }
}