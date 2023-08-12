import java.util.*;
import java.io.*;

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.print("Name: " + name + " | Price: Rs." + price + " | Quantity: " + quantity);
    }

    public double calculateValue() {
        return price * quantity;
    }

    public void sell(int quantitySold) {
        if (this.quantity < quantitySold) {
            System.out.println("Insufficient quantity. Cannot sell the requested amount.");
            return;
        }
        this.quantity -= quantitySold;
    }

    public void applyDiscount(double discountPercentage) {
        this.price -= this.price * discountPercentage / 100;
    }

    public static void compareProducts(Product p1, Product p2) {
        if (p1.price > p2.price) {
            System.out.println(p1.name + " is more expensive than " + p2.name);
        } else if (p1.price < p2.price) {
            System.out.println(p1.name + " is cheaper than " + p2.name);
        } else {
            System.out.println(p1.name + " has the same price as " + p2.name);
        }

        if (p1.quantity > p2.quantity) {
            System.out.println(p1.name + " has more quantity in stock than " + p2.name);
        } else if (p1.quantity < p2.quantity) {
            System.out.println(p1.name + " has less quantity in stock than " + p2.name);
        } else {
            System.out.println(p1.name + " has the same quantity in stock as " + p2.name);
        }
    }
}

class Electronics extends Product {
    String brand;

    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" | Brand: " + brand);
    }
}

class Clothing extends Product {
    String size;

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" | Size: " + size);
    }
}

class Books extends Product {
    String author;

    public Books(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(" | Author: " + author);
    }
}

class InventoryManagement {
    List<Product> inventory;

    public InventoryManagement() {
        this.inventory = new ArrayList<>();
    }

