package obj;

import java.util.Comparator;

public class ListaEncadeada<T> {
    private Node<T> inicio;

    private int tamanho;

    public int getTamanho() {
        return this.tamanho;
    }

    public ListaEncadeada() {
        this.inicio = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int Tamanho(){
        return tamanho;
    }

    public void inserirInicio(T valor) {
        Node<T> novoNode = new Node<>(valor);
        novoNode.setProximo(inicio);
        inicio = novoNode;
        tamanho++;
    }

    public void inserirFim(T valor) {
        Node<T> novoNode = new Node<>(valor);
        if (estaVazia()) {
            inicio = novoNode;
        } else {
            Node<T> nodeAtual = inicio;
            while (nodeAtual.getProximo() != null) {
                nodeAtual = nodeAtual.getProximo();
            }
            nodeAtual.setProximo(novoNode);
            tamanho++;
        }
    }

    public void removerInicio() {
        if (!estaVazia()) {
            inicio = inicio.getProximo();
            tamanho--;
        }
    }

    public void removerFim() {
        if (!estaVazia()) {
            if (inicio.getProximo() == null) {
                inicio = null;
            } else {
                Node<T> nodeAtual = inicio;
                while (nodeAtual.getProximo().getProximo() != null) {
                    nodeAtual = nodeAtual.getProximo();
                }
                nodeAtual.setProximo(null);
                tamanho--;
            }
        }
    }

    public void exibirLista() {
        Node<T> nodeAtual = inicio;
        if (this.estaVazia())
            System.out.print("Lista vazia");
        else
            System.out.println("Lista de Livros:");
        while (nodeAtual != null) {
            System.out.println(nodeAtual.getValor());
            nodeAtual = nodeAtual.getProximo();
        }
        System.out.println("Tamanho da Lista:" + this.Tamanho());
    }


    public void ordenar(Comparator<T> comparador) {
        if (inicio == null) {
            return;
        }

        boolean troca = true;

        while (troca) {
            troca = false;

            Node<T> anterior = null;
            Node<T> atual = inicio;
            Node<T> proximo = inicio.getProximo();

            while (proximo != null) {
                if (comparador.compare(atual.getValor(), proximo.getValor()) > 0) {
                    atual.setProximo(proximo.getProximo());
                    proximo.setProximo(atual);

                    if (anterior == null) {
                        inicio = proximo;
                    } else {
                        anterior.setProximo(proximo);
                    }

                    anterior = proximo;
                    proximo = atual.getProximo();

                    troca = true;
                } else {
                    anterior = atual;
                    atual = atual.getProximo();
                    proximo = atual.getProximo();
                }
            }
        }
    }
}