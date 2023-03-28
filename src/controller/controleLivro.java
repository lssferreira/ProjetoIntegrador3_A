package controller;

import Utils.OpcoesView;
import model.Autor;
import model.Livro;
import obj.ListaEncadeada;

import java.util.Scanner;

public class controleLivro {

    public static void MostrarMenuLivros(ListaEncadeada<Livro> listaLivro) {
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
                default:{
                    OpcoesView.OpcaoInvalida();}

            }

        }
    }

    private static void MenuMostrarListaLivros(ListaEncadeada<Livro> listaLivro) {
        var continuar = true;
        while (continuar) {
            System.out.println("Opções Disponiveis:");
            System.out.println("1 - Apresentar os títulos de todos os livros cadastrados em ordem alfabética");
            System.out.println("2 - Apresentar os títulos dos livros de um determinado autor");
            System.out.println("3 - Apresentar os títulos dos livros publicados em um determinado intervalo de \nanos (p.ex.: livros publicados entre 2010 e 2015)");
            System.out.println("4 - Apresentar título, autor e editora de todos os livros que contém, no seu \ntítulo, uma palavra ou frase informada pelo usuário.\n");
            System.out.println("9 - Voltar");
            OpcoesView.DigiteaOpcaoDesejada();
            Scanner scanner = new Scanner(System.in);
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "9":{
                    continuar = false;
                    break;
                }
                default:
                    OpcoesView.OpcaoInvalida();

            }
        }
    }

    private static void MenuRemoverLivro(ListaEncadeada<Livro> listaLivro) {
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
                    listaLivro.removerInicio();
                    System.out.println("Registro removido do INICIO da Lista");
                    break;
                }
                case "2": {
                    listaLivro.removerFim();
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

    private static void MenuAdicionarLivro(ListaEncadeada<Livro> listaLivro) {
        Scanner scanner = new Scanner(System.in);
        Livro lv = new Livro("Livro 1", "320820382", new Autor("Autor"), 2023);
        var continuar = true;
        while (continuar) {
            System.out.println("Opções Disponiveis:");
            System.out.println("1 - Adicionar registro no inicio da lista");
            System.out.println("2 - Adicionar registro no fim da lista");
            System.out.println("9 - Voltar");
            OpcoesView.DigiteaOpcaoDesejada();
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "1":
                    listaLivro.inserirInicio(lv);
                    break;
                case "2":
                    listaLivro.inserirFim(lv);
                    break;
                case "9":
                    continuar = false;
                default:
                    OpcoesView.OpcaoInvalida();
            }
        }
    }
}
