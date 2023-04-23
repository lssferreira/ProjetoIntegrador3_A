package model;


public class Livro {
    private String Titulo;
    private String Isbn;
    private Autor Autores;

    private String Editora;

    public Livro() {

    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String editora) {
        Editora = editora;
    }

    public Livro(String titulo, String isbn, Autor autores, int anoPublicao, String editora) {
        Titulo = titulo;
        Isbn = isbn;
        Autores = autores;
        AnoPublicao = anoPublicao;
        Editora = editora;
    }

    public Livro(String titulo, String isbn, Autor autores, int anoPublicao) {
        Titulo = titulo;
        Isbn = isbn;
        Autores = autores;
        AnoPublicao = anoPublicao;
    }

    @Override
    public String toString() {
        return "Livro: %s, ISBN  %s, %s , Ano Publicação: %d".formatted(getTitulo(), getIsbn(), getAutores().toString(), getAnoPublicao());
    }

    @Override
    public boolean equals(Object obj) {
        Livro NovoLivro = (Livro) obj;
        return this.getIsbn().equals(NovoLivro.getIsbn()) && this.getTitulo().equals(NovoLivro.getTitulo());
    }

    //region getters and setters
    private int AnoPublicao;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public Autor getAutores() {
        return Autores;
    }

    public void setAutores(Autor autores) {
        Autores = autores;
    }

    public int getAnoPublicao() {
        return AnoPublicao;
    }

    public void setAnoPublicao(int anoPublicao) {
        AnoPublicao = anoPublicao;
    }

    public void setAnoPublicao(String anoPublicao) {
        try {
            setAnoPublicao(Integer.parseInt(anoPublicao));
        } catch (Exception e) {
            setAnoPublicao(1);
        }

    }
    //endregion
}
