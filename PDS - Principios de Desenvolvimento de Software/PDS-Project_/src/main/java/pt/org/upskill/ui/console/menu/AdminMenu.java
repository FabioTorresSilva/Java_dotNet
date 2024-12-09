package pt.org.upskill.ui.console.menu;

import pt.org.upskill.ui.console.*;
import pt.org.upskill.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class AdminMenu implements Runnable {

    public AdminMenu() {}

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Task", new CreateTaskUI()));
        options.add(new MenuItem("Create Store", new CreateStoreUI()));
        options.add(new MenuItem("Create Employee", new CreateEmployeeUI()));
        options.add(new MenuItem("List all Agents", new ListAgentsUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- ADMIN MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}