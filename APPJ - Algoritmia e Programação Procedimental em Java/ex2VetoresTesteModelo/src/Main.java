public class Main {
    public static void main(String[] args) {


    }

    public static double mediaImparesVetor(double[] vetor) {
        int contaImpares = 0;
        double auxMedia = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            if (vetor[i] % 2 != 0) {
                contaImpares++;
                auxMedia += vetor[i];

            }
        }
        double media = auxMedia / contaImpares;
        return media;
    }

    public static void maiorPercentagem(double[][] matriz) {
        int inferior = 100;
        int superior = 600;

        //linha
        for(int i = 0; i < matriz.length; i++){
            //coluna
            for (int j = 0 ; j < matriz[i].length; j++){
                if()
            }
        }
    }
}