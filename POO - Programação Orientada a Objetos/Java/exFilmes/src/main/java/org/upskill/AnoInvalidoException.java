package org.upskill;

public class AnoInvalidoException extends RuntimeException {
    public AnoInvalidoException() {
        super("Ano Realizacao Invalido");
    }
    public AnoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
