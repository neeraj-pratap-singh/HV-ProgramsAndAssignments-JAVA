package PracticeAssignmentonFileHandling;

import java.io.*;
import java.util.Scanner;

public class FileOperationsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\nMenu based app - File Operations in Java\n");
            System.out.println("1. Create a new folder");
            System.out.println("2. Create a new text file");
            System.out.println("3. Write into a text file");
            System.out.println("4. Append data to a text file");
            System.out.println("5. Rename a file");
            System.out.println("6. Delete a file");
            System.out.print("\nPlease enter the Menu: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (menuChoice) {
                case 1:
                    createFolder();
                    break;
                case 2:
                    createTextFile();
                    break;
                case 3:
                    writeToFile();
                    break;
                case 4:
                    appendToFile();
                    break;
                case 5:
                    renameFile();
                    break;
                case 6:
                    deleteFile();
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }

            System.out.print("\nPress 'Y' to go back to the Main File-Operations Menu: ");
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume the newline character
        } while (Character.toLowerCase(choice) == 'y');

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void createFolder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the Folder-name to be Created: ");
        String folderName = scanner.nextLine();

        File folder = new File(folderName);
        if (folder.mkdir()) {
            System.out.println("Folder is created Successfully!");
        } else {
            System.out.println("Failed to create the folder. Please check the folder name and try again.");
        }
    }

    private static void createTextFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the Folder-name to create the Text File: ");
        String folderName = scanner.nextLine();

        System.out.print("Please enter the File-Name to be Created: ");
        String fileName = scanner.nextLine();

        try {
            File folder = new File(folderName);
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File(folder, fileName);
            if (file.createNewFile()) {
                System.out.println("File is created Successfully!");
            } else {
                System.out.println("Failed to create the file. Please check the file name and try again.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    private static void writeToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the Folder-name of the Text File: ");
        String folderName = scanner.nextLine();

        System.out.print("Please enter the File-Name to Write into: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(new File(folderName, fileName))) {
            System.out.print("Please enter the content to write: ");
            String content = scanner.nextLine();
            writer.write(content);
            System.out.println("Data is written to the file Successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static void appendToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the Folder-name of the Text File: ");
        String folderName = scanner.nextLine();

        System.out.print("Please enter the File-Name to Append Data: ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter(new File(folderName, fileName), true)) {
            System.out.print("Please enter the content to append: ");
            String content = scanner.nextLine();
            writer.write("\n" + content);
            System.out.println("Data is appended to the file Successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file: " + e.getMessage());
        }
    }

    private static void renameFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the Folder-name of the File to be Renamed: ");
        String folderName = scanner.nextLine();

        System.out.print("Please enter the File-Name to be Renamed: ");
        String oldFileName = scanner.nextLine();

        System.out.print("Please enter the new File-Name: ");
        String newFileName = scanner.nextLine();

        File oldFile = new File(folderName, oldFileName);
        File newFile = new File(folderName, newFileName);

        if (oldFile.renameTo(newFile)) {
            System.out.println("File is renamed Successfully!");
        } else {
            System.out.println("Failed to rename the file. Please check the file names and try again.");
        }
    }

    private static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the Folder-name of the File to be Deleted: ");
        String folderName = scanner.nextLine();

        System.out.print("Please enter the File-Name to be Deleted: ");
        String fileName = scanner.nextLine();

        File file = new File(folderName, fileName);
        if (file.delete()) {
            System.out.println("File is deleted Successfully!");
        } else {
            System.out.println("Failed to delete the file. Please check the file name and try again.");
        }
    }
}
