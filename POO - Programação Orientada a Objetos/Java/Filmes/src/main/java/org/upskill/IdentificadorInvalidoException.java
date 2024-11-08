package org.upskill;

public class IdentificadorInvalidoException extends RuntimeException{
    public IdentificadorInvalidoException() {
        super("ERRO: Identificador inválido.");
    }
    public IdentificadorInvalidoException(String msg) {
        super(msg);
    }
}
