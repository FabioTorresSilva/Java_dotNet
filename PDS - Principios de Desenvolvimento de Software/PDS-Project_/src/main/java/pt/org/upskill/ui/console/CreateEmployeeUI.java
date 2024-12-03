package pt.org.upskill.ui.console;

import pt.org.upskill.controller.CreateEmployeeController;
import pt.org.upskill.controller.CreateStoreController;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Store;

import java.util.List;
import java.util.Scanner;

public class CreateEmployeeUI implements Runnable {
    private final CreateEmployeeController controller;
    private String email;
    private Store selectedStore;

    public CreateEmployeeUI() {
        controller = new CreateEmployeeController();
    }

    private CreateEmployeeController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Create Employee ------------------------");
        selectedStore = displayAndSelectStore();
        if (selectedStore != null) {
            requestData();
            submitData();
        } else {
            System.out.println("Operation canceled: No store selected.");
        }
    }

    private void submitData() {
        Employee employee = getController().createEmployee(email);

        if (employee != null) {
            System.out.println("\nEmployee successfully created!");
        } else {
            System.out.println("\nEmployee not created!");
        }
    }

    private void requestData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        email = input.nextLine();
    }

    private Store displayAndSelectStore() {
        CreateStoreController storeController = new CreateStoreController();

        // Fetch the list of stores
        List<Store> stores = storeController.getStores();

        if (stores == null || stores.isEmpty()) {
            System.out.println("No stores available!");
            return null;
        }

        System.out.println("\nAvailable Stores:");
        for (int i = 0; i < stores.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, stores.get(i).getCode());
        }

        Scanner input = new Scanner(System.in);
        int answer = -1;

        while (answer < 1 || answer > stores.size()) {
            System.out.print("Select a store (1-" + stores.size() + "): ");
            if (input.hasNextInt()) {
                answer = input.nextInt();
            } else {
                input.next(); // Clear invalid input
                System.out.println("Please enter a valid number.");
            }
        }

        return stores.get(answer - 1); // Return the selected Store object
    }
}
