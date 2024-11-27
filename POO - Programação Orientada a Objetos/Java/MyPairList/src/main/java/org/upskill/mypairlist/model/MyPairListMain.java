package org.upskill.mypairlist.model;

import java.util.List;

public class MyPairListMain {

    public static void main(String[] args) {
        String[] vStr = {"Anabela", "Alberta", "Ana", "Ana", "Alberta"};
        Integer[] vInt = {1, 2, 1, 4, 2};

        MyPairList<String, Integer> listaPares = new MyPairList<>();
        FicheiroMyPairList ficheiro = new FicheiroMyPairList();

        for (int i = 0; i < vStr.length; i++) {
            listaPares.add(vStr[i], vInt[i]);
        }

        System.out.println("Lista inicial");
        System.out.println(listaPares.toString());

        listaPares.arrange();

        System.out.println("Lista depois de arrange");
        System.out.println(listaPares.toString());

        MyPairList<String, Integer> listaPares2=listaPares.pairsGreaterThan("Ana",2);

        System.out.println("Lista de pares superiores a par composto pelos atributos recebidos por parâmetro");
        System.out.println(listaPares2.toString());

        List listaSegundosAtributos = listaPares.elementsPairedWith("Ana");

        System.out.println("Lista de valores do segundo atributo dos pares em que o valor do primeiro atributo é recebido por parâmetro");
        System.out.println(listaSegundosAtributos.toString());

        System.out.println("Combinações");
        System.out.println(listaPares.allUniqueCombinations().toString());

        ficheiro.serializar(listaPares.allUniqueCombinations());

        MyPairList<String, Integer> listaDesserializada = ficheiro.desserializar();

        System.out.println(listaDesserializada);
    }
}
