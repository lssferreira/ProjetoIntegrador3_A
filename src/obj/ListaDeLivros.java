package obj;

import model.Autor;
import model.Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaDeLivros {
    private ArrayList<Livro> listlivros;

    public ListaDeLivros() {
        this.listlivros = new ArrayList<Livro>();
    }

    public void incluiNoInicio(Livro livro) {
        this.listlivros.add(0, livro);
    }

    public void incluiNoFim(Livro livro) {
        this.listlivros.add(livro);
    }

    public void ordenar() {
        Comparator<Livro> comparador = new ComparadorLivroPorTitulo();
        Collections.sort(listlivros, comparador);
    }

    public Livro removerDoInicio() {
        return this.listlivros.remove(0);
    }

    public Livro removerDoFim() {
        return this.listlivros.remove((this.tamanho() - 1));
    }

    public int tamanho() {
        return this.listlivros.size();
    }

    public Livro get(int i) {
        return this.listlivros.get(i);
    }

    public void exibirLista() {
        for (Livro livro : this.listlivros)
            System.out.println(livro.toString());
    }

    public void FiltrarListaPorAutor(Autor autor) {
        for (Livro livro : this.listlivros)
            if (livro.getAutores().getNome().toUpperCase().contains(autor.getNome().toUpperCase()))
                System.out.println(livro.toString());
    }

    public void FiltrarListaPorPeriodoAnoPublicacao(int pAnoInicial, int pAnoFinal) {
        for (Livro livro : this.listlivros)
            if (livro.getAnoPublicao() >= pAnoInicial && livro.getAnoPublicao() <= pAnoFinal)
                System.out.println(livro.toString());
    }

    public void FiltrarListaPorTitulo(String Titulo) {
        for (Livro livro : this.listlivros)
            if (livro.getTitulo().toUpperCase().contains(Titulo.toUpperCase()))
                System.out.println("Livro: %s, Autor:(%s), Ano Publicação: %d, Editora: %s".formatted(livro.getTitulo(), livro.getAutores(), livro.getAnoPublicao(), livro.getEditora()));
    }
}
