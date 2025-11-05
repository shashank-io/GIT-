
import java.io.*;
import java.util.Scanner;
public class TW4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n---Stream operation menu---");
            System.out.println("1. FileStream Operation");
            System.out.println("2. ByteArrayStream Operation");
            System.out.println("3. BufferedStream Operation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> fileStreamOperations(scanner);
                case 2 -> byteArrayStreamOperations(scanner);
                case 3 -> bufferedStreamOperations(scanner);
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void fileStreamOperations(Scanner scanner) {
        System.out.println("\n---FileStream Operations---");
        try (FileOutputStream fos = new FileOutputStream("Fops.txt");
             FileInputStream fis = new FileInputStream("Fops.txt")) {

            System.out.println("Enter text to write to file: ");
            String input = scanner.nextLine();
            fos.write(input.getBytes());
            System.out.println("Data written to file.");

            System.out.println("Reading data from file:");
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void byteArrayStreamOperations(Scanner scanner) {
        System.out.println("\n---ByteArrayStream Operations---");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.out.println("Enter text to write to ByteArrayStream: ");
            String input = scanner.nextLine();
            baos.write(input.getBytes());
            System.out.println("Data written to ByteArrayStream.");

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println("Reading data from ByteArrayStream:");
            int data;
            while ((data = bais.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedStreamOperations(Scanner scanner) {
        System.out.println("\n---BufferedStream Operations---");
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Bops.txt"));
             BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Bops.txt"))) {

            System.out.println("Enter text to write to BufferedStream: ");
            String input = scanner.nextLine();
            bos.write(input.getBytes());
            bos.flush();
            System.out.println("Data written to BufferedStream.");

            System.out.println("Reading data from BufferedStream:");
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