    public void loadInventory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);

                switch (type) {
                    case "Electronics":
                        String brand = parts[4];
                        inventory.add(new Electronics(name, price, quantity, brand));
                        break;
                    case "Clothing":
                        String size = parts[4];
                        inventory.add(new Clothing(name, price, quantity, size));
                        break;
                    case "Books":
                        String author = parts[4];
                        inventory.add(new Books(name, price, quantity, author));
                        break;
                }
            }
            System.out.println("Inventory loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Starting with an empty inventory.");
        } catch (IOException e) {
            System.out.println("Error reading file! Starting with an empty inventory.");
            e.printStackTrace();
        }
    }

    public void saveInventory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product product : inventory) {
                String type = "";
                String extraField = "";

                if (product instanceof Electronics) {
                    type = "Electronics";
                    extraField = ((Electronics) product).brand;
                } else if (product instanceof Clothing) {
                    type = "Clothing";
                    extraField = ((Clothing) product).size;
                } else if (product instanceof Books) {
                    type = "Books";
                    extraField = ((Books) product).author;
                }

                writer.println(type + "," + product.name + "," + product.price + "," + product.quantity + "," + extraField);
            }
            System.out.println("Inventory saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving inventory!");
            e.printStackTrace();
        }
    }


    public double getValidDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) return value;
            }
            scanner.nextLine(); // Clear invalid input
            System.out.println("Invalid input. Please enter a positive number.");
        }
    }

    public int getValidIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) return value;
            }
            scanner.nextLine(); // Clear invalid input
            System.out.println("Invalid input. Please enter a positive integer.");
        }
    }

    public String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine(); // Read the entire line, including whitespace
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void displayInventory() {
        System.out.println("***** Inventory *****");
        for (Product product : inventory) {
            product.display();
            System.out.println("********************");
        }
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        for (Product product : inventory) {
            totalValue += product.calculateValue();
        }
        return totalValue;
    }

    public void sellProduct(String name, int quantitySold) {
        for (Product product : inventory) {
            if (product.name.equals(name)) {
                product.sell(quantitySold);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void searchByName(String name) {
        for (Product product : inventory) {
            if (product.name.equalsIgnoreCase(name)) {
                product.display();
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void applyDiscount(String name, double discountPercentage) {
        for (Product product : inventory) {
            if (product.name.equals(name)) {
                product.applyDiscount(discountPercentage);
                return;
            }
        }
        System.out.println("Product not found!");
    }
}

public class InventoryStoreManagementSystem {
    public static void main(String[] args) {
        String filename = "./inventorystoreProject/inventory.csv";
        InventoryManagement inventoryManagement = new InventoryManagement();

        // Load inventory from CSV file
        inventoryManagement.loadInventory(filename);

        while (true) {
            System.out.println("\n***** Inventory Store Management System *****\n");
            System.out.println("1. Add Electronics product");
            System.out.println("2. Add Clothing product");
            System.out.println("3. Add Books product");
            System.out.println("4. Display inventory");
            System.out.println("5. Sell product");
            System.out.println("6. Search by name");
            System.out.println("7. Apply discount");
            System.out.println("8. Compare two products");
            System.out.println("9. Calculate total inventory value");
            System.out.println("10. Exit");
            int option = inventoryManagement.getValidIntInput("Select an option: ");
            switch (option) {
                case 1:
                    String elecName = inventoryManagement.getStringInput("Enter name: ");
                    double elecPrice = inventoryManagement.getValidDoubleInput("Enter price: Rs.");
                    int elecQuantity = inventoryManagement.getValidIntInput("Enter quantity: ");
                    String brand = inventoryManagement.getStringInput("Enter brand: ");
                    Product elecProduct = new Electronics(elecName, elecPrice, elecQuantity, brand);
                    inventoryManagement.addProduct(elecProduct);
                    System.out.println("Electronics product added successfully!");
                    inventoryManagement.saveInventory(filename); // Save immediately
                    break;
                case 2:
                    String clothName = inventoryManagement.getStringInput("Enter name: ");
                    double clothPrice = inventoryManagement.getValidDoubleInput("Enter price: Rs.");
                    int clothQuantity = inventoryManagement.getValidIntInput("Enter quantity: ");
                    String size = inventoryManagement.getStringInput("Enter size: ");
                    Product clothProduct = new Clothing(clothName, clothPrice, clothQuantity, size);
                    inventoryManagement.addProduct(clothProduct);
                    System.out.println("Clothing product added successfully!");
                    inventoryManagement.saveInventory(filename); // Save immediately
                    break;
                case 3:
                    String bookName = inventoryManagement.getStringInput("Enter name: ");
                    double bookPrice = inventoryManagement.getValidDoubleInput("Enter price: Rs.");
                    int bookQuantity = inventoryManagement.getValidIntInput("Enter quantity: ");
                    String author = inventoryManagement.getStringInput("Enter author name: ");
                    Product bookProduct = new Books(bookName, bookPrice, bookQuantity, author);
                    inventoryManagement.addProduct(bookProduct);
                    System.out.println("Book product added successfully!");
                    inventoryManagement.saveInventory(filename); // Save immediately
                    break;
                case 4:
                    inventoryManagement.displayInventory();
                    break;
                case 5:
                    String productNameToSell = inventoryManagement.getStringInput("Enter product name to sell: ");
                    int quantityToSell = inventoryManagement.getValidIntInput("Enter quantity to sell: ");
                    inventoryManagement.sellProduct(productNameToSell, quantityToSell);
                    inventoryManagement.saveInventory(filename); // Save immediately
                    break;
                case 6:
                    String searchName = inventoryManagement.getStringInput("Enter product name to search: ");
                    inventoryManagement.searchByName(searchName);
                    break;
                case 7:
                    String discountName = inventoryManagement.getStringInput("Enter product name to apply discount: ");
                    double discountPercentage = inventoryManagement.getValidDoubleInput("Enter discount percentage: ");
                    inventoryManagement.applyDiscount(discountName, discountPercentage);
                    inventoryManagement.saveInventory(filename); // Save immediately
                    break;
                case 8:
                    String name1 = inventoryManagement.getStringInput("Enter first product name to compare: ");
                    String name2 = inventoryManagement.getStringInput("Enter second product name to compare: ");
                    Product p1 = null, p2 = null;
                    for (Product product : inventoryManagement.inventory) {
                        if (product.name.equalsIgnoreCase(name1)) p1 = product;
                        if (product.name.equalsIgnoreCase(name2)) p2 = product;
                    }
                    if (p1 != null && p2 != null) {
                        Product.compareProducts(p1, p2);
                    } else {
                        System.out.println("Both products must exist in inventory to compare.");
                    }
                    break;
                case 9:
                    System.out.println("Total inventory value: Rs." + inventoryManagement.calculateTotalValue());
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
