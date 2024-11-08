package org.upskill;

public class IdentificadorInvalidoException extends RuntimeException {
    public IdentificadorInvalidoException() {
        super("identificador Invalido");
    }
    public IdentificadorInvalidoException(String mensagem) {
        super(mensagem);
    }
}
