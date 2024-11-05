package org.upskill;

public enum Sinal {
    PEDRA,PAPEL,TESOURA;

    public boolean vence(Sinal outro) {
        return (this == PEDRA && outro == TESOURA) ||
                (this == PAPEL && outro == PEDRA) ||
                (this == TESOURA && outro == PAPEL);
    }
}
