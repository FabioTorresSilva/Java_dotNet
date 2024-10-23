import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner ler = new Scanner(System.in);
        int numeroCidades = 0;
        int numeroProdutosCidade = 0;

        do {
            System.out.printf("Numero de produtos por cidade?\n");
            numeroProdutosCidade = ler.nextInt();

        } while (numeroProdutosCidade < 1 );

        /*
        produtos.txt parece com:
            PRODUTO1,Porto,150,50,100, Lisboa,75,90,200, Coimbra,70,90,50
            PRODUTO2,Porto,70,80,50, Lisboa,90,80,40,Braga,50,40,110, Coimbra,90,30,40
        */
        /*
            maiorQuant.txt
            PRODUTO1,Porto:150,Lisboa:200,Coimbra:90
            PRODUTO2,Porto:80,Lisboa:90,Braga:110,Coimbra:90
        */

        //guarda em array de dois elementos
        Scanner in = new Scanner(new File("produtos.txt"));
        String[] guardaProds = new String[numeroProdutosCidade];
        int nEle = 0;
        while (in.hasNextLine() && nEle < numeroProdutosCidade) {
            guardaProds[nEle] = in.nextLine();
            nEle++;
        }

        Formatter output=new Formatter(new File("maiorQuant.txt"));
        //percorremos o array de 2 elementos
        for(int i = 0; i < guardaProds.length; i++){
            String [] auxProdutos = guardaProds[i].split(",");
            String nomeProduto = auxProdutos[0];
            String [] nomesCidades = new String[numeroCidades];
            String [] numeroProdutosCidade = new String[numeroCidade*3];
            //FORMAT AQUI
            int guardaValorProduto = 0;
            for (int j = 1; j < auxProdutos.length; j++){
                if(auxProdutos[j].toUpperCase().equals(auxProdutos[j])){
                    if(guardaValorProduto < Integer.parseInt(auxProdutos[j])){
                        guardaValorProduto = Integer.parseInt(auxProdutos[j]);
                    }
                } else {
                    
                }
            }
        }





        in.close();

    }
}

