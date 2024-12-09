package pt.org.upskill.ui.console;

import pt.org.upskill.DTO.AgentDTO;
import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.controller.CreateStoreController;
import pt.org.upskill.controller.CreateTaskController;
import pt.org.upskill.controller.ListAgentsController;
import pt.org.upskill.domain.Task;
import pt.org.upskill.domain.TaskCategory;

import java.util.List;
import java.util.Scanner;

public class ListAgentsUI implements Runnable {
    private final ListAgentsController controller;

    public ListAgentsUI() {
        controller = new ListAgentsController();
    }

    private ListAgentsController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- List Agents ----------");
        displayAgents();
    }

    private void displayAgents() {
        List<AgentDTO> agents = controller.getAgents();

        if (agents == null || agents.isEmpty()) {
            System.out.println("No agents available!");
            return;
        }

        System.out.println("\nAgents:");

        for (AgentDTO agent : agents) {
            System.out.printf("Name: %s, Email: %s\n", agent.getName(), agent.getEmail());
        }
    }

}