import java.util.*;

public class Util {
    public static Scanner ler = new Scanner(System.in);

    public static Sinal jogada() {
        int opcao;
        String msg = criaMensagem();
        boolean opcaoValida = false;
        do {
            System.out.println(msg);
            opcao = ler.nextInt();
            opcaoValida = jogadaValida(opcao);
            if (!opcaoValida)
                System.out.println("Opção inválida!");
        } while (!opcaoValida);
        return Sinal.values()[verIndice(opcao)];
    }

//    public static String criaMensagem() {
//        String msg = "Digite a sua escolha (";
//        for (Sinal s : Sinal.values()) {
//            msg += s.getValor() + " / ";
//        }
//        msg = msg.substring(0, msg.length() - 3);
//        msg += ")\n";
//        for (Sinal s : Sinal.values()) {
//            msg += s.getValor() + "-" + s.name() + "\n";
//        }
//        return msg;
//    }

    public static String criaMensagem() {

        StringBuilder str = new StringBuilder("Digite a sua escolha (");
        for (Sinal s : Sinal.values()) {
            str.append(s.getValor());
            str.append(" / ");
        }
        str= new StringBuilder(str.substring(0, str.length() - 3));
        str.append(")\n");
        for (Sinal s : Sinal.values()) {
            str.append(s.getValor() + "-" + s.name() + "\n");
        }
        return str.toString();
    }

    public static Sinal jogadaAleatoria() {
        Random aleatorio = new Random();
        int res = aleatorio.nextInt(Sinal.values().length);
        return Sinal.values()[res];
    }

    public static int verIndice(int valor) {
        int res = 0;
        for (Sinal s : Sinal.values()) {
            if (valor == s.getValor())
                res = s.ordinal();
        }
        return res;
    }

    public static boolean jogadaValida(int jogada) {
        boolean res = false;
        int i = 0;
        for (Sinal s : Sinal.values()) {
            if (jogada == s.getValor())
                res = true;
        }
        return res;
    }

    public static void atualizaResultados(int[] resultados, int resultado) {
        if (resultado > 0) {
            resultados[0]++;
        } else if (resultado < 0) {
            resultados[1]++;
        }
    }

}
