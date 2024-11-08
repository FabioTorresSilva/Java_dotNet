package org.upskill;

public class DiaInvalidoException extends RuntimeException {
    public DiaInvalidoException() {
        super("ERRO: Dia inválido.");
    }
    public DiaInvalidoException(String msg) {
        super(msg);
    }
}
