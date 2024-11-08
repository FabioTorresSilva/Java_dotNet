package org.upskill;


public class AnoInvalidoException extends RuntimeException{
    public AnoInvalidoException() {
        super("ERRO: Ano inválido.");
    }
    public AnoInvalidoException(String msg) {
        super(msg);
    }
}

