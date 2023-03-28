package controller;

import model.Livro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListaDeLivros {


    private final ArrayList<Livro> ListaLivro;

    public ListaDeLivros() {
        ListaLivro = new ArrayList<Livro>();
    }

    public void incluirNoInicio(Livro pLivro){
        ListaLivro.add(0,pLivro);
    }
    public void incluirNoFim(Livro pLivro){
        ListaLivro.add(ListaLivro.size(),pLivro);
    }

    public void Ordenar(){
    }

}
