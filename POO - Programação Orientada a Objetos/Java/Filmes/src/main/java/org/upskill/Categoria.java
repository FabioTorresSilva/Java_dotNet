package org.upskill;

public enum Categoria{
    COMEDIA("comédia"),
    ACAO("ação"),
    TERROR("terror"),
    DRAMA("drama"),
    ANIMACAO("animação");

    public final String nome;

    Categoria(String string) {
        this.nome =string;
    }
}