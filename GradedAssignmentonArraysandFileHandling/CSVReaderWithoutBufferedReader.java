package GradedAssignmentonArraysandFileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReaderWithoutBufferedReader {
    public static void main(String[] args) {
        String fileName = "/Users/zero2one/Documents/Vlearn\\ hero/java/HV-ProgramsAndAssignments-JAVA/GradedAssignmentonArraysandFileHandling/catalog.csv";

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Assuming the first line of the CSV file contains headers
            String headersLine = scanner.nextLine();
            String[] headers = headersLine.split(",");

            while (scanner.hasNextLine()) {
                String dataLine = scanner.nextLine();
                String[] data = dataLine.split(",");

                // Process data here or store it in appropriate data structures
                for (int i = 0; i < headers.length; i++) {
                    System.out.println(headers[i] + ": " + data[i]);
                }
                System.out.println("--------------------");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        }
    }
}
