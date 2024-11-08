package org.upskill;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Filme> lf = new ArrayList<>();

        Data d1 = new Data(1934, 5, 5);
        Data d2 = new Data(1956, 3, 22);
        Data d3 = new Data(1922, 12, 14);
        Data d4 = new Data(1946, 1, 11);
        Data d5 = new Data(1860, 8, 2);

        Realizador r1 = new Realizador("Christopher Nolan", "British", d1);
        Realizador r2 = new Realizador("Quentin Tarantino", "American", d2);
        Realizador r3 = new Realizador("Hayao Miyazaki", "Japanese", d3);
        Realizador r4 = new Realizador("Sofia Coppola", "American", d4);
        Realizador r5 = new Realizador("Alejandro Gonzalez Inarritu", "Mexican", d5);

        try {
            Filme f1 = new Filme("Inception", 2010, r1, "drama");
            lf.add(f1);
            Filme f2 = new Filme("Pulp Fiction", 1994, r2, "ação");
            lf.add(f2);
            Filme f3 = new Filme("Spirited Away", 2001, r3, "terror");
            lf.add(f3);
            Filme f4 = new Filme("Lost in Translation", 2003, r4, "comédia");
            lf.add(f4);
            Filme f5 = new Filme("Birdman", 2014, r5, "animação");
            lf.add(f5);

            //Teste data filme
            Filme f6 = new Filme("TesteAno", 2000, r5, "animação");
            lf.add(f6);

            //Teste categoria
            Filme f7 = new Filme("TesteCategoria", 1956, r5, "filme de rir");
            lf.add(f7);

        } catch (CategoriaInvalidaException | AnoInvalidoException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<ListaFilmes> listaDeListas = new ArrayList<>();

        try {
            listaDeListas.add(new ListaFilmes("Taa5", lf));
            listaDeListas.add(new ListaFilmes("Cfff4",lf));
            listaDeListas.add(new ListaFilmes("333B",lf));
        } catch (IdentificadorInvalidoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---- LISTA ----");
        for (ListaFilmes i : listaDeListas)
            if (i != null)
                System.out.println(i);
    }
}
