import Utils.getListTest;
import Utils.OpcoesView;
import model.Autor;

import controller.controleAutor;
import controller.controleLivro;
import obj.ListaDeLivros;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        var autores = new ArrayList<Autor>();

        //region Esperar retorno professor
        // TODO: 30/03/2023 Verificar na correção se é necessario utilizar e implementar uma lista encadeada ou se é possivel utilizar um objeto java existente;
        // obsolet: ListaEncadeada<Livro> listaLivro = new ListaEncadeada<Livro>();
        //endregion

        ListaDeLivros listaLivro = new ListaDeLivros();

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