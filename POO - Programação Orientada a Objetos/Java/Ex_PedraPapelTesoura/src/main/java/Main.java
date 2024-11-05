import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
        final int VITORIAS = 3;
        Sinal jogador, computador;
        int resultado;

        boolean fimJogo = false;
        int resultados[] = new int[2];

        while (!fimJogo) {
            jogador = Util.jogada();
            computador = Util.jogadaAleatoria();
            resultado = Sinal.resultado(jogador, computador);
            Util.atualizaResultados(resultados, resultado);
            System.out.println("Jogador" + " " + jogador.name() + " " + resultados[0]);
            System.out.println("Computador" + " " + computador.name() + " " + resultados[1]);
            if ((resultados[0] == VITORIAS) || (resultados[1] == VITORIAS)) {
                fimJogo = true;
            }
        }
        if (resultados[0] > resultados[1]) {
            System.out.println("Parabéns! Ganhou ao computador!");
        } else {
            System.out.println("Não foi desta! Tente outra vez!");
        }
    }
}

