package pt.org.upskill.ui.console.menu;

import pt.org.upskill.ui.console.AboutUI;
import pt.org.upskill.ui.console.authorization.AuthenticationUI;
import pt.org.upskill.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Runnable {

    public MainMenu() {}

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Login", new AuthenticationUI()));
        options.add(new MenuItem("About", new AboutUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- MAIN MENU --------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
    }
}