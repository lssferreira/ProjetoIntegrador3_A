package obj;

import obj.Nodo;

public class ListaEncadeada<T> {
    private Nodo<T> inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void inserirInicio(T valor) {
        Nodo<T> novoNodo = new Nodo<>(valor);
        novoNodo.setProximo(inicio);
        inicio = novoNodo;
    }

    public void inserirFim(T valor) {
        Nodo<T> novoNodo = new Nodo<>(valor);
        if (estaVazia()) {
            inicio = novoNodo;
        } else {
            Nodo<T> nodoAtual = inicio;
            while (nodoAtual.getProximo() != null) {
                nodoAtual = nodoAtual.getProximo();
            }
            nodoAtual.setProximo(novoNodo);
        }
    }

    public void removerInicio() {
        if (!estaVazia()) {
            inicio = inicio.getProximo();
        }
    }

    public void removerFim() {
        if (!estaVazia()) {
            if (inicio.getProximo() == null) {
                inicio = null;
            } else {
                Nodo<T> nodoAtual = inicio;
                while (nodoAtual.getProximo().getProximo() != null) {
                    nodoAtual = nodoAtual.getProximo();
                }
                nodoAtual.setProximo(null);
            }
        }
    }

    public void exibirLista() {
        Nodo<T> nodoAtual = inicio;
        if (this.estaVazia())
            System.out.print("Lista vazia");
        else
            System.out.println("Lista de Livros:");
        while (nodoAtual != null) {
            System.out.println(nodoAtual.getValor());
            nodoAtual = nodoAtual.getProximo();
        }
        System.out.println();
    }
}