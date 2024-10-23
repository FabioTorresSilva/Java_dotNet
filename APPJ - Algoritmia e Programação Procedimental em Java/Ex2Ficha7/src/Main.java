import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner ler= new Scanner(System.in);
        int numeroAlunos = 0;
        do {
            System.out.printf("Numero de alunos Disciplina.\n");
            numeroAlunos = ler.nextInt();
        }while(numeroAlunos<1);

        String [] guardaNomesAlunos= new String[numeroAlunos];
        double [] guardaNotasAlunos= new double[numeroAlunos];
        int contadorNAlunosIntroduzidos = 0;
        ler.nextLine();
        for(int i=0; i < numeroAlunos; i++){
            System.out.printf("Nome Aluno %d? \n", i+1);
            guardaNomesAlunos[i] = ler.nextLine();
            if(guardaNomesAlunos[i].equals("fim")){
                break;
            }
            System.out.printf("Nota Aluno %d? \n", i+1);
            guardaNotasAlunos[i]= ler.nextDouble();
            contadorNAlunosIntroduzidos++;
            ler.nextLine();
        }

        double media = 0;

        for ( int i= 0; i < contadorNAlunosIntroduzidos ;  i++){
            media += guardaNotasAlunos[i];
        }
        media /= contadorNAlunosIntroduzidos;

        Formatter output=new Formatter(new File("Melhores.txt"));
        output.format("Média %.2f %n", media);
        for(int i= 0; i < contadorNAlunosIntroduzidos; i++){
            if(guardaNotasAlunos[i]> media){
                //Coloca nome aluno ":" e nota Aluno
                output.format("%S %s %.2f", guardaNomesAlunos[i].trim(),":", guardaNotasAlunos[i]);
            }
        }
        output.close();
    }
}