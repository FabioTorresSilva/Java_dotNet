package org.upskill.listatarefas;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class FicheiroListaTarefas {

    public static final String NOME_FICHEIRO_SERIALIZAR = "ListaTarefas.ltf";
    public static final String NOME_FICHEIRO_TEXTO = "ListaTarefas.txt";

    public FicheiroListaTarefas() {
    }

    public boolean serializar(ListaTarefas listaTarefas) {
        return serializar(NOME_FICHEIRO_SERIALIZAR, listaTarefas);
    }

    public boolean serializar(String nomeFicheiro, ListaTarefas listaTarefas) {
        return serializar(new File(nomeFicheiro), listaTarefas);
    }

    public boolean serializar(File ficheiro, ListaTarefas listaTarefas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ficheiro))) {
            out.writeObject(listaTarefas);
            return true;
        } catch (IOException ex) {
            System.err.println("Erro ao serializar: " + ex.getMessage());
            return false;
        }
    }

    public ListaTarefas desserializar() {
        return desserializar(NOME_FICHEIRO_SERIALIZAR);
    }

    public ListaTarefas desserializar(String nomeFicheiro) {
        return desserializar(new File(nomeFicheiro));
    }

    public ListaTarefas desserializar(File ficheiro) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ficheiro))) {
            return (ListaTarefas) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Erro ao desserializar: " + ex.getMessage());
            return new ListaTarefas();
        }
    }

    public boolean exportarTexto(ListaTarefas listaTarefas) {
        return exportarTexto(NOME_FICHEIRO_TEXTO, listaTarefas);
    }

    public boolean exportarTexto(String nomeFich, ListaTarefas listaTarefas) {
        return exportarTexto(new File(nomeFich), listaTarefas);
    }

    public boolean exportarTexto(File ficheiro, ListaTarefas listaTarefas) {
        try (PrintWriter out = new PrintWriter(ficheiro)) {
            List<Tarefa> lista = listaTarefas.getListaTarefas();
            for (int i = 0; i < lista.size(); i++) {
                Tarefa tarefa = lista.get(i);
                out.printf("%s - %s - %s%n", tarefa.getDescricao(), tarefa.getPrioridade(), tarefa.getInstante());
            }
            return true;
        } catch (IOException ex) {
            System.err.println("Erro ao exportar para texto: " + ex.getMessage());
            return false;
        }
    }

    public ListaTarefas importarTexto() {
        return importarTexto(new File(NOME_FICHEIRO_TEXTO));
    }

    public ListaTarefas importarTexto(String nomeFicheiro) {
        return importarTexto(new File(nomeFicheiro));
    }

    public ListaTarefas importarTexto(File ficheiro) {
        ListaTarefas listaTarefas = new ListaTarefas();

        try (Scanner in = new Scanner(ficheiro)) {
            while (in.hasNextLine()) {
                String linha = in.nextLine();
                String[] partes = linha.split(" - ");
                if (partes.length == 3) {
                    String descricao = partes[0];
                    String prioridadeStr = partes[1].trim().replaceAll(" ", "_").toUpperCase();
                    Prioridade prioridade = Prioridade.valueOf(prioridadeStr);
                    LocalDateTime instante = LocalDateTime.parse(partes[2]);

                    Tarefa tarefa = new Tarefa(descricao, prioridade);
                    listaTarefas.adicionarTarefa(tarefa);
                }
            }
            return listaTarefas;
        } catch (IOException | IllegalArgumentException ex) {
            System.err.println("Erro ao importar de texto: " + ex.getMessage());
            return new ListaTarefas();
        }
    }
}
