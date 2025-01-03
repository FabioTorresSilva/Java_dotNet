package org.upskill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Quadro> quadroList = new ArrayList<>();
        List<Exposicao> expoList = new ArrayList<>();
        List<Quadro> quadroList2 = new ArrayList<>();

        Quadro q1 = new Quadro("aaa", "Luis", 121);
        Quadro q2 = new Quadro("ddddd", "Ana", 121);
        Quadro q3 = new Quadro("bbbbb", "Jose", 121);
        Quadro q4 = new Quadro("ddddd", "Carlos", 121);
        Quadro q5 = new Quadro("eeeee", "Miguel", 121);
        Quadro q6 = new Quadro("hhhhh", "Zeza", 121);
        Quadro q7 = new Quadro("ffff", "Julio", 121);

        quadroList.add(q1);
        quadroList.add(q2);
        quadroList.add(q3);
        quadroList.add(q4);
        quadroList.add(q5);
        quadroList2.add(q6);
        quadroList2.add(q7);

        Exposicao exposicao1 = new Exposicao("1", 2121, quadroList);
        Exposicao exposicao2 = new Exposicao("2", 3245, quadroList2);
        Exposicao exposicao3 = new Exposicao("3", 67647, quadroList);
        Exposicao exposicao4 = new Exposicao("4", 21343, quadroList2);

        expoList.add(exposicao1);
        expoList.add(exposicao2);
        expoList.add(exposicao3);
        expoList.add(exposicao4);


        listar(exposicao1.getQuadros());

        q1.setAnoCriacao(31231);
        q2.setAnoCriacao(423432);
        q3.setAnoCriacao(42423423);

        listar(exposicao1.getQuadros());

        Collections.sort(expoList, Collections.reverseOrder());
        listar(expoList);

        System.out.println("Exposicao menos 1 quadro");
        exposicao2.removerQuadro(q6);
        listar(expoList);
    }

    public static void listar(List e){
        for(Object ee: e){
            System.out.println(ee.toString());
        }
    }
}