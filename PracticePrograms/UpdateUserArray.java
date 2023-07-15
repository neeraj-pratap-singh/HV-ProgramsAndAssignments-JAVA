import java.util.Scanner;

public class UpdateUserArray {
    public static void main(String[] args) {
        String[] userNames = {"Neeraj", "Ayush", "Sunita", "Ajay", "Sohail"};
        int[] userIDs = {101, 102, 103, 104, 105};

        // Print the initial array
        System.out.println("Initial User Array:");
        printUserArray(userNames, userIDs);

        // Get new names from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new names:");

        for (int i = 0; i < userNames.length; i++) {
            System.out.print("User " + (i + 1) + ": ");
            String newName = scanner.nextLine();
            userNames[i] = newName;
        }

        // Print the updated array
        System.out.println("\nUpdated User Array:");
        printUserArray(userNames, userIDs);

        scanner.close();
    }

    // Helper method to print the user array
    private static void printUserArray(String[] names, int[] ids) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("User " + (i + 1) + ": Name - " + names[i] + ", ID - " + ids[i]);
        }
    }
}
