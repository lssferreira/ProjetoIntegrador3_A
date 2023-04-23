package controller;

import model.Autor;
import model.Livro;
import obj.ListaDeLivros;

import java.util.Scanner;

public class ControleLivros {

    public static void mostrarListaLivrosTitulo(ListaDeLivros listaLivro, String titulo) {
        listaLivro.filtrarListaPorTitulo(titulo);
    }

    public static void mostrarListaLivrosAnoPublicao(ListaDeLivros listaLivro, String[] anos) {
        listaLivro.filtrarListaPorPeriodoAnoPublicacao(Integer.parseInt(anos[0]), Integer.parseInt(anos[1]));
    }

    public static void mostrarListaLivrosAutor(ListaDeLivros listaLivro) {
        Scanner scanner = new Scanner(System.in);
        Autor autor = new Autor(scanner.nextLine().trim());
        listaLivro.filtrarListaPorAutor(autor);
    }

    public static void exibirListaLivros(ListaDeLivros listaLivro) {
        listaLivro.exibirLista();
    }

    public static void ordenar(ListaDeLivros listaLivro) {
        listaLivro.ordenar();
    }

    public static void incluiLivroNoInicio(ListaDeLivros listaLivro, Livro lv) {
        listaLivro.incluiNoInicio(lv);
    }

    public static void incluiLivroNoFim(ListaDeLivros listaLivro, Livro lv) {
        listaLivro.incluiNoFim(lv);
    }

    public static void removerDoInicio(ListaDeLivros listaLivro) {
            listaLivro.removerDoInicio();
    }

    public static void removerDoFim(ListaDeLivros listaLivro) {
        listaLivro.removerDoFim();
    }

    public static boolean ExisteLivro(ListaDeLivros listaLivro, Livro lv) {
        return listaLivro.ExisteLivro(lv);
    }
}
