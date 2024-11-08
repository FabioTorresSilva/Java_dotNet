package org.upskill;

public class CategoriaInvalidaException extends RuntimeException{
    public CategoriaInvalidaException() {
        super("ERRO: Categoria inválida.");
    }

    public CategoriaInvalidaException(String msg) {
        super(msg);
    }
}

