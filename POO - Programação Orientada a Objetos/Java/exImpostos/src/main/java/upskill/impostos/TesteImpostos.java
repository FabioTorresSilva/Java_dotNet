
package upskill.impostos;

public class TesteImpostos {

public static void main(String[] args) {

        System.out.println("## TesteImpostos ##");

        Reformado r = new Reformado("Jose Santos", "Porto", 1000.00f, 500.00f);
        TrabalhadorContaOutrem tco = new TrabalhadorContaOutrem("João Santos", "Lisboa", 800.00f, 100.00f, "CML");
        TrabalhadorContaPropria tcp = new TrabalhadorContaPropria("Carla Santos", "Porto", 1500.00f, 1000.00f, "Advogado");
        Desempregado d = new Desempregado("Manuel Santos", "Braga", 150.00f, 4);

        Contribuinte[] contrib = new Contribuinte[10];

        contrib[0] = r;
        contrib[1] = tco;
        contrib[2] = tcp;
        contrib[3] = d;

        System.out.println("###Listagem de impostos a pagar pelos contribuintes:");
        for (int i = 0; i < contrib.length; i++) {
            if (contrib[i] != null) {
                System.out.println(contrib[i] + "\n...tem a pagar "
                        + contrib[i].calcularImposto()
                        + " € de imposto\n");
            }
        }

        System.out.println("\n###Listagem de desempregados:");
        for (int i = 0; i < contrib.length; i++) {
            if (contrib[i] instanceof Desempregado) {
                System.out.println(contrib[i].getNome() + "\n...tem a pagar "
                        + contrib[i].calcularImposto()
                        + " € de imposto\n");
            }
        }
        
        Desempregado.setTaxaOutrosRendimentos(0.5f);
        
        System.out.println("\n###Listagem de desempregados (nova taxa de outros rendimentos):");
        for (int i = 0; i < contrib.length; i++) {
            if (contrib[i] instanceof Desempregado) {
                System.out.println(contrib[i].getNome()  + "\n...tem a pagar "
                        + contrib[i].calcularImposto()
                        + " € de imposto\n");
            }
        }
    }    
}
