package Utils;


import java.util.Scanner;

public class OpcoesView {

    public static void OpcaoInvalida(){
        System.out.println("Opção Inválida! Clique Enter para apresentar as opções novamente!");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    public static void DigiteaOpcaoDesejada(){
        System.out.print("Digite o número da opção:");
    }
    public static void PressioneEnterParaContinuar(){
        System.out.print("Clique enter para continuar.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
