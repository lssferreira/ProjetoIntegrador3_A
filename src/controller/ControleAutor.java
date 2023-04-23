package controller;

import model.Autor;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleAutor {

    public static void cadastrarAutor(ArrayList<Autor> autores, String[] autor) {

        Autor aux;
        if (autor.length == 2)
            aux = (new Autor(autor[0], autor[1]));
        else
            aux = (new Autor(autor[0]));

        try {
            if (ExisteAutor(autores, aux))
                throw new IllegalArgumentException("Autor já cadastrado");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        autores.add(aux);
    }

    private static boolean ExisteAutor(ArrayList<Autor> autores, Autor aux) {
        for (Autor elemento : autores) {
            if (elemento.equals(aux))
                return true;
        }
        return false;
    }

    public static void pesquisaAutorNome(ArrayList<Autor> autores, String nomeAutor) {
        ArrayList<Autor> listFilter = new ArrayList<>();
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
