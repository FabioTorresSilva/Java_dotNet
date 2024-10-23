package org.dei.tributaveis2;

public class MainTributaveis {

    public static void main(String[] args) {

        Veiculo v1 = new Veiculo("22-33-CC", 1000, "encarnado");
        System.out.println(v1);
        Veiculo v2 = new Veiculo("44-55-DD", 2500, Cores.AZUL);
        System.out.println(v2);
        Veiculo v3 = new Veiculo("11-22-BB", 1400, Veiculo.VERDE);
        System.out.println(v3);

        Moradia m1 = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        System.out.println(m1);

        Cores c = v1;
        c = m1;

        Tributavel[] tributaveis = new Tributavel[4];
        tributaveis[0] = v1;
        tributaveis[1] = v2;
        tributaveis[2] = v3;
        tributaveis[3] = m1;

        double total = 0;
        for (int i = 0; i < tributaveis.length; i++) {
            if (tributaveis[i] != null) {
                total += tributaveis[i].calcularImposto();
            }
        }
        System.out.printf("%n### Total do imposto é %.2f€%n", total);

        System.out.println("\nParâmetro do Tipo Interface");
        mostrarImposto(v3);
        mostrarImposto(m1);
    }

    public static void mostrarImposto(Tributavel tributavel){
        System.out.println(tributavel.toString()
                + ": Imposto: " + tributavel.calcularImposto() + " euros");
    }

}

