// WAP in Java to print asterisks (*) in the Triangle pattern 2
public class TrianglePattern2 {
    public static void main(String[] args) {
        int n = 5; // Number of rows for the pattern

        // Print upper part of the pattern
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Print lower part of the pattern
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
