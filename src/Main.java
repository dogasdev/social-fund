import application.CampanhaService;
import domain.entities.Campanha;
import domain.entities.Doador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import infrastructure.CampanhaRepository;

public class Main {
    static CampanhaRepository campanhaRepo = new CampanhaRepository();
    static CampanhaService campanhaService = new CampanhaService(campanhaRepo);

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
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║          FINANCIAMENTO SOCIAL - MENU PRINCIPAL       ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("(1) Cadastrar Projeto Social \n(2) Fazer doação \n(3) Buscar Projeto \n(4) Listar projetos \n" +
                "(5) Listar doações \n(6) Ver recompensas \n(7) Ver metas batidas");
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
        System.out.println("Prazo: ");
        String prazoTexto = userInput.nextLine();

        Date prazo;

        try {
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            prazo = dataFormatada.parse(prazoTexto);
        } catch (ParseException e) {
            System.out.println("Data inválida!");
            return;
        }

        String status = "ATIVA";

        Campanha campanha = new Campanha(nome, metaArrecadacao, prazo, status);
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

        Doador doador = new Doador(nome, 0.0);

        System.out.println("Insira o dinheiro na sua conta: ");
        double valorDeposito = Double.parseDouble(userInput.nextLine());
        doador.depositar(valorDeposito);
        System.out.println("Insira o valor da doação: ");
        double valorDoacao = Double.parseDouble(userInput.nextLine());
        campanhaService.realizarDoacao(nomeCampanha, doador, valorDoacao);
        System.out.printf("[!] %s doou %.2f para a campanha %s\n\n", nome, valorDoacao, nomeCampanha);
    }

}