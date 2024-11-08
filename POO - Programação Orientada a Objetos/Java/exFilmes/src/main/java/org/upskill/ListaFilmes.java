package org.upskill;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmes {
    public List<Filme> listaFilmes;
    public String identificador;

    public ListaFilmes(String identificador){
        if (identificador == null || identificador.isEmpty() || !Character.isUpperCase(identificador.charAt(0))) {
            throw new IdentificadorInvalidoException("Identificador inválido: " + identificador);
        }
        this.identificador = identificador;
        this.listaFilmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        listaFilmes.add(filme);
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        if(!(Character.isUpperCase(identificador.charAt(0)))){
            throw new IdentificadorInvalidoException ("Identificador Invalido.");
        }
        this.identificador = identificador;
    }
}
