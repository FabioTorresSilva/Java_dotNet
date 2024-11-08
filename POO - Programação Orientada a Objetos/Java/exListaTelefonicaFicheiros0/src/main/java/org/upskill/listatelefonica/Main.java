package org.upskill.listatelefonica;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        ListaTelefonica listaTelefonica = new ListaTelefonica();

        FicheiroListaTelefonica ficheiroListaTelefonica = new FicheiroListaTelefonica();

        listaTelefonica.prePreencherLista();

        // ficheiro binário por omissão
        if (ficheiroListaTelefonica.serializar(listaTelefonica))
            System.out.printf("Ficheiro binário criado%n");
        else
            System.out.printf("Falha na criação do ficheiro binário%n");

        ListaTelefonica l1 = ficheiroListaTelefonica.desserializar();

        if (!l1.isVazia())
            System.out.printf("Desserialização com sucesso.%nLista telefónica: %n%s%n", l1);
        else
            System.out.printf("Falha na desserialização da lista telefónica%n");


        // ficheiro binário recebido por parâmetro
        if (ficheiroListaTelefonica.serializar("listatelefonicaBin.bin", listaTelefonica))
            System.out.printf("Ficheiro binário criado%n");
        else
            System.out.printf("Falha na criação do ficheiro binário%n");

        l1 = ficheiroListaTelefonica.desserializar("listatelefonicaBin.bin");

        if (!l1.isVazia())
            System.out.printf("Desserialização com sucesso.%nLista telefónica: %n%s%n", l1);
        else
            System.out.printf("Falha na desserialização da lista telefónica%n");

        //
        // gravar ListaTelefonica num ficheiro de texto por omissão

        if (ficheiroListaTelefonica.exportarTexto(listaTelefonica))
            System.out.printf("Ficheiro de texto criado%n");
        else
            System.out.printf("Falha na crição do ficheiro de texto%n");

        // gravar ListaTelefonica num ficheiro recebido por parâmetro

        if (ficheiroListaTelefonica.exportarTexto("listatelefonicaTexto.txt", listaTelefonica))
            System.out.printf("Ficheiro de texto criado%n");
        else
            System.out.printf("Falha na crição do ficheiro de texto%n");

        // carregar ListaTelefonica de um ficheiro de texto por omissão

        l1 = ficheiroListaTelefonica.importarTexto();

        if (!l1.isVazia())
            System.out.printf("Importação do ficheiro de texto com sucesso.%nLista telefónica: %n%s%n", l1);
        else
            System.out.printf("Falaha na importação do ficheiro de texto %n");


        // carregar ListaTelefonica de um ficheiro de texto recebido por parâmetro

        l1 = ficheiroListaTelefonica.importarTexto("listatelefonicaTexto.txt");

        if (!l1.isVazia())
            System.out.printf("Importação do ficheiro de texto com sucesso.%nLista telefónica: %n%s%n", l1);
        else
            System.out.printf("Falaha na importação do ficheiro de texto %n");

    }

}

