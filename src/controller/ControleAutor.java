package controller;

import MenuView.OpcoesView;
import model.Autor;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleAutor {
    static Scanner scanner = new Scanner(System.in);

    public static void cadastrarAutor(ArrayList<Autor> autores, String[] autor) {
        if (autor.length == 2)
            autores.add(new Autor(autor[0], autor[1]));
        else
            autores.add(new Autor(autor[0]));
    }

    public static void pesquisaAutorNome(ArrayList<Autor> autores, String nomeAutor) {
        ArrayList<Autor> listFilter = new ArrayList<Autor>();
        for (Autor elemento : autores) {
            if (elemento.getNome().toUpperCase().contains(nomeAutor.toUpperCase()))
                listFilter.add(elemento);
        }
        exibirAutor(listFilter);
    }

    public static void exibirAutor(ArrayList<Autor> autores) {

        for (Autor elemento : autores) {
            System.out.println(elemento.toString());
        }
        System.out.print("\nRegistros encontrados:" + autores.size());
    }

}
