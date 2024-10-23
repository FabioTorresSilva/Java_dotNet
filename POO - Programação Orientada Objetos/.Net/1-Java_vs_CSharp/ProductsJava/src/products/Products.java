package products;

import java.util.Scanner;

/**
 *
 * @author upskill
 */
public class Products {

    private static final int MAX_PRODUCTS = 5;
    private static final String LINE = "--------------------------------------";

    /**
     * Insert a new product into an array of products, provided that there is
     * available space.
     *
     * @param products An array of Product objects in which to insert the new
     * product.
     */
    private static void insertProduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();

        System.out.print("Enter Product Name: ");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();

        System.out.print("Enter Category (a single character): ");
        char category = scanner.next().charAt(0);

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Weight: ");
        float weight = scanner.nextFloat();

        System.out.print("Is it In Stock (true/false): ");
        boolean inStock = scanner.nextBoolean();

        products[Product.getProductCounter()] = new Product(productId, name, category, price, weight, inStock);
    }

    /**
     * Retrieve and display product information from an array of products.
     *
     * @param products An array of Product objects from which to retrieve
     * information.
     */
    private static void getProduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);

        Product productToView = null;

        System.out.print("Enter the Product ID to view details: ");
        int productId = scanner.nextInt();

        for (int i = 0; i < Product.getProductCounter(); i++) {
            if (products[i].getProductId() == productId) {
                productToView = products[i];
                break;
            }
        }

//        for (Product product : products) {
//            if (product != null && product.productId == productId) {
//                productToView = product;
//                break;
//            }
//        }

        if (productToView != null) {
            Product.printProductInfo(productToView);
        } else {
            System.out.println("Product not found.");
        }
    }

    /**
     * Main method for managing products and interacting with the user.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = new Product[MAX_PRODUCTS];
        int choice;

        do {
            System.out.println(LINE);
            System.out.println("Select an option:");
            System.out.println("1. Add a new product");
            System.out.println("2. View product details");
            System.out.println("3. Exit");
            System.out.println(LINE);

            System.out.println("Introduza uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (Product.getProductCounter() < products.length) {
                        insertProduct(products);
                    } else {
                        System.out.println("The product list is full.");
                    }
                    break;
                case 2:
                    if (Product.getProductCounter() != 0) {
                        getProduct(products);
                    } else {
                        System.out.println("The product list is empty.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the product management system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 3);
    }

}
