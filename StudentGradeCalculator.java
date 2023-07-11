// WAP in Java to take the total marks and the marks obtained by a Student. Then using your programming skills calculate the percentage obtained by a student along with the GPA.
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Marks Obtained by a Student: ");
        double marksObtained = scanner.nextDouble();

        System.out.print("Total Marks: ");
        double totalMarks = scanner.nextDouble();

        // Calculate percentage
        double percentage = (marksObtained / totalMarks) * 100;

        // Calculate GPA based on percentage
        double gpa;
        String grade;

        if (percentage >= 90) {
            gpa = 4.0;
            grade = "A";
        } else if (percentage >= 80) {
            gpa = 3.0;
            grade = "B";
        } else if (percentage >= 70) {
            gpa = 2.0;
            grade = "C";
        } else if (percentage >= 60) {
            gpa = 1.0;
            grade = "D";
        } else {
            gpa = 0.0;
            grade = "F";
        }

        // Output the results
        System.out.printf("\nPercentage: %.2f%%", percentage);
        System.out.println("\nGrade " + grade + ", GPA = " + gpa);

        scanner.close();
    }
}
