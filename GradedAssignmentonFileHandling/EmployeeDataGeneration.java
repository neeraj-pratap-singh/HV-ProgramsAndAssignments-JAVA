package GradedAssignmentonFileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private double salary;

    public Employee(int employeeId, String employeeName, String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
                ", Name: " + employeeName +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}

public class EmployeeDataGeneration {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        String outputFilePath = "output.csv";

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Task 1: Data Generation
                        employees = generateEmployeeData();
                        break;
                    case 2:
                        // Task 5: Bonus Challenge - Sort employees based on salary in ascending order
                        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));

                        // Task 2: CSV File Writing
                        writeEmployeeDataToCSV(employees, outputFilePath, scanner);
                        System.out.println("Employee data has been written to 'output.csv'.");
                        break;
                    case 3:
                        // Task 3: CSV File Verification
                        readAndVerifyCSVFile(outputFilePath);
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } catch (IOException e) {
            System.err.println("An error occurred while performing file I/O: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static List<Employee> generateEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Neeraj", "HR", 50000.0));
        employees.add(new Employee(102, "Ajay", "Finance", 60000.0));
        employees.add(new Employee(103, "Sohail", "IT", 55000.0));
        employees.add(new Employee(104, "Sunita", "Marketing", 52000.0));
        employees.add(new Employee(105, "Minakshee", "Operations", 48000.0));
        return employees;
    }

    public static void writeEmployeeDataToCSV(List<Employee> employees, String filePath, Scanner scanner) throws IOException {
        File outputFile = new File(filePath);
        if (outputFile.exists()) {
            System.out.print("The file 'output.csv' already exists. Do you want to overwrite it? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("File not overwritten. Returning to the menu.");
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header row
            writer.write("Employee ID,Employee Name,Department,Salary");
            writer.newLine();

            // Write employee data rows
            for (Employee employee : employees) {
                writer.write(employee.getEmployeeId() + ","
                        + employee.getEmployeeName() + ","
                        + employee.getDepartment() + ","
                        + employee.getSalary());
                writer.newLine();
            }
        }
    }

    public static void readAndVerifyCSVFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nContents of 'output.csv':");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Generate new employee data");
        System.out.println("2. Write data to file (and sort)");
        System.out.println("3. Verify data from file");
        System.out.println("4. Exit");
    }
}
