package GradedAssignmentonFileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        // Task 1: Data Generation
        List<Employee> employees = generateEmployeeData();

        // Print the employee information
        System.out.println("Employee Information:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Task 2: CSV File Writing
        String outputFilePath = "output.csv";
        writeEmployeeDataToCSV(employees, outputFilePath);

        System.out.println("Employee data has been written to 'output.csv'.");

        // Task 3: CSV File Verification
        readAndVerifyCSVFile(outputFilePath);
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

    public static void writeEmployeeDataToCSV(List<Employee> employees, String filePath) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndVerifyCSVFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nContents of 'output.csv':");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
