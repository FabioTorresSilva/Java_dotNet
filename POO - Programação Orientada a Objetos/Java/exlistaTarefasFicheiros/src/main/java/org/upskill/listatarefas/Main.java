package org.upskill.listatarefas;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 1", Prioridade.ACIMA_DO_NORMAL));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 2", Prioridade.ABAIXO_DO_NORMAL));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 3", Prioridade.BAIXA));

        FicheiroListaTarefas ficheiroListaTarefas = new FicheiroListaTarefas();

        if (ficheiroListaTarefas.serializar(listaTarefas)) {
            System.out.printf("Ficheiro binário criado com sucesso.%n");
        } else {
            System.out.printf("Falha na criação do ficheiro binário.%n");
        }

        ListaTarefas tarefasImportadasBinario = ficheiroListaTarefas.desserializar();
        if (tarefasImportadasBinario != null && !tarefasImportadasBinario.getListaTarefas().isEmpty()) {
            System.out.printf("Importação do ficheiro binário com sucesso.%nLista de tarefas importadas: %n%s%n", tarefasImportadasBinario);
        } else {
            System.out.printf("Falha na importação do ficheiro binário.%n");
        }

        if (ficheiroListaTarefas.exportarTexto(listaTarefas)) {
            System.out.printf("Ficheiro de texto criado com sucesso.%n");
        } else {
            System.out.printf("Falha na criação do ficheiro de texto.%n");
        }

        ListaTarefas tarefasImportadasTexto = ficheiroListaTarefas.importarTexto();
        if (tarefasImportadasTexto != null && !tarefasImportadasTexto.getListaTarefas().isEmpty()) {
            System.out.printf("Importação do ficheiro de texto com sucesso.%nLista de tarefas importadas: %n%s%n", tarefasImportadasTexto);
        } else {
            System.out.printf("Falha na importação do ficheiro de texto.%n");
        }
    }
}