package org.dei.tributaveis;

public class MainTributaveis {

    public static void main(String[] args) {
        Veiculo veiculo1 = new Veiculo("22-33-CC", 1000, "vermelho");
        System.out.println(veiculo1);
        Veiculo veiculo2 = new Veiculo("44-55-DD", 2500, Cores.AZUL);
        System.out.println(veiculo2);
        Veiculo veiculo3 = new Veiculo("11-22-BB", 1400, Veiculo.VERDE);
        System.out.println(veiculo3 + "\n");


        Moradia moradia1 = new Moradia("Rua do Bocage", 90, "cinzenta");
        System.out.println(moradia1);
        Moradia moradia2 = new Moradia("Rua do Bocage", 90, Cores.CINZENTO);
        System.out.println(moradia2);
        Moradia moradia3 = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        System.out.println(moradia3 + "\n");


        //var CORES É CAPAZ DE ARMAZENAR QUALQUER var DO TIPO MORADIA E VEICULO
        Cores referencia;
        referencia = veiculo1;
        System.out.println(referencia);
        referencia = moradia1;
        System.out.println(referencia + "\n");


        System.out.println(veiculo3.getImposto());


        Imposto[] Tributaveis = new Imposto[6];

        Tributaveis[0] = moradia1;
        Tributaveis[1] = moradia2;
        Tributaveis[2] = moradia3;
        Tributaveis[3] = veiculo1;
        Tributaveis[4] = veiculo2;
        Tributaveis[5] = veiculo3;

        double accImposto = 0;
        for (int i = 0; i < Tributaveis.length; i++) {
            accImposto += Tributaveis[i].getImposto();
        }
        System.out.println(accImposto);
    }
    public static void mostrarImposto(Tributavel ){
        System.out.println(Imposto.mostr);
    }
}
