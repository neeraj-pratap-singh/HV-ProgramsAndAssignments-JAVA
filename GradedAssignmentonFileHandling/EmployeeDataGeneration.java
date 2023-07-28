package GradedAssignmentonFileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        // Create an ArrayList to store employee information
        List<Employee> employees = new ArrayList<>();

        // Generate data for five employees and add them to the ArrayList
        employees.add(new Employee(101, "Neeraj", "HR", 50000.0));
        employees.add(new Employee(102, "Ajay", "Finance", 60000.0));
        employees.add(new Employee(103, "Sohail", "IT", 55000.0));
        employees.add(new Employee(104, "Sunita", "Marketing", 52000.0));
        employees.add(new Employee(105, "Minakshee", "Operations", 48000.0));

        // Print the employee information
        System.out.println("Employee Information:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Task 2: Write employee information to a CSV file
        String outputFilePath = "output.csv";
        writeEmployeeDataToCSV(employees, outputFilePath);

        System.out.println("Employee data has been written to 'output.csv'.");
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
}

