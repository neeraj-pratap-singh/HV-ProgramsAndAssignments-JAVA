// WAP in Java to print asterisks (*) in the Triangle pattern 1
public class TrianglePattern {
    public static void main(String[] args) {
        int n = 3; // Number of rows for the triangle
        int spaces = n - 1; // Number of spaces before the first asterisk

        // Print upper part of the triangle
        for (int i = 0; i < n; i++) {
            // Print spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            System.out.println();
            spaces--;
        }

        spaces = 1; // Reset spaces for the lower part of the triangle

        // Print lower part of the triangle
        for (int i = n - 1; i > 0; i--) {
            // Print spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // Print asterisks
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
            spaces++;
        }
    }
}
