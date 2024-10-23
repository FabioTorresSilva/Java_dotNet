import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Abrir o ficheiro funcionarios.txt
        Scanner input=new Scanner(new File("funcionarios.txt"));

        final int MAX = 20;
        String[] nomes = new String[MAX];
        double[] salarios = new double[MAX];
        int nelems=0;

        //Ler do ficheiro
        while(input.hasNext()) {//verifica se há mais conteúdo a ler
            String str=input.nextLine();
            String []separa= str.split(",");

            nomes[nelems]=separa[0];
            salarios[nelems]= Double.parseDouble(separa[1]);
            nelems++;
        }
        double soma=0;
        for(int i=0; i<nelems;i++) {
            soma += salarios[i];
        }
        System.out.println("Funcionários com vencimento superior à média:");
        boolean existe=false;
        double media=(double)soma/nelems;
        for(int i=0; i<nelems;i++) {
            if (salarios[i]>media){
                System.out.printf("%s\n",nomes[i]);
                existe = true;
            }
        }
        if (existe == false)
            System.out.printf("Não existem funcionários com vencimento superior à média");
        //Fechar ficheiro
        input.close();
    }
}