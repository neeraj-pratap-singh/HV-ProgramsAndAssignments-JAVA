package Assignment;

import java.util.Scanner;

public class InventoryManagementSystem {
    private static final int MAX_PRODUCTS = 100;
    private static String[] productNames = new String[MAX_PRODUCTS];
    private static double[] productPrices = new double[MAX_PRODUCTS];
    private static int[] productQuantities = new int[MAX_PRODUCTS];
    private static int numProducts = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add a product");
            System.out.println("2. Update product details");
            System.out.println("3. Remove a product");
            System.out.println("4. View all products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    updateProduct(scanner);
                    break;
                case 3:
                    removeProduct(scanner);
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        productNames[numProducts] = name;
        productPrices[numProducts] = price;
        productQuantities[numProducts] = quantity;
        numProducts++;

        System.out.println("Product added successfully.");
    }

    private static void updateProduct(Scanner scanner) {
        System.out.print("Enter the product name to update: ");
        String name = scanner.next();

        int productIndex = findProductIndexByName(name);
        if (productIndex != -1) {
            System.out.println("Enter new product details:");

            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter product quantity: ");
            int quantity = scanner.nextInt();

            productPrices[productIndex] = price;
            productQuantities[productIndex] = quantity;

            System.out.println("Product details updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter the product name to remove: ");
        String name = scanner.next();

        int productIndex = findProductIndexByName(name);
        if (productIndex != -1) {
            for (int i = productIndex; i < numProducts - 1; i++) {
                productNames[i] = productNames[i + 1];
                productPrices[i] = productPrices[i + 1];
                productQuantities[i] = productQuantities[i + 1];
            }
            numProducts--;

            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewAllProducts() {
        if (numProducts == 0) {
            System.out.println("No products available.");
        } else {
            System.out.println("Product\t\tPrice\t\tQuantity");
            for (int i = 0; i < numProducts; i++) {
                System.out.println(productNames[i] + "\t\t" + productPrices[i] + "\t\t" + productQuantities[i]);
            }
        }
    }

    private static int findProductIndexByName(String name) {
        for (int i = 0; i < numProducts; i++) {
            if (productNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1; // Product not found
    }
}
