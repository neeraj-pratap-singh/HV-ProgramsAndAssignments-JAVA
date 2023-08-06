package LiveSession;

public class Calculator {
    // Method to perform addition
    public static int addition(int a, int b) {
        return a + b;
    }

    // Method to perform subtraction
    public static int subtraction(int a, int b) {
        return a - b;
    }

    // Method to perform multiplication
    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        // Test the Calculator methods
        int num1 = 10;
        int num2 = 5;

        int sum = addition(num1, num2);
        int difference = subtraction(num1, num2);
        int product = multiplication(num1, num2);

        System.out.println("Addition: " + num1 + " + " + num2 + " = " + sum);
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + difference);
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + product);
    }
}
