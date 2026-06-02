import domain.entities.Campanha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner userInput = new Scanner(System.in);
        int opcao;

        do{
            exibirMenu();
            opcao = lerOpcao(userInput);
            processarOpcao(userInput, opcao);
        }while(opcao != 0);
    }
    public static void exibirMenu(){
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║          FINANCIAMENTO SOCIAL - MENU PRINCIPAL       ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("(1) Cadastrar Projeto Social \n(2) Listar projetos \n(3) Buscar Projeto \n(4) Fazer doação \n(5)" +
                "Listar doações \n(6) Ver recompensas \n(7) Ver metas batidas");
        System.out.println("Escolha uma opção: ");
    }

    public static int lerOpcao(Scanner userInput){
        try{

            return Integer.parseInt(userInput.nextLine());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void processarOpcao(Scanner userInput, int opcao){
        switch (opcao){
            case 1:
                criarCampanha(userInput);
                break;
        }
    }

    public static void criarCampanha(Scanner userInput){
        System.out.println("╔════════════════╗");
        System.out.println("║  NOVO PROJETO  ║ ");
        System.out.println("╠════════════════╣");
        System.out.println("Insira o nome do Projeto: ");
        String nome = userInput.nextLine();
        System.out.println("Meta de Arrecadação: ");
        Double metaArrecadacao = Double.parseDouble(userInput.nextLine());
        System.out.println("Prazo: ");
        String prazoTexto = userInput.nextLine();

        Date prazo = null;
        try{
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            prazo = dataFormatada.parse(prazoTexto);
        }catch (ParseException e){
            System.out.println("Data inválida!");
            return;
        }

        String status = "ATIVA";

        Campanha campanha = new Campanha(nome, metaArrecadacao, prazo, status);
        System.out.println(campanha);
    }
}