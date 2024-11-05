
/**
 * Define uma enumeração com três elementos, designada Sinal.
 */

public enum Sinal {
    PEDRA(10), PAPEL(20), TESOURA(30);
    private int valor;

    Sinal(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    /*
        Pedra ganha à tesoura (quebrando-a);
        Tesoura ganha ao papel (cortando-o);
        Papel ganha à pedra (embrulhando-a).
     */
    public static int resultado(Sinal j1, Sinal j2) {
        final int MIN = Sinal.values()[0].getValor();
        final int MAX = Sinal.values()[Sinal.values().length - 1].getValor();
        int res = j1.getValor() - j2.getValor();
        if (Math.abs(res) == MAX - MIN)
            res *= -1;
        return res;
    }
}

