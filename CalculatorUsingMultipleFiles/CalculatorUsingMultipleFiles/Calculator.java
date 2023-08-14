package CalculatorUsingMultipleFiles;

public class Calculator extends BasicOperations {
    private final AdvancedOperations advancedOperations;

    public Calculator() {
        advancedOperations = new AdvancedOperations();
    }

    public double power(double base, double exponent) {
        return advancedOperations.power(base, exponent);
    }

    public double squareRoot(double number) {
        return advancedOperations.squareRoot(number);
    }
}
