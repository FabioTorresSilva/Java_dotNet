package pt.org.upskill.ui.console;

public class AboutUI implements Runnable {

    public AboutUI() {}

    public void run() {
        System.out.println("\nAbout\n-----");
        System.out.println("Version 1.0");
        System.out.println("Developed by <student name>");
        System.out.println("Copyright © 2024 UPskill");
    }
}