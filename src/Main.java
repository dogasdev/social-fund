import java.util.InputMismatchException;
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
            processarOpcao(opcao);
        }while(opcao != 0);


    }
    public static void exibirMenu(){
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║          FINANCIAMENTO SOCIAL - MENU PRINCIPAL       ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("(1) Cadastrar Projeto Social \n(2) Listar projetos \n(3) Buscar Projeto \n(4) Fazer doação \n(5) Listar doações");
        System.out.println("Escolha uma opção: ");
    }

    public static int lerOpcao(Scanner userInput){
        try{

            return Integer.parseInt(userInput.nextLine());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void processarOpcao(int opcao){
        switch (opcao){
            case 1:
                System.out.println("OLÁ");
            break;
        }
    }
}