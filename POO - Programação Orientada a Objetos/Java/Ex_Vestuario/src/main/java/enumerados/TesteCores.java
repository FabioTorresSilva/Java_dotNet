package enumerados;

public class TesteCores {

    public enum Cores {
        BRANCO {
            @Override
            public String toString() {
                return "Branco";
            }
        },
        AMARELO {
            @Override
            public String toString() {
                return "Amarelo";
            }
        },
        AZUL {
            @Override
            public String toString() {
                return "Azul";
            }
        },
        VERMELHO {
            @Override
            public String toString() {
                return "Vermelho";
            }
        },
        VERDE {
            @Override
            public String toString() {
                return "Verde";
            }
        },
        PRETO {
            @Override
            public String toString() {
                return "Preto";
            }
        };
    }

    public static void main(String args[]){

        Cores cor = Cores.AZUL;
        System.out.printf("Ordem= %d\n",cor.ordinal());
        System.out.printf("Nome da constante= %s\n",cor.name());
        System.out.printf("toString()= %s\n",cor.toString());
        System.out.printf("Cor Verde= %s\n",Cores.valueOf("VERDE"));
        System.out.printf("Posição da cor Verde no enumerado= %d\n",Cores.valueOf("VERDE").ordinal());
        // Listar todas as cores
        for (Cores c : Cores.values()){
            System.out.printf("Cor: %s\n", c.toString());
        }
    }
}
