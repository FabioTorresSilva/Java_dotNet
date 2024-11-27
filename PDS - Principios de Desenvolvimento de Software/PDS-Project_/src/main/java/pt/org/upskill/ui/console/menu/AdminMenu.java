package pt.org.upskill.ui.console.menu;

import pt.org.upskill.ui.console.CreateTaskUI;
import pt.org.upskill.ui.console.ShowTextUI;
import pt.org.upskill.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class AdminMenu implements Runnable {

    public AdminMenu() {}

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Task", new CreateTaskUI()));
        options.add(new MenuItem("Option 2", new ShowTextUI("You have chosen Option 2.")));
        options.add(new MenuItem("Option 3", new ShowTextUI("You have chosen Option 3.")));
        options.add(new MenuItem("Option 4", new ShowTextUI("You have chosen Option 4.")));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- ADMIN MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}