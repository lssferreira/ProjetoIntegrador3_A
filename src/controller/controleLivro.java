package controller;

import Utils.OpcoesView;
import model.Autor;
import model.Livro;
import obj.ComparadorLivroPorTitulo;
import obj.ListaDeLivros;

import java.util.Comparator;
import java.util.Scanner;

public class controleLivro {

    public static void MostrarMenuLivros(ListaDeLivros listaLivro) {
        Scanner scanner = new Scanner(System.in);
        var continuar = true;
        while (continuar) {
            System.out.println("Opções Disponiveis:");
            System.out.println("O - Mostrar Lista de Livros");
            System.out.println("1 - Mostrar Lista de Livros com ordenação personalizada");
            System.out.println("2 - Adicionar Livro");
            System.out.println("3 - Remover Livro");
            System.out.println("9 - Voltar");
            OpcoesView.DigiteaOpcaoDesejada();
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "0": {
                    listaLivro.exibirLista();
                    OpcoesView.PressioneEnterParaContinuar();
                    break;
                }
                case "1": {
                    MenuMostrarListaLivros(listaLivro);
                    break;
                }
                case "2": {
                    MenuAdicionarLivro(listaLivro);
                    break;
                }
                case "3": {
                    MenuRemoverLivro(listaLivro);
                    break;
                }
                case "9": {
                    continuar = false;
                    break;
                }
                default: {
                    OpcoesView.OpcaoInvalida();
                }

            }

        }
    }

    private static void MenuMostrarListaLivros(ListaDeLivros listaLivro) {
        var continuar = true;
        while (continuar) {
            System.out.println("\nOpções Disponiveis:");
            System.out.println("1 - Apresentar os títulos de todos os livros cadastrados em ordem alfabética");
            System.out.println("2 - Apresentar os títulos dos livros de um determinado autor");
            System.out.println("3 - Apresentar os títulos dos livros publicados em um determinado intervalo de \nanos (p.ex.: livros publicados entre 2010 e 2015)");
            System.out.println("4 - Apresentar título, autor e editora de todos os livros que contém, no seu \ntítulo, uma palavra ou frase informada pelo usuário.\n");
            System.out.println("9 - Voltar");
            OpcoesView.DigiteaOpcaoDesejada();
            Scanner scanner = new Scanner(System.in);
            Comparator<Livro> comparador = new ComparadorLivroPorTitulo();
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "1": {
                    listaLivro.ordenar();
                    listaLivro.exibirLista();
                    break;
                }
                case "2": {
                    System.out.print("Digite o nome do Autor:");
                    MostrarListaLivrosAutor(listaLivro);
                    break;
                }
                case "3": {
                    System.out.print("\nDigite o periodo a ser filtrado (Exemplo: 1800 , 2023 ):");
                    var anos = scanner.nextLine().trim().split(",");
                    MostrarListaLivrosAnoPublicao(listaLivro, anos);
                    break;
                }
                case "4": {
                    System.out.print("\nDigite o titulo do livro");
                    var titulo = scanner.nextLine().trim();
                    MostrarListaLivrosTitulo(listaLivro, titulo);
                    break;
                }
                case "9": {
                    continuar = false;
                    break;
                }
                default: {
                    OpcoesView.OpcaoInvalida();
                }

            }
        }
    }

    private static void MostrarListaLivrosTitulo(ListaDeLivros listaLivro, String titulo) {
        listaLivro.FiltrarListaPorTitulo(titulo);
    }

    private static void MostrarListaLivrosAnoPublicao(ListaDeLivros listaLivro, String[] anos) {
        listaLivro.FiltrarListaPorPeriodoAnoPublicacao(Integer.parseInt(anos[0]), Integer.parseInt(anos[1]));
    }

    private static void MostrarListaLivrosAutor(ListaDeLivros listaLivro) {
        Scanner scanner = new Scanner(System.in);
        Autor autor = new Autor(scanner.nextLine().trim());
        listaLivro.FiltrarListaPorAutor(autor);
    }

    private static void MenuRemoverLivro(ListaDeLivros listaLivro) {
        var continuar = true;
        while (continuar) {
            System.out.println("Opções Disponiveis:");
            System.out.println("1 - Remove registro no inicio da lista");
            System.out.println("2 - Remove registro no fim da lista");
            System.out.println("9 - Voltar");
            OpcoesView.DigiteaOpcaoDesejada();
            Scanner scanner = new Scanner(System.in);
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "1": {
                    listaLivro.removerDoInicio();
                    System.out.println("Registro removido do INICIO da Lista");
                    break;
                }
                case "2": {
                    listaLivro.removerDoFim();
                    System.out.println("\nRegistro removido do FIM da Lista\n");
                    break;
                }
                case "9": {
                    continuar = false;
                    break;
                }
                default: {
                    OpcoesView.OpcaoInvalida();
                }
            }
        }
    }

    private static void MenuAdicionarLivro(ListaDeLivros listaLivro) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as informações do livro a ser inserido na lista:");

        Livro lv = new Livro();

        System.out.print("\nTitulo:");
        lv.setTitulo(scanner.nextLine());
        System.out.print("\nISBN:");
        lv.setIsbn(scanner.nextLine());
        System.out.print("\nAutor:");
        lv.setAutores(new Autor(scanner.nextLine()));
        System.out.print("\nEditora:");
        lv.setEditora(scanner.nextLine());
        System.out.print("\nAno de Publicação:");
        lv.setAnoPublicao(scanner.nextLine());

        System.out.println("\nLivro a ser cadastrado");
        lv.toString();


        var continuar = true;
        while (continuar) {
            System.out.println("Opções Disponiveis:");
            System.out.println("1 - Adicionar registro no inicio da lista");
            System.out.println("2 - Adicionar registro no fim da lista");
            System.out.println("9 - Cancelar cadastro");
            OpcoesView.DigiteaOpcaoDesejada();
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "1": {
                    listaLivro.incluiNoInicio(lv);
                    continuar = false;
                    break;
                }
                case "2": {
                    listaLivro.incluiNoFim(lv);
                    continuar = false;
                    break;
                }
                case "9": {
                    continuar = false;
                    break;
                }
                default: {
                    OpcoesView.OpcaoInvalida();
                }
            }
        }
    }
}
