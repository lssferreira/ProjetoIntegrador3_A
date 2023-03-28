package model;

import java.util.ArrayList;
import java.util.Scanner;

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


    @Override
    public String toString(){
        return "Autor: %s , %s".formatted(getNome(), getPaisOrigem());
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

}
