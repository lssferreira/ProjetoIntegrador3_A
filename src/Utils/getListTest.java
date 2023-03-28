package Utils;

import model.Autor;
import model.Livro;

import java.util.ArrayList;

public class getListTest {
    public static ArrayList<Livro> getListaLivros(){
        var x = new ArrayList<Livro>();
        x.add(new Livro("1984", "9780451524935", new Autor("George Orwell"), 1949));
        x.add(new Livro("Dom Quixote", "9788525410647", new Autor("Miguel de Cervantes"), 1605));
        x.add(new Livro("O Apanhador no Campo de Centeio", "9780316769174", new Autor("J.D. Salinger"), 1951));
        x.add(new Livro("A Divina Comédia", "9788573264994", new Autor("Dante Alighieri"), 1320));
        x.add(new Livro("Cem Anos de Solidão", "9788535914843", new Autor("Gabriel García Márquez"), 1967));
        x.add(new Livro("Moby Dick", "9780142437247", new Autor("Herman Melville"), 1851));
        x.add(new Livro("O Senhor dos Anéis", "9780544003415", new Autor("J.R.R. Tolkien"), 1954));
        x.add(new Livro("Ulisses", "9780141182803", new Autor("James Joyce"), 1922));
        x.add(new Livro("A Peste", "9788535902130", new Autor("Albert Camus"), 1947));
        x.add(new Livro("Os Lusíadas", "9788525407098", new Autor("Luís de Camões"), 1572));

        return x;
    }

    public static ArrayList<Autor> getListaAutores(){
        var y = new ArrayList<Autor>();
        y.add(new Autor("Gabriel García Márquez", "Colômbia"));
        y.add(new Autor("Jorge Luis Borges", "Argentina"));
        y.add(new Autor("Virginia Woolf", "Reino Unido"));
        y.add(new Autor("Albert Camus", "Argélia"));
        y.add(new Autor("Italo Calvino", "Itália"));
        y.add(new Autor("Chimamanda Ngozi Adichie", "Nigéria"));
        y.add(new Autor("Octavia E. Butler", "Estados Unidos"));
        y.add(new Autor("Haruki Murakami", "Japão"));
        y.add(new Autor("Margaret Atwood", "Canadá"));
        y.add(new Autor("Ngũgĩ wa Thiong'o", "Quênia"));
        return y;
    }

    public static void ImprimeLivro(){
        for (Livro livro : getListaLivros())
            System.out.println(livro.toString());
    }
    public static void ImprimeAutores(){
        for (Autor autor : getListaAutores())
            System.out.println(autor);
    }


}
