package obj.obsolete;
public class Node<T> {
    private T valor;
    private Node<T> proximo;

    public Node(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }
}
