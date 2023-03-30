package MenuView;

import controller.ControleAutor;
import model.Autor;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAutor {
    static Scanner scanner = new Scanner(System.in);

    public static void MostrarMenuAutores(ArrayList<Autor> autores) {
        var continuar = true;
        while (continuar) {
            OpcoesView.opcoesDisponiveis();
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Consulta Autor");
            OpcoesView.opcaoPadraoVoltar();
            var resp = scanner.nextLine().trim();
            switch (resp) {
                case "1": {
                    menuCadastrarAutor(autores);
                    break;
                }
                case "2": {
                    menuConsultarAutor(autores);
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

    private static void menuCadastrarAutor(ArrayList<Autor> autores) {
        System.out.println("Cadastro de Autores:");
        System.out.println("Digite o nome e o pais de origem do autor(Separado por virgula):");
        var x = scanner.nextLine().trim().split(",");
        ControleAutor.cadastrarAutor(autores, x);
    }

    public static void menuConsultarAutor(ArrayList<Autor> autores) {
        OpcoesView.opcoesDisponiveis();
        System.out.println("1 - Visualizar todos os autores cadastrados");
        System.out.println("2 - Pesquisar autor por nome");
        OpcoesView.opcaoPadraoVoltar();
        OpcoesView.digiteaOpcaoDesejada();
        switch (scanner.nextLine().trim()) {
            case "1": {
                ControleAutor.exibirAutor(autores);
                OpcoesView.pressioneEnterParaContinuar();
                break;
            }
            case "2": {
                System.out.print("Digite o nome do Autor:");
                var nomeAutor = scanner.nextLine().trim();
                ControleAutor.pesquisaAutorNome(autores, nomeAutor);
                break;
            }
            case "9": {
                break;
            }
            default: {
                OpcoesView.opcaoInvalida();
            }
        }
    }

}
