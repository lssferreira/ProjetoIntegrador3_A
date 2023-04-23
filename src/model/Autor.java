package model;

public class Autor {
    private String Nome;
    private String PaisOrigem;

    public Autor(String nome, String paisOrigem) {
        Nome = nome;
        PaisOrigem = paisOrigem;
    }

    public Autor(String nome) {
        Nome = nome;
    }

    public Autor() {
    }

    @Override
    public boolean equals(Object obj) {
        Autor NovoAutor = (Autor) obj;
        return this.getNome().equals(NovoAutor.getNome()) && this.getPaisOrigem().equals(NovoAutor.getPaisOrigem());
    }

    @Override
    public String toString() {
        if (getPaisOrigem() != "")
            return "Autor: %s , %s".formatted(getNome(), getPaisOrigem());
        else
            return "Autor: %s".formatted(getNome());

    }
    //region getter
    public String getNome() {
        return Nome;
    }

    public String getPaisOrigem() {
        if (PaisOrigem != null)
            return PaisOrigem;
        else
            return "";
    }
    //endregion
}
