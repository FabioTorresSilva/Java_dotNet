package exposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Quadro q1 = new Quadro("Ribeira", "Montes", 2000);
        Quadro q2 = new Quadro("Bíblia", "Abel", 1987);
        Quadro q3 = new Quadro("Ponte", "Veloso", 2012);
        Quadro q4 = new Quadro("Rua", "Lopes", 2007);
        Quadro q5 = new Quadro("Arvore", "Pereira", 2010);
        Quadro q6 = new Quadro("Estádio", "Luzia", 2012);
        Quadro q7 = new Quadro("Astros", "Nico", 2011);

        List<Quadro> listaQuadros = new ArrayList<>();
        listaQuadros.add(q1);
        listaQuadros.add(q2);
        listaQuadros.add(q3);
        listaQuadros.add(q4);
        listaQuadros.add(q5);
        listaQuadros.add(q6);
        listaQuadros.add(q7);

        System.out.println("\n#### Listagem de Quadros ####");
        listar(listaQuadros);

        Exposicao expo1 = new Exposicao("Mix 1", 2014, listaQuadros);
        Exposicao expo2 = new Exposicao("Mix 2", 2017);
        expo2.adicionarQuadro(q4);
        expo2.adicionarQuadro(q5);

        List<Exposicao> listaExpo = new ArrayList<>();
        listaExpo.add(expo1);
        listaExpo.add(expo2);

        System.out.println("\n#### Listagem de Exposições ####");
        listar(listaExpo);

        System.out.println("\n#### Atualizar Autor de Quadro Comum ####");
        q4.setAutor("António Lopes");
        listar(listaExpo);

        System.out.println("\n#### Listagem Ordenada de Exposições ####");
        Collections.sort(listaExpo, Collections.reverseOrder());
        listar(listaExpo);

        System.out.println("\n#### Remover um Quadro de uma Exposição ####");
        System.out.println("\nQuadro a remover:\n" + q2);
        if (expo1.removerQuadro(q2)) {
            System.out.println("\nQuadro removido\n");
            listar(expo1.getListaQuadros());
        } else {
            System.out.println("\nQuadro não removido!!");
        }

        System.out.println("\nQuadro a remover:\n" + q2);
        if (expo1.removerQuadro(q2)) {
            System.out.println("\nQuadro removido\n");
            listar(expo1.getListaQuadros());
        } else {
            System.out.println("\nQuadro não removido!!");
        }
    }

    private static void listar(List lista) {
        for (Object obj : lista) {
            System.out.printf("%s\n",obj);
        }
    }
}