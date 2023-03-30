package MenuView;

import model.Autor;
import model.Livro;

import controller.ControleLivros;

import obj.ListaDeLivros;

import java.util.Scanner;

public class MenuLivros {

    public static void mostrarMenuLivros(ListaDeLivros listaLivro) {
        var continuar = true;
        while (continuar) {
            OpcoesView.opcoesDisponiveis();
            System.out.println("O - Mostrar Lista de Livros");
            System.out.println("1 - Mostrar Lista de Livros com ordenação personalizada");
            System.out.println("2 - Adicionar Livro");
            if (listaLivro.tamanho() > 0)
                System.out.println("3 - Remover Livro");
            OpcoesView.opcaoPadraoVoltar();
            OpcoesView.digiteaOpcaoDesejada();
            switch (new Scanner(System.in).nextLine()) {
                case "0": {
                    ControleLivros.exibirListaLivros(listaLivro);
                    OpcoesView.pressioneEnterParaContinuar();
                    break;
                }
                case "1": {
                    menuMostrarListaLivros(listaLivro);
                    break;
                }
                case "2": {
                    menuAdicionarLivro(listaLivro);
                    break;
                }
                case "3": {
                    if (listaLivro.tamanho() > 0)
                        menuRemoverLivro(listaLivro);
                    break;
                }
                case "9": {
                    continuar = false;
                    break;
                }
                default: {
                    OpcoesView.opcaoInvalida();
                }

            }

        }
    }

    private static void menuMostrarListaLivros(ListaDeLivros listaLivro) {
        var continuar = true;
        while (continuar) {
            OpcoesView.opcoesDisponiveis();
            System.out.println("1 - Ordenar lista de livros em ordem alfabética");
            System.out.println("2 - Apresentar os títulos dos livros de um determinado autor");
            System.out.println("3 - Apresentar os títulos dos livros publicados em um determinado intervalo de \nanos (p.ex.: livros publicados entre 2010 e 2015)");
            System.out.println("4 - Apresentar título, autor e editora de todos os livros que contém, no seu \ntítulo, uma palavra ou frase informada pelo usuário.\n");
            OpcoesView.opcaoPadraoVoltar();
            OpcoesView.digiteaOpcaoDesejada();
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "1": {
                    ControleLivros.ordenar(listaLivro);
                    ControleLivros.exibirListaLivros(listaLivro);
                    OpcoesView.pressioneEnterParaContinuar();
                    break;
                }
                case "2": {
                    System.out.print("Digite o nome do Autor:");
                    ControleLivros.mostrarListaLivrosAutor(listaLivro);
                    break;
                }
                case "3": {
                    System.out.print("\nDigite o periodo a ser filtrado (p.ex.: 1800 , 2023 ):");
                    var anos = scanner.nextLine().trim().split(",");
                    ControleLivros.mostrarListaLivrosAnoPublicao(listaLivro, anos);
                    break;
                }
                case "4": {
                    System.out.print("\nDigite o titulo do livro");
                    var titulo = scanner.nextLine().trim();
                    ControleLivros.mostrarListaLivrosTitulo(listaLivro, titulo);
                    break;
                }
                case "9": {
                    continuar = false;
                    break;
                }
                default: {
                    OpcoesView.opcaoInvalida();
                }

            }
        }
    }

    private static void menuRemoverLivro(ListaDeLivros listaLivro) {
        var continuar = true;
        while (continuar) {
            continuar = false;
            OpcoesView.opcoesDisponiveis();
            System.out.println("1 - Remover o primeiro Livro da lista");
            System.out.println("2 - Remove o último Livro da lista");
            OpcoesView.opcaoPadraoVoltar();
            OpcoesView.digiteaOpcaoDesejada();
            switch (new Scanner(System.in).nextLine()) {
                case "1": {
                    ControleLivros.removerDoInicio(listaLivro);
                    System.out.println("Registro removido do INICIO da Lista");
                    break;
                }
                case "2": {
                    ControleLivros.removerDoFim(listaLivro);
                    System.out.println("\nRegistro removido do FIM da Lista\n");
                    break;
                }
                case "9": {
                    break;
                }
                default: {
                    continuar = true;
                    OpcoesView.opcaoInvalida();
                }
            }
        }
    }

    private static void menuAdicionarLivro(ListaDeLivros listaLivro) {
        Livro lv = cadastrarLivro();

        var continuar = true;
        while (continuar) {
            OpcoesView.opcoesDisponiveis();
            System.out.println("1 - Adicionar registro no inicio da lista");
            System.out.println("2 - Adicionar registro no fim da lista");
            System.out.println("9 - Cancelar cadastro");
            OpcoesView.digiteaOpcaoDesejada();
            continuar = false;
            switch (new Scanner(System.in).nextLine()) {
                case "1": {
                    ControleLivros.incluiLivroNoInicio(listaLivro, lv);
                    break;
                }
                case "2": {
                    ControleLivros.incluiLivroNoFim(listaLivro, lv);
                    break;
                }
                case "9": {
                    break;
                }
                default: {
                    continuar = true;
                    OpcoesView.opcaoInvalida();
                }
            }
        }
    }

    private static Livro cadastrarLivro() {
        System.out.println("Digite as informações do livro a ser inserido na lista:");
        Scanner scanner = new Scanner(System.in);
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
        return lv;
    }
}



