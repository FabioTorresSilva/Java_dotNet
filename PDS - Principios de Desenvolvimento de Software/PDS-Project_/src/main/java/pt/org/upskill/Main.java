package pt.org.upskill;

import pt.org.upskill.ui.console.menu.MainMenu;

public class Main {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            MainMenu menu = new MainMenu();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}