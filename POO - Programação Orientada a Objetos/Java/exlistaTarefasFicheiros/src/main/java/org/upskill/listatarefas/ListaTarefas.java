package org.upskill.listatarefas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefas implements Serializable {

    private List<Tarefa> tarefas;

    public ListaTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (tarefa != null) {
            tarefas.add(tarefa);
        }
    }

    public boolean isVazia() {
        return tarefas.isEmpty();
    }

    public boolean removerTarefa(Tarefa tarefa) {
        return tarefas.remove(tarefa);
    }

    public List<Tarefa> getListaTarefas() {
        return new ArrayList<>(tarefas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tarefa tarefa : tarefas) {
            sb.append(tarefa).append("\n");
        }
        return sb.toString();
    }
}
