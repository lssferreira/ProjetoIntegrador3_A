package obj;

import model.Livro;

import java.util.Comparator;
public class ComparadorLivroPorTitulo implements Comparator<Livro> {
        @Override
        public int compare(Livro livro1, Livro livro2) {
            return livro1.getTitulo().compareTo(livro2.getTitulo());
        }
    }

