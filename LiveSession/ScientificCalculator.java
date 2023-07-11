package LiveSession;

import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Logarithm");
            System.out.println("8. Sine");
            System.out.println("9. Cosine");
            System.out.println("10. Tangent");
            System.out.println("11. Scientific Notation");
            System.out.println("12. Binary Calculation");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition(scanner);
                    break;
                case 2:
                    performSubtraction(scanner);
                    break;
                case 3:
                    performMultiplication(scanner);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 5:
                    performSquareRoot(scanner);
                    break;
                case 6:
                    performPower(scanner);
                    break;
                case 7:
                    performLogarithm(scanner);
                    break;
                case 8:
                    performSine(scanner);
                    break;
                case 9:
                    performCosine(scanner);
                    break;
                case 10:
                    performTangent(scanner);
                    break;
                case 11:
                    performScientificNotation(scanner);
                    break;
                case 12:
                    performBinaryCalculation(scanner);
                    break;
                case 13:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 13);

        scanner.close();
    }

    private static void performAddition(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = num1 + num2;
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + result);
    }

    private static void performSubtraction(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = num1 - num2;
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + result);
    }

    private static void performMultiplication(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = num1 * num2;
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + result);
    }

    private static void performDivision(Scanner scanner) {
        System.out.print("Enter the dividend: ");
        double dividend = scanner.nextDouble();

        System.out.print("Enter the divisor: ");
        double divisor = scanner.nextDouble();

        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed");
        } else {
            double result = dividend / divisor;
            System.out.println("Division: " + dividend + " / " + divisor + " = " + result);
        }
    }

    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter the number: ");
        double number = scanner.nextDouble();

        if (number < 0) {
            System.out.println("Error: Square root of a negative number is not defined");
        } else {
            double result = Math.sqrt(number);
            System.out.println("Square Root: √" + number + " = " + result);
        }
    }

    private static void performPower(Scanner scanner) {
        System.out.print("Enter the base: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the exponent: ");
        double exponent = scanner.nextDouble();

        double result = Math.pow(base, exponent);
        System.out.println("Power: " + base + " ^ " + exponent + " = " + result);
    }

    private static void performLogarithm(Scanner scanner) {
        System.out.print("Enter the number: ");
        double number = scanner.nextDouble();

        if (number <= 0) {
            System.out.println("Error: Logarithm of a non-positive number is not defined");
        } else {
            double result = Math.log10(number);
            System.out.println("Logarithm (base 10): log(" + number + ") = " + result);
        }
    }

    private static void performSine(Scanner scanner) {
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        double radians = Math.toRadians(angle);
        double result = Math.sin(radians);
        System.out.println("Sine: sin(" + angle + "°) = " + result);
    }

    private static void performCosine(Scanner scanner) {
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        double radians = Math.toRadians(angle);
        double result = Math.cos(radians);
        System.out.println("Cosine: cos(" + angle + "°) = " + result);
    }

    private static void performTangent(Scanner scanner) {
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        double radians = Math.toRadians(angle);
        double result = Math.tan(radians);
        System.out.println("Tangent: tan(" + angle + "°) = " + result);
    }

    private static void performScientificNotation(Scanner scanner) {
        System.out.print("Enter the number: ");
        double number = scanner.nextDouble();

        System.out.print("Enter the number of decimal places for scientific notation: ");
        int decimalPlaces = scanner.nextInt();

        String result = String.format("%." + decimalPlaces + "e", number);
        System.out.println("Scientific Notation: " + number + " = " + result);
    }

    private static void performBinaryCalculation(Scanner scanner) {
        System.out.print("Enter the first binary number: ");
        String binary1 = scanner.next();

        System.out.print("Enter the second binary number: ");
        String binary2 = scanner.next();

        int decimal1 = Integer.parseInt(binary1, 2);
        int decimal2 = Integer.parseInt(binary2, 2);

        System.out.println("Decimal representation of " + binary1 + " = " + decimal1);
        System.out.println("Decimal representation of " + binary2 + " = " + decimal2);

        int sumDecimal = decimal1 + decimal2;
        String sumBinary = Integer.toBinaryString(sumDecimal);

        System.out.println("Sum in decimal: " + decimal1 + " + " + decimal2 + " = " + sumDecimal);
        System.out.println("Sum in binary: " + binary1 + " + " + binary2 + " = " + sumBinary);
    }
}
