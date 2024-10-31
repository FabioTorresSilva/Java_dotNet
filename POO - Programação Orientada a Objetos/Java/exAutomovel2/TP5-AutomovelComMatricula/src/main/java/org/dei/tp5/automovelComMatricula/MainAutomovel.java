
package org.dei.tp5.automovelComMatricula;

import org.dei.biblioteca.Data;
import org.dei.biblioteca.Pessoa;

public class MainAutomovel {

    public static void main(String[] args) {
        Data d1 = new Data(2015, 4, 4);
        Matricula m1 = new Matricula("11-11-AA", d1);
        System.out.printf("%s %s%n", d1, m1);
        d1.setData(2016,4,4);
        System.out.printf("%s %s%n", d1, m1);

        Pessoa p1 = new Pessoa("Jorge", 1234567);
        System.out.println("\n#### Listagem da Pessoa ####");
        System.out.println(p1);

        Automovel a1 = new Automovel("KIA",m1, p1);
        System.out.println(a1);

        p1.setNome("Jorge Paixão");
        System.out.println("\n#### Atualização do proprietário ####");
        System.out.println(p1);
        System.out.println(a1);


    }
}