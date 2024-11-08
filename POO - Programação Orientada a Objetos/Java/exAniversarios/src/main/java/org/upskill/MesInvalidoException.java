package org.upskill;

public class MesInvalidoException extends RuntimeException {
    public MesInvalidoException() {
        super("ERRO: Mes inválido.");
    }
    public MesInvalidoException(String msg) {
        super(msg);
    }
}
