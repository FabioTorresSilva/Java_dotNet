package ContadoresDomesticos;

import java.util.BitSet;

public class MainContadores {
    public MainContadores() {
    }

    public static void main(String[] args) {
        ContadoresGas g1 = new ContadoresGas("Pedro", 12);
        ContadoresGas g2 = new ContadoresGas("Tiago", 17);
        ContadoresGas g3 = new ContadoresGas("Alexandra", 10);
        ElectSimples e1 = new ElectSimples("Pedro", 1200, 5.7);
        ElectBiH e2 = new ElectBiH("Tiago", 500, 10.0, 1000);
        ElectSimples e3 = new ElectSimples("Alexandra", 1700, 7.8);
        Object[] contador = new Object[10];
        contador[0] = g1;
        contador[1] = g2;
        contador[2] = g3;
        contador[3] = e1;
        contador[4] = e2;
        contador[5] = e3;
        System.out.println("\nContadores:");

        int maiorConsumoGas;
        for (maiorConsumoGas = 0; maiorConsumoGas < contador.length; ++maiorConsumoGas) {
            if (contador[maiorConsumoGas] != null) {
                System.out.println((Contador) contador[maiorConsumoGas]);
            }
        }

        System.out.println("\nTotal de contadores de eletricidade: " + ElectBiH.getNumContadoresElect());
        System.out.println("\nContadores Bi-partidos:");

        for (maiorConsumoGas = 0; maiorConsumoGas < contador.length; ++maiorConsumoGas) {
            if (contador[maiorConsumoGas] instanceof ElectBiH) {
                System.out.println(((Contador) contador[maiorConsumoGas]).getId());
            }
        }

        System.out.println("\nCusto de consumo por contador:");

        for (maiorConsumoGas = 0; maiorConsumoGas < contador.length; ++maiorConsumoGas) {
            if (contador[maiorConsumoGas] != null) {
                System.out.println("ID: " + ((Contador) contador[maiorConsumoGas]).getId() + " Custo: " + ((Contador) contador[maiorConsumoGas]).calcularCusto() + "€.");
            }
        }

        maiorConsumoGas = 0;

        for (int i = 0; i < contador.length; ++i) {
            if (contador[i] instanceof ContadoresGas && ((Contador) contador[i]).getConsumo() > maiorConsumoGas) {
                maiorConsumoGas = ((Contador) contador[i]).getConsumo();
            }
        }

        if (maiorConsumoGas != 0) {
            System.out.println("Maior consumo de gás: " + maiorConsumoGas);
        }


        String[] clientes = new String[10];
        int k = 0;
        int i;
        for (i = 0; i < contador.length; ++i) {
            if (contador[i] != null) {
                boolean guardar = true;

                for (int j = 0; j < k; ++j) {
                    if (clientes[j].equalsIgnoreCase(((Contador) contador[i]).getNome())) {
                        guardar = false;
                    }
                }

                if (guardar) {
                    clientes[k] = ((Contador) contador[i]).getNome();
                    ++k;
                }
            }
        }

        for (i = 0; i < clientes.length; ++i) {
            if (clientes[i] != null) {
                System.out.println(clientes[i]);
            }
        }
    }
}

