public class NumberPattern {
    public static void main(String[] args) {
        int rows = 5;

        for (int i = rows; i >= 1; i--) {
            // Print spaces
            for (int space = 1; space <= rows - i; space++) {
                System.out.print(" ");
            }
            // Print numbers in descending order
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            // Print asterisk (*)
            System.out.print("*");
            // Print numbers in ascending order
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}
