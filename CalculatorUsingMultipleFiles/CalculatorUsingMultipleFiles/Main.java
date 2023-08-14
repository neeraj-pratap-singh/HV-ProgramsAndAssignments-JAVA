package CalculatorUsingMultipleFiles;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        double a = 10;
        double b = 5;

        System.out.println("Addition: " + calculator.add(a, b));
        System.out.println("Subtraction: " + calculator.subtract(a, b));
        System.out.println("Multiplication: " + calculator.multiply(a, b));
        System.out.println("Division: " + calculator.divide(a, b));
        System.out.println("Power: " + calculator.power(a, b));
        System.out.println("Square Root: " + calculator.squareRoot(a));
    }
}
