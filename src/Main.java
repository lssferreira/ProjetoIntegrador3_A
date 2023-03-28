import Utils.getListTest;
import model.Autor;

import controller.controleAutor;
import controller.controleLivro;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

       var autores = new ArrayList<Autor>();

       // Adiciona lista de autores para teste
       autores.addAll(getListTest.getListaAutores());


        while(true)
        {
            System.out.println("\n*************************************");
            System.out.println("*** Cadastro e Consulta de Livros ***");
            System.out.println("*************************************");
            System.out.println("\nOpções Disponiveis:\n ");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Autor");
            System.out.println("3 - Consulta Livro");
            System.out.println("4 - Consulta Autor");

            Scanner scanner = new Scanner(System.in);
            boolean OpcaoValida = false;
            while (!OpcaoValida)
            {
                System.out.print("\nDigite o número da opção:");
                var resp = scanner.nextLine().trim();

                switch (resp) {
                    case "1" -> {
                        // TODO CADASTRAR LIVRO
                        controleLivro.CadastrarLivro();
                        OpcaoValida = true;
                    }
                    case "2" -> {
                        controleAutor.CadastrarAutor(autores);
                        OpcaoValida = true;
                    }
                    case "3" -> {
                        // TODO CONSULTAR LIVRO
                        controleLivro.ConsultarLivro();
                        OpcaoValida = true;
                    }
                    case "4" -> {
                        controleAutor.ConsultarAutor(autores);
                        OpcaoValida = true;
                    }
                    //case "5":
                    //    getListTest.ImprimeLivro();
                    //    getListTest.ImprimeAutores();
                    //    OpcaoValida = true;
                    //    break;
                    default -> {
                        System.out.println("Opção Inválida!");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}