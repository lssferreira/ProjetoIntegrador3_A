import Utils.getListTest;
import Utils.OpcoesView;
import model.Autor;

import controller.controleAutor;
import controller.controleLivro;
import model.Livro;
import obj.ListaEncadeada;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        var autores = new ArrayList<Autor>();
        ListaEncadeada<Livro> listaLivro = new ListaEncadeada<Livro>();
        var listatesteCriada = false;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n*********************************************");
            System.out.println("*** Cadastro e Consulta de Livros e Autores ***");
            System.out.println("***********************************************");
            System.out.println("Opções Disponiveis:\n ");
            System.out.println("1 - Livros ");
            System.out.println("2 - Autores");
            if (!listatesteCriada)
                System.out.println("8 - Teste(Cria lista de autores e Livros)");
            OpcoesView.DigiteaOpcaoDesejada();
            var resp = scanner.nextLine().trim();

            switch (resp) {
                case "1" -> {
                    controleLivro.MostrarMenuLivros(listaLivro);
                    break;
                }
                case "2" -> {
                    controleAutor.MostrarMenuAutores(autores);
                    break;
                }
                case "8" -> {
                    if (!listatesteCriada)
                        getListTest.CriaListas(autores, listaLivro);
                    listatesteCriada = true;
                    break;
                }
                default -> {
                    OpcoesView.OpcaoInvalida();
                }
            }
        }

    }
}