package org.upskill;

import java.util.ArrayList;

import static java.lang.Character.isUpperCase;

public class ListaFilmes {

    private String id;
    private ArrayList<Filme> lista;

    private static final String ID_OMISSAO = "A0";

    public ListaFilmes( String id,ArrayList<Filme> lista) {
        setId(id);
        setLista(lista);
    }

    public ListaFilmes() {
        lista = new ArrayList<Filme>();
        id = ID_OMISSAO;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Filme> getLista() {
        return new ArrayList<>(lista);
    }

    public void setId(String id) {
        if (id == null || id.isEmpty() || !isUpperCase(id.charAt(0))) {
            throw new IdentificadorInvalidoException(String.format("ERRO: Este identificador: %s é inválido.", id));
        }
        this.id = id;
    }
    public void setLista(ArrayList<Filme> lista) {
        this.lista = new ArrayList<>(lista);
    }

    @Override
    public String toString() {
        return String.format("Id: %s\nLista: %s\n", id, listaToString());
    }

    public String listaToString() {
        StringBuilder s = new StringBuilder();
        for (Filme i : this.lista) {
            if (i != null) {
                s.append(i.toString());
                s.append("\n");
            }
        }
        return s.toString();
    }

    public boolean adicionarFilme(Filme filme) {
        return lista.contains(filme) ? false : lista.add(filme);
    }

    public boolean removerFilme(Filme filme) {
        return lista.remove(filme);
    }

}

