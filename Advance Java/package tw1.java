import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "ID: " + id + " Name: " + name + " Price: " + price + " Quantity: " + quantity;
    }
}

public class TW1 {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Update Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewAllProducts();
                case 3 -> searchProductByName();
                case 4 -> updateProduct();
                case 5 -> removeProduct();
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        inventory.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully.");
    }

    private static void viewAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\nAvailable Products:");
        for (Product product : inventory) {
            System.out.println(product.toString());
        }
    }

    private static void searchProductByName() {
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Product product : inventory) {
            if (product.getId() == id) {
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                scanner.nextLine();

                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private static void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Product product : inventory) {
            if (product.getId() == id) {
                inventory.remove(product);
                System.out.println("Product removed successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
}