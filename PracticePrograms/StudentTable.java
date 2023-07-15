import java.util.Scanner;

public class StudentTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] studentNames = new String[numStudents];
        double[] studentGPAs = new double[numStudents];

        // Get student names and GPAs from the user with validations
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();

            while (!isValidName(studentNames[i])) {
                System.out.println("Invalid name! Name must not be empty or contain numbers. Please try again.");
                System.out.print("Enter the name of student " + (i + 1) + ": ");
                studentNames[i] = scanner.nextLine();
            }

            System.out.print("Enter the GPA of student " + (i + 1) + ": ");
            studentGPAs[i] = scanner.nextDouble();

            while (!isValidGPA(studentGPAs[i])) {
                System.out.println("Invalid GPA! GPA must be between 0.0 and 10.0. Please try again.");
                System.out.print("Enter the GPA of student " + (i + 1) + ": ");
                studentGPAs[i] = scanner.nextDouble();
            }

            scanner.nextLine(); // Consume the newline character
        }

        // Sort the student table based on ascending or descending order of GPA
        System.out.print("Sort table by GPA (Ascending/Descending)? Enter A for Ascending or D for Descending: ");
        String sortOption = scanner.nextLine().toUpperCase();

        if (sortOption.equals("A")) {
            sortByAscendingGPA(studentNames, studentGPAs);
        } else if (sortOption.equals("D")) {
            sortByDescendingGPA(studentNames, studentGPAs);
        } else {
            System.out.println("Invalid sort option. Defaulting to ascending order.");
            sortByAscendingGPA(studentNames, studentGPAs);
        }

        // Print the student table
        System.out.println("\nStudent Table");
        System.out.println("-------------");
        System.out.println("Name\t\tGPA");
        System.out.println("----\t\t---");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10s\t%.2f%n", studentNames[i], studentGPAs[i]);
        }

        scanner.close();
    }

    // Helper method to validate the student name
    private static boolean isValidName(String name) {
        return !name.isEmpty() && !name.matches(".*\\d.*");
    }

    // Helper method to validate the student GPA
    private static boolean isValidGPA(double gpa) {
        return gpa >= 0.0 && gpa <= 10.0;
    }

    // Helper method to sort the student table by ascending GPA
    private static void sortByAscendingGPA(String[] studentNames, double[] studentGPAs) {
        int numStudents = studentNames.length;
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (studentGPAs[j] > studentGPAs[j + 1]) {
                    swapStudents(studentNames, studentGPAs, j, j + 1);
                }
            }
        }
    }

    // Helper method to sort the student table by descending GPA
    private static void sortByDescendingGPA(String[] studentNames, double[] studentGPAs) {
        int numStudents = studentNames.length;
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (studentGPAs[j] < studentGPAs[j + 1]) {
                    swapStudents(studentNames, studentGPAs, j, j + 1);
                }
            }
        }
    }

    // Helper method to swap student data in the arrays
    private static void swapStudents(String[] studentNames, double[] studentGPAs, int i, int j) {
        String tempName = studentNames[i];
        double tempGPA = studentGPAs[i];
        studentNames[i] = studentNames[j];
        studentGPAs[i] = studentGPAs[j];
        studentNames[j] = tempName;
        studentGPAs[j] = tempGPA;
    }
}
