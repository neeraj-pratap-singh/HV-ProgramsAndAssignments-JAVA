import java.io.*;
import java.util.*;

public class Employee {
    public static String fileName = "./LiveSESSION/employees.csv";
    public static String header = "Name,Age,Salary,Designation,Gender,Contact Information,Department,Date of Joining,Performance Ratings";
    private String name;
    private int age;
    private double salary;
    private String designation;
    private String gender;
    private String contactInfo;
    private String department;
    private String dateOfJoining;
    private int performanceRating;

    // Constructor
    public Employee(String name, int age, double salary, String designation, String gender,
                    String contactInfo, String department, String dateOfJoining, int performanceRating) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
        this.performanceRating = performanceRating;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add new employee");
            System.out.println("2. Display all employees");
            System.out.println("3. Find employee with highest salary");
            System.out.println("4. Find employee with lowest salary");
            System.out.println("5. Find youngest employee");
            System.out.println("6. Find oldest employee");
            System.out.println("7. Find employees within age range");
            System.out.println("8. Calculate total salary of all employees");
            System.out.println("9. Calculate average age of employees");
            System.out.println("10. Calculate average salary of employees");
            System.out.println("11. Find employees above salary threshold");
            System.out.println("12. Update employee age");
            System.out.println("13. Update employee name");
            System.out.println("14. Remove employee by name");
            System.out.println("15. Remove employee by index");
            System.out.println("16. Sort employees by age");
            System.out.println("17. Sort employees by salary");
            System.out.println("18. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addNewEmployee(fileName, scanner);
                    break;
                case 2:
                    displayAllEmployees(fileName);
                    break;
                case 3:
                    findEmployeeWithHighestSalary(fileName);
                    break;
                case 4:
                    findEmployeeWithLowestSalary(fileName);
                    break;
                case 5:
                    findYoungestEmployee(fileName);
                    break;
                case 6:
                    findOldestEmployee(fileName);
                    break;
                case 7:
                    findEmployeesWithinAgeRange(fileName, scanner);
                    break;
                case 8:
                    calculateTotalSalary(fileName);
                    break;
                case 9:
                    calculateAverageAge(fileName);
                    break;
                case 10:
                    calculateAverageSalary(fileName);
                    break;
                case 11:
                    findEmployeesAboveSalaryThreshold(fileName, scanner);
                    break;
                case 12:
                    updateEmployeeAge(fileName, scanner);
                    break;
                case 13:
                    updateEmployeeName(fileName, scanner);
                    break;
                case 14:
                    removeEmployeeByName(fileName, scanner);
                    break;
                case 15:
                    removeEmployeeByIndex(fileName, scanner);
                    break;
                case 16:
                    sortEmployeesByAge(fileName);
                    break;
                case 17:
                    sortEmployeesBySalary(fileName);
                    break;
                case 18:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }
    }

    // Function Implementations:

    /**
     * Adds a new employee to the CSV file.
     * @param fileName The name of the CSV file.
     * @param scanner Scanner object to read user input.
     */

     public static void addNewEmployee(String fileName, Scanner scanner) {
        System.out.println("\n=== Add New Employee ===");
        // Get employee details from the user
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character after reading double
        System.out.print("Enter Employee Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Employee Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Employee Contact Information: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Employee Date of Joining: ");
        String dateOfJoining = scanner.nextLine();
        System.out.print("Enter Employee Performance Rating: ");
        int performanceRating = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading int

        // Create an Employee object with the collected details
        Employee newEmployee = new Employee(name, age, salary, designation, gender, contactInfo, department, dateOfJoining, performanceRating);

        try {
            // Open the CSV file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            
            // Check if the file is empty, and if so, write the header first
            File file = new File(fileName);
            if (file.length() == 0) {
                writer.write(header);
                writer.newLine();
            }

            // Write the employee details to the CSV file
            writer.write(newEmployee.getName() + "," + newEmployee.getAge() + "," + newEmployee.getSalary() + ","
                    + newEmployee.getDesignation() + "," + newEmployee.getGender() + "," + newEmployee.getContactInfo()
                    + "," + newEmployee.getDepartment() + "," + newEmployee.getDateOfJoining() + ","
                    + newEmployee.getPerformanceRating());
            writer.newLine();

            // Close the writer
            writer.close();

            System.out.println("Employee added successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while adding the employee: " + e.getMessage());
        }
    }

    /**
     * Displays all employees from the CSV file in a tabular manner.
     * @param fileName The name of the CSV file.
     */
    public static void displayAllEmployees(String fileName) {
        System.out.println("\n=== Display All Employees ===");
        try {
            // Open the CSV file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Read the header line and display it
            String line = reader.readLine();
            if (line == null) {
                System.out.println("No employees found in the database.");
                reader.close();
                return;
            }
            System.out.println(formatTableRow(header.split(",")));

            // Read and display each employee's details
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                System.out.println(formatTableRow(employeeData));
            }

            // Close the reader
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        }
    }

    /**
     * Formats a table row using proper spacing for each attribute.
     * @param rowData The array of strings representing the data for a row.
     * @return The formatted table row as a single string.
     */
    private static String formatTableRow(String[] rowData) {
        StringBuilder sb = new StringBuilder();
        for (String data : rowData) {
            // Align each column with a width of 20 characters
            sb.append(String.format("%-20s", data));
        }
        return sb.toString();
    }

    /**
     * Finds and displays the employee with the highest salary from the CSV file.
     * @param fileName The name of the CSV file.
     */
    public static void findEmployeeWithHighestSalary(String fileName) {
        System.out.println("\n=== Find Employee with Highest Salary ===");
        try {
            // Open the CSV file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Read the header line (to skip it)
            reader.readLine();

            // Initialize variables to store the highest salary and the employee with that salary
            double highestSalary = Double.MIN_VALUE;
            String employeeWithHighestSalary = "";

            // Read and compare each employee's salary to find the highest salary
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                double salary = Double.parseDouble(employeeData[2]); // Salary is at index 2 in the CSV file
                if (salary > highestSalary) {
                    highestSalary = salary;
                    employeeWithHighestSalary = employeeData[0]; // Employee name is at index 0 in the CSV file
                }
            }

            // Close the reader
            reader.close();

            if (employeeWithHighestSalary.isEmpty()) {
                System.out.println("No employees found in the database.");
            } else {
                // Display the employee with the highest salary
                System.out.println("Employee with Highest Salary:");
                System.out.println("Name: " + employeeWithHighestSalary);
                System.out.println("Salary: " + highestSalary);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing salary data: " + e.getMessage());
        }
    }

    /**
     * Finds and displays the employee with the lowest salary from the CSV file.
     * @param fileName The name of the CSV file.
     */
    public static void findEmployeeWithLowestSalary(String fileName) {
        System.out.println("\n=== Find Employee with Lowest Salary ===");
        try {
            // Open the CSV file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Read the header line and skip it
            String line = reader.readLine();

            // Initialize variables to track the employee with the lowest salary
            String lowestSalaryEmployeeName = null;
            double lowestSalary = Double.MAX_VALUE;

            // Read and process each employee's details
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                String name = employeeData[0];
                double salary = Double.parseDouble(employeeData[2]);

                // Check if the current employee has the lowest salary so far
                if (salary < lowestSalary) {
                    lowestSalary = salary;
                    lowestSalaryEmployeeName = name;
                }
            }

            // Close the reader
            reader.close();

            // Display the employee with the lowest salary
            if (lowestSalaryEmployeeName != null) {
                System.out.println("Employee with Lowest Salary:");
                System.out.println("Name: " + lowestSalaryEmployeeName);
                System.out.println("Salary: " + lowestSalary);
            } else {
                System.out.println("No employees found in the database.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error occurred while parsing salary: " + e.getMessage());
        }
    }

    /**
     * Finds and displays the youngest employee from the CSV file.
     * @param fileName The name of the CSV file.
     */
    public static void findYoungestEmployee(String fileName) {
        System.out.println("\n=== Find Youngest Employee ===");
        try {
            // Open the CSV file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Read the header line (discard it as we don't need it for this operation)
            reader.readLine();

            int youngestAge = Integer.MAX_VALUE;
            String youngestEmployee = null;

            // Read each employee's details and find the youngest employee
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int age = Integer.parseInt(employeeData[1]);

                if (age < youngestAge) {
                    youngestAge = age;
                    youngestEmployee = employeeData[0];
                }
            }

            // Close the reader
            reader.close();

            if (youngestEmployee != null) {
                System.out.println("Youngest Employee: " + youngestEmployee);
                System.out.println("Age: " + youngestAge);
            } else {
                System.out.println("No employees found in the database.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing employee age: " + e.getMessage());
        }
    }

    public static void findOldestEmployee(String fileName) {
        // Implementation for finding the oldest employee
    }

    public static void findEmployeesWithinAgeRange(String fileName, Scanner scanner) {
        // Implementation for finding employees within a specific age range
    }

    public static void calculateTotalSalary(String fileName) {
        // Implementation for calculating total salary of all employees
    }

    public static void calculateAverageAge(String fileName) {
        // Implementation for calculating the average age of employees
    }

    public static void calculateAverageSalary(String fileName) {
        // Implementation for calculating the average salary of employees
    }

    public static void findEmployeesAboveSalaryThreshold(String fileName, Scanner scanner) {
        // Implementation for finding employees above a certain salary threshold
    }

    public static void updateEmployeeAge(String fileName, Scanner scanner) {
        // Implementation for updating employee age
    }

    public static void updateEmployeeName(String fileName, Scanner scanner) {
        // Implementation for updating employee name
    }

    public static void removeEmployeeByName(String fileName, Scanner scanner) {
        // Implementation for removing an employee by name
    }

    public static void removeEmployeeByIndex(String fileName, Scanner scanner) {
        // Implementation for removing an employee by index
    }

    public static void sortEmployeesByAge(String fileName) {
        // Implementation for sorting employees by age
    }

    public static void sortEmployeesBySalary(String fileName) {
        // Implementation for sorting employees by salary
    }
}
