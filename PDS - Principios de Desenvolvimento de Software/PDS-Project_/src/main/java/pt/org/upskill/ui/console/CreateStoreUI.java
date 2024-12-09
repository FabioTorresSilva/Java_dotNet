package pt.org.upskill.ui.console;

import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.controller.CreateStoreController;
import pt.org.upskill.controller.CreateTaskController;
import pt.org.upskill.domain.Store;
import pt.org.upskill.domain.Task;
import pt.org.upskill.domain.TaskCategory;
import java.util.List;
import java.util.Scanner;

public class CreateStoreUI implements Runnable {
    private final CreateStoreController controller;
    private String openingTime;
    private String closingTime;
    private String designation;
    private String address;


    public CreateStoreUI() {
        controller = new CreateStoreController();
    }

    private CreateStoreController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Create Store ------------------------");
        requestData();
        submitData();
    }

    private void submitData() {
        StoreDTO store = getController().createStore(openingTime,closingTime, designation, address);

        if (store != null) {
            System.out.println("\nStore successfully created!");
        } else {
            System.out.println("\nStore not created!");
        }
    }

    private void requestData() {
        openingTime = requestOpeningTime();
        closingTime = requestClosingTime();
    }

    private String requestOpeningTime(){
        Scanner input = new Scanner(System.in);
        System.out.println("Opening Hour");
        int hour = input.nextInt();
        System.out.println("Opening minutes");
        int minutes = input.nextInt();
        return hour + "hours" + "and" + minutes + "minutes";
    }
    private String requestClosingTime(){
        Scanner input = new Scanner(System.in);
        System.out.println("Closing Hour");
        int hour = input.nextInt();
        System.out.println("Closing minutes");
        int minutes = input.nextInt();
        return hour + "hours" + "and" + minutes + "minutes";
    }
}