import java.util.*;

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
        Scanner scanner = new Scanner(System.in);
        InventoryManagement inventoryManagement = new InventoryManagement();

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
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    String elecName = inventoryManagement.getStringInput("Enter name: ");
                    double elecPrice = inventoryManagement.getValidDoubleInput("Enter price: Rs.");
                    int elecQuantity = inventoryManagement.getValidIntInput("Enter quantity: ");
                    String brand = inventoryManagement.getStringInput("Enter brand: ");
                    Product elecProduct = new Electronics(elecName, elecPrice, elecQuantity, brand);
                    inventoryManagement.addProduct(elecProduct);
                    System.out.println("Electronics product added successfully!");
                    break;
                case 2:
                    String clothName = inventoryManagement.getStringInput("Enter name: ");
                    double clothPrice = inventoryManagement.getValidDoubleInput("Enter price: Rs.");
                    int clothQuantity = inventoryManagement.getValidIntInput("Enter quantity: ");
                    String size = inventoryManagement.getStringInput("Enter size: ");
                    Product clothProduct = new Clothing(clothName, clothPrice, clothQuantity, size);
                    inventoryManagement.addProduct(clothProduct);
                    System.out.println("Clothing product added successfully!");
                    break;
                case 3:
                    String bookName = inventoryManagement.getStringInput("Enter name: ");
                    double bookPrice = inventoryManagement.getValidDoubleInput("Enter price: Rs.");
                    int bookQuantity = inventoryManagement.getValidIntInput("Enter quantity: ");
                    String author = inventoryManagement.getStringInput("Enter author name: ");
                    Product bookProduct = new Books(bookName, bookPrice, bookQuantity, author);
                    inventoryManagement.addProduct(bookProduct);
                    System.out.println("Book product added successfully!");
                    break;
                case 4:
                    inventoryManagement.displayInventory();
                    break;
                case 5:
                    System.out.print("Enter product name to sell: ");
                    String productNameToSell = scanner.next();
                    System.out.print("Enter quantity to sell: ");
                    int quantityToSell = scanner.nextInt();
                    inventoryManagement.sellProduct(productNameToSell, quantityToSell);
                    break;
                case 6:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.next();
                    inventoryManagement.searchByName(searchName);
                    break;
                case 7:
                    System.out.print("Enter product name to apply discount: ");
                    String discountName = scanner.next();
                    System.out.print("Enter discount percentage: ");
                    double discountPercentage = scanner.nextDouble();
                    inventoryManagement.applyDiscount(discountName, discountPercentage);
                    break;
                case 8:
                    System.out.print("Enter first product name to compare: ");
                    String name1 = scanner.next();
                    System.out.print("Enter second product name to compare: ");
                    String name2 = scanner.next();
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
