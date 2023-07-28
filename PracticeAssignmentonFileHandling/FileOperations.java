package PracticeAssignmentonFileHandling;

import java.io.*;
// import java.nio.file.*;
import java.util.*;

public class FileOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\nMenu based app - File Operations in Java\n");
            System.out.println("1. Create a new folder");
            System.out.println("2. Create a new text file");
            System.out.println("3. Write into a text file");
            System.out.println("4. Append data to a text file");
            System.out.println("5. Rename a file");
            System.out.println("6. Delete a File");

            System.out.print("\nPlease enter the Menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (menu) {
                case 1:
                    System.out.println("\nCreate a new folder");
                    createFolder(scanner);
                    break;
                case 2:
                    System.out.println("\nCreate a new text file");
                    createFile(scanner);
                    break;
                case 3:
                    System.out.println("\nWrite into a text file");
                    writeToFile(scanner, false);
                    break;
                case 4:
                    System.out.println("\nAppend data to a text file");
                    writeToFile(scanner, true);
                    break;
                case 5:
                    System.out.println("\nRename a file");
                    renameFile(scanner);
                    break;
                case 6:
                    System.out.println("\nDelete a file");
                    deleteFile(scanner);
                    break;
            }

            System.out.print("\nPress 'Y' to go back to the Main File-Operations Menu: ");
            choice = scanner.nextLine().toUpperCase();

        } while (choice.equals("Y"));
        scanner.close();
    }

    private static void createFolder(Scanner scanner) {
        System.out.print("Please enter the Path where you wish to save a new folder: ");
        String path = scanner.nextLine();
        System.out.print("Please enter the Folder-name to be Created: ");
        String name = scanner.nextLine();

        File dir = new File(path + "/" + name);
        if (dir.mkdir()) {
            System.out.println("Folder is created successfully!");
        } else {
            System.out.println("Failed to create folder!");
        }
    }

    private static void createFile(Scanner scanner) {
        System.out.print("Please enter the Path where you wish to create a new file: ");
        String path = scanner.nextLine();
        System.out.print("Please enter the File-name to be Created: ");
        String name = scanner.nextLine();

        File file = new File(path + "/" + name + ".txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File is created successfully!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void writeToFile(Scanner scanner, boolean append) {
        System.out.print("Please enter the Path of the text file: ");
        String path = scanner.nextLine();
        System.out.print("Please enter the File-name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the text to be written into the file: ");
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(path + "/" + name + ".txt", append)) {
            writer.write(text);
            System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void renameFile(Scanner scanner) {
        System.out.print("Please enter the Path of the file to be renamed: ");
        String path = scanner.nextLine();
        System.out.print("Please enter the current File-name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the new File-name: ");
        String newName = scanner.nextLine();

        File file = new File(path + "/" + name + ".txt");
        File newFile = new File(path + "/" + newName + ".txt");

        if (file.renameTo(newFile)) {
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("Failed to rename file!");
        }
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("Please enter the Path of the file to be deleted: ");
        String path = scanner.nextLine();
        System.out.print("Please enter the File-name to be deleted: ");
        String name = scanner.nextLine();

        File file = new File(path + "/" + name + ".txt");
        if (file.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("Failed to delete file!");
        }
    }
}
