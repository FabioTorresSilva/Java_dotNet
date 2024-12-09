package pt.org.upskill.ui.console;

import pt.org.upskill.DTO.AgentDTO;
import pt.org.upskill.DTO.StoreDTO;
import pt.org.upskill.controller.CreateAgentController;
import pt.org.upskill.controller.CreateStoreController;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.Store;

import java.util.List;
import java.util.Scanner;

public class CreateAccountUI implements Runnable {


    public CreateAccountUI() {
        controller = new CreateAgentController();
    }

    private CreateAgentController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Create Account ------------------------");

        selectedStore = displayAndSelectStore();
        if (selectedStore != null) {
            requestData();

            submitData();
        } else {
            System.out.println("Operation canceled: No store selected.");
        }
    }

    private void submitData() {
        AgentDTO employee = getController().createEmployee(email, name, phone, position);

        if (employee != null) {
            System.out.println("\nEmployee successfully created!");
        } else {
            System.out.println("\nFailed to create the employee. Please check the provided data.");
        }
    }

    private void requestData() {
        Scanner input = new Scanner(System.in);

        System.out.print("Email: ");
        email = input.nextLine();

        System.out.print("Name: ");
        name = input.nextLine();

        while (true) {
            try {
                System.out.print("Phone: ");
                phone = Integer.parseInt(input.nextLine());
                if (String.valueOf(phone).length() >= 7 && String.valueOf(phone).length() <= 15) {
                    break;
                } else {
                    System.out.println("Phone number must be between 7 to 15 digits.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric phone number.");
            }
        }

        System.out.print("Position: ");
        position = input.nextLine();
    }

    private StoreDTO displayAndSelectStore() {
        CreateStoreController storeController = new CreateStoreController();

        List<StoreDTO> stores = storeController.getStores();

        if (stores == null || stores.isEmpty()) {
            System.out.println("No stores available!");
            return null;
        }

        System.out.println("\nAvailable Stores:");
        for (int i = 0; i < stores.size(); i++) {
            StoreDTO store = stores.get(i);
            System.out.printf("%d. Code: %s, Designation: %s, Address: %s\n",
                    i + 1,
                    store.getCode() != null ? store.getCode() : "N/A",
                    store.getDesignation() != null ? store.getDesignation() : "N/A",
                    store.getAddress() != null ? store.getAddress() : "N/A");
        }

        Scanner input = new Scanner(System.in);
        int answer = -1;

        while (answer < 1 || answer > stores.size()) {
            System.out.print("Select a store (1-" + stores.size() + "): ");
            if (input.hasNextInt()) {
                answer = input.nextInt();
                if (answer < 1 || answer > stores.size()) {
                    System.out.println("Invalid selection. Please choose a number within the range.");
                }
            } else {
                input.next();
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return stores.get(answer - 1); // Return the selected StoreDTO object
    }

}
