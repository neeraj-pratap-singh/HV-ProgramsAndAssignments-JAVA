import java.util.Scanner;

public class SwapValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value for numA: ");
        int numA = scanner.nextInt();

        System.out.print("Enter the value for numB: ");
        int numB = scanner.nextInt();

        System.out.println("Before swapping:");
        System.out.println("numA = " + numA);
        System.out.println("numB = " + numB);

        // Swap the values
        int temp = numA;
        numA = numB;
        numB = temp;

        System.out.println("\nAfter swapping:");
        System.out.println("numA = " + numA);
        System.out.println("numB = " + numB);

        scanner.close();
    }
}
