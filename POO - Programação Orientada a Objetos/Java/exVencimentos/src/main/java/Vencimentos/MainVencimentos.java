package Vencimentos;

public class MainVencimentos {

    public static void main(String[] args) {

        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 53, 62);
        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira", 650.0f, 2731.5f, 4.25f);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 168, 4.5f);

        Trabalhador[] trabs = new Trabalhador[10];
//        Object[] trabs = new Object[10];
        trabs[0] = tp;
        trabs[1] = tc;
        trabs[2] = th;

        System.out.println("### Trabalhadores ###");
        for (int i = 0; i < trabs.length; i++) {
            if (trabs[i] != null) {
                System.out.println(trabs[i].toString());
                System.out.println();
            }
        }

        System.out.println("\n### Trabalhadores à Hora ###");
        for (int i = 0; i < trabs.length; i++) {
            if (trabs[i] != null && trabs[i].getClass().getSimpleName().equalsIgnoreCase("TrabalhadorHora")) {
//            if (trabs[i] instanceof TrabalhadorHora) {
                System.out.println(trabs[i].toString());
                System.out.println();
            }
        }

//        System.out.println("\n### Vencimentos ###");
//        for (int i = 0; i < trabs.length; i++) {
//            if (trabs[i] != null) {
//                System.out.println(((Trabalhador) trabs[i]).getNome() + " --- "
//                        + ((Trabalhador) trabs[i]).calcularVencimento() + " €");
//            }
//        }
        System.out.println("\n### Vencimentos ###");
        for (int i = 0; i < trabs.length; i++) {
            if (trabs[i] != null) {
//                System.out.println(trabs[i].getNome() + " --- " + trabs[i].calcularVencimento() + " €");
                System.out.printf("%s %.2f €", trabs[i].getNome(),trabs[i].calcularVencimento());
            }
        }

    }
}
