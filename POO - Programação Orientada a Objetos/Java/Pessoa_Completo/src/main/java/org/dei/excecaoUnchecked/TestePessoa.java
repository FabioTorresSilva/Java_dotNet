
package org.dei.excecaoUnchecked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestePessoa {

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        Pessoa p = new Pessoa();
        
        boolean dadosInvalidos = true;

        do {
            try {
                System.out.print("Nome:");
                String nome = ler.nextLine();
                p.setNome(nome);

                System.out.print("Nº de ID Civil:");
                int idCivil = ler.nextInt();
                ler.nextLine();
                p.setIDCivil(idCivil);

                dadosInvalidos = false;
                
//             este catch pode ser suprimido porque o catch do IllegalArgument
//             captura e trata da mesma forma.
            } catch (ArgumentoForaDosLimitesException e) {
                System.out.println("\nERRO: " + e.getMessage()
                        + " (" + e.getClass().getSimpleName() + ")");

            } catch (IllegalArgumentException e) {

                System.out.println("\nERRO: " + e.getMessage()
                        + " (" + e.getClass().getSimpleName() + ")");

            } catch (InputMismatchException e) {

                System.out.println("\nERRO: Número de ID Civil inválido !!!"
                        + " (" + e.getClass().getSimpleName() + ")");
                ler.nextLine();

            }
        } while (dadosInvalidos);

    }

}
