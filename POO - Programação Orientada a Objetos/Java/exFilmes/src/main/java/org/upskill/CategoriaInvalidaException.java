package org.upskill;

public class CategoriaInvalidaException extends RuntimeException {
    public CategoriaInvalidaException() {
        super("Categoria Invalida.");
    }
    public CategoriaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
