package StudentGradingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;
// import java.util.Scanner;

class Student {
    private String name;
    private int maths;
    private int science;
    private int english;
    private String teacherFeedback;

    public Student(String name, int maths, int science, int english, String teacherFeedback) {
        this.name = name;
        this.maths = maths;
        this.science = science;
        this.english = english;
        this.teacherFeedback = teacherFeedback;
    }

    public String getName() {
        return name;
    }

    public int getMathsScore() {
        return maths;
    }

    public int getScienceScore() {
        return science;
    }

    public int getEnglishScore() {
        return english;
    }

    public double getGPA() {
        return (maths + science + english) / 3.0;
    }

    public String getTeacherFeedback() {
        return teacherFeedback;
    }
}

public class StudentReportCard {
    private List<Student> students;

    public StudentReportCard() {
        students = new ArrayList<>();
    }

    public void readDataFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                int maths = Integer.parseInt(data[1].trim());
                int science = Integer.parseInt(data[2].trim());
                int english = Integer.parseInt(data[3].trim());
                String feedback = data[4].trim();

                students.add(new Student(name, maths, science, english, feedback));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void displayClassAnalysis() {
    //     students.sort(Comparator.comparingDouble(Student::getGPA).reversed());

    //     System.out.println("Class level analysis (sorted by highest GPA to lowest):");
    //     System.out.printf("%-4s %-12s %-6s %-8s %-8s %-30s%n", "Rank", "Name", "Maths", "Science", "English", "Teacher's Feedback");
    //     for (int i = 0; i < students.size(); i++) {
    //         Student student = students.get(i);
    //         System.out.printf("%-4d %-12s %-6d %-8d %-8d %-30s%n",
    //                 (i + 1), student.getName(), student.getMathsScore(), student.getScienceScore(), student.getEnglishScore(), student.getTeacherFeedback());
    //     }
    // }

    // public void displayTopper(String subject) {
    //     students.sort(Comparator.comparingInt(stu -> {
    //         switch (subject) {
    //             case "math":
    //                 return ((Student) stu).getMathsScore();
    //             case "science":
    //                 return ((Student) stu).getScienceScore();
    //             case "english":
    //                 return ((Student) stu).getEnglishScore();
    //             default:
    //                 return 0;
    //         }
    //     }).reversed());

    //     Student topper = students.get(0);
    //     System.out.println("Topper in " + subject + ": " + topper.getName() + " - Score: " + String.format("%.2f", topper.getGPA()));
    // }

    // public void displayStudentRankAndFeedback(String studentName) {
    //     for (int i = 0; i < students.size(); i++) {
    //         Student student = students.get(i);
    //         if (student.getName().equalsIgnoreCase(studentName)) {
    //             System.out.println("Student: " + student.getName());
    //             System.out.println("Rank in class: " + (i + 1));
    //             System.out.println("Teacher's Feedback: " + student.getTeacherFeedback());
    //             return;
    //         }
    //     }
    //     System.out.println("Student with name '" + studentName + "' not found in the class.");
    // }

    // public double getClassAverage() {
    //     double totalGPA = 0;
    //     for (Student student : students) {
    //         totalGPA += student.getGPA();
    //     }
    //     return totalGPA / students.size();
    // }

    // public void displaySubjectClassAverage() {
    //     System.out.println("\nSubject-wise Class Average:");
    //     System.out.println("Subject    Average");
    //     System.out.println("--------------------");
    //     double mathsAverage = 0, scienceAverage = 0, englishAverage = 0;
    //     for (Student student : students) {
    //         mathsAverage += student.getMathsScore();
    //         scienceAverage += student.getScienceScore();
    //         englishAverage += student.getEnglishScore();
    //     }
    //     mathsAverage /= students.size();
    //     scienceAverage /= students.size();
    //     englishAverage /= students.size();
    //     System.out.printf("Maths      %.2f%n", mathsAverage);
    //     System.out.printf("Science    %.2f%n", scienceAverage);
    //     System.out.printf("English    %.2f%n", englishAverage);
    // }

    // public void displayTopStudents(int n) {
    //     int topCount = (int) Math.ceil(n * students.size() / 100.0);
    //     students.sort(Comparator.comparingDouble(Student::getGPA).reversed());

    //     System.out.println("\nTop " + n + "% Students:");
    //     System.out.println("Rank  Name           GPA");
    //     System.out.println("-------------------------");
    //     for (int i = 0; i < topCount; i++) {
    //         Student student = students.get(i);
    //         System.out.printf("%-5d %-14s %.2f%n", (i + 1), student.getName(), student.getGPA());
    //     }
    // }

    // public void displayFailingStudents() {
    //     List<Student> failingStudents = new ArrayList<>();
    //     for (Student student : students) {
    //         if (student.getGPA() < 40) { // Assuming a passing grade is 40 (you can adjust this threshold)
    //             failingStudents.add(student);
    //         }
    //     }
    //     if (failingStudents.isEmpty()) {
    //         System.out.println("\nNo failing students.");
    //     } else {
    //         System.out.println("\nFailing Students:");
    //         System.out.println("Name           GPA");
    //         System.out.println("-------------------");
    //         for (Student student : failingStudents) {
    //             System.out.printf("%-14s %.2f%n", student.getName(), student.getGPA());
    //         }
    //     }
    // }

    public static void main(String[] args) {
        StudentReportCard studentReportCard = new StudentReportCard();
        String filePath = "./StudentGradingSystem/reportCard.csv"; // Replace with the actual file path
        studentReportCard.readDataFromCSV(filePath);

        // studentReportCard.displayClassAnalysis();
        // studentReportCard.displayTopper("math");
        // studentReportCard.displayTopper("science");
        // studentReportCard.displayTopper("english");

        // System.out.println("\nClass Average (Overall GPA): " + String.format("%.2f", studentReportCard.getClassAverage()));
        // studentReportCard.displaySubjectClassAverage();

        // // Display top 10% students
        // studentReportCard.displayTopStudents(10);

        // // Display failing students (GPA < 40)
        // studentReportCard.displayFailingStudents();
    }
}
