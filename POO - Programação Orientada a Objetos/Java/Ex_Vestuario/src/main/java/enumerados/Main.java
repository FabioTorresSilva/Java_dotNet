package enumerados;

import enumerados.Vestuario.Tamanho;

public class Main {

    public static void main(String args[]){

        Vestuario v1 = new Vestuario(25,"T-Shirt",Tamanho.S);
        Vestuario v2 = new Vestuario(33,"camisola",Tamanho.M);
        Vestuario v3 = new Vestuario(33,"calça",Tamanho.Xl);

        System.out.printf("1. Listar informação das peças de vestuário\n");
        System.out.printf("%s\n", v1);
        System.out.printf("%s\n", v2);
        System.out.printf("%s\n\n", v3);

        System.out.printf("2. Posição correspondente à ordem da constante %s: %d\n\n",v1.getTamanho(), v1.getTamanho().ordinal());

        System.out.printf("3. Tamanho do vestuário v2 em formato de string equivalente à sua forma literal: %s\n\n",v2.getTamanho().name());

        System.out.printf("4. Converte o argumento que é passado por parâmetro para a constante respetiva em Tamanho e apresenta-a: %s\n\n",Tamanho.valueOf("Xl"));

        // Mais exemplos de utilização de enumarados
        System.out.printf("5. Listar todos os enumerados\n");
        for(Tamanho t : Tamanho.values()){
            System.out.printf("Designação do tamanho da posição %d: %s\n", t.ordinal(),t);
        }
    }
}
