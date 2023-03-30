package MenuView;


import java.util.Scanner;

public class OpcoesView {

    public static void opcaoInvalida(){
        System.out.println("\nOpção Inválida!\nPressione Enter para apresentar as opções novamente!");
        new Scanner(System.in).nextLine();
    }
    public static void digiteaOpcaoDesejada(){
        System.out.print("\nDigite o número da opção:");
    }
    public static void opcoesDisponiveis(){
        System.out.println("\nOpções Disponiveis");
    }
    public static void opcaoPadraoVoltar(){
        System.out.println("9 - Voltar");
    }
    public static void pressioneEnterParaContinuar(){
        System.out.print("\nPressione enter para continuar");
        new Scanner(System.in).nextLine();
    }
}
