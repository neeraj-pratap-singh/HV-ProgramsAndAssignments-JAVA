// WAP in Java displays the substring when the starting index and ending index is given.
import java.util.Scanner;

public class SubstringExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String stringName = scanner.nextLine();

        System.out.print("Enter the starting index: ");
        int startIndex = scanner.nextInt();

        System.out.print("Enter the ending index: ");
        int endIndex = scanner.nextInt();

        // Extract the substring
        String substring = stringName.substring(startIndex, endIndex + 1);

        // Print the result
        System.out.println("Substring of " + stringName + " from " + startIndex + " to " + endIndex + " is: " + substring);

        scanner.close();
    }
}
