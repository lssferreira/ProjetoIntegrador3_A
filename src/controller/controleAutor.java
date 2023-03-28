package controller;

import model.Autor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class controleAutor {
    static Scanner scanner = new Scanner(System.in);

    public static void CadastrarAutor(ArrayList<Autor> autores) {

        System.out.println("Cadastro de Autores:");
        // TODO: Implementar tratamento para excesses.
        System.out.println("Digite o nome e o pais de origem do autor(Separado por virgula):");

        var x = scanner.nextLine().trim().split(",");

        //Adiciona autor na list
        autores.add(new Autor(x[0], x[1]));
    }

    public static void ConsultarAutor(ArrayList<Autor> autores) {
        System.out.println("Opções Disponiveis: ");
        System.out.println("1 - Visualizar todos os autores cadastrados");
        System.out.println("2 - Pesquisar autor por nome");
        System.out.println("9 - Voltar");
        System.out.print("\nDigite o número da opção.");


        switch (scanner.nextLine().trim()) {
            case "1":
                ImprimeAutores(autores);
                break;
            case "2":
                PesquisaAutorNome(autores);
                break;
        }
    }

    private static void PesquisaAutorNome(ArrayList<Autor> autores) {
        List<Autor> listFilter = new ArrayList<Autor>();
        System.out.print("Digite o nome do Autor:");
        var nomeAutor = scanner.nextLine().trim();
        for (Autor elemento : autores) {
            if (nomeAutor.toUpperCase().contains(elemento.getNome().toUpperCase()))
                listFilter.add(elemento);
        }
        ImprimeAutores((ArrayList<Autor>) listFilter);
    }

    private static void ImprimeAutores(ArrayList<Autor> autores) {

        for (Autor elemento : autores) {
            System.out.println(elemento.toString());
        }
        System.out.print("\nRegistros encontrados:" + autores.size());
        System.out.print("\nDigite alguma tecla para voltar.");
        var exit = scanner.nextLine();
    }

    public static void MostrarMenuAutores(ArrayList<Autor> autores) {
        Scanner scanner = new Scanner(System.in);
        var continuar = true;
        while (continuar) {
            System.out.println("Opções Disponiveis:");
            System.out.println("O - Mostrar Lista de Autores");
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Consulta Autor");
            System.out.println("9 - Voltar");
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "0": {
                    controleAutor.ImprimeAutores(autores);
                    break;
                }
                case "1": {
                    controleAutor.CadastrarAutor(autores);
                    break;
                }
                case "2": {
                    controleAutor.ConsultarAutor(autores);
                    break;
                }
                case "9": {
                    continuar = false;break;
                }
                default: {
                    System.out.println("Opção Inválida! Clique Enter para apresentar as opções novamente!");
                    scanner.nextLine();
                }
            }

        }
    }
}
