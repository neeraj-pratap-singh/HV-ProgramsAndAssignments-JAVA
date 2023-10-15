import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileValidationAndTransformationValidation {
    private static final Logger logger = LogManager.getLogger(FileValidationAndTransformation.class);

    public static void main(String[] args) {
        int totalRecords = 0;
        int validRecords = 0;
        int invalidRecords = 0;
        List<String> transformedRecords = new ArrayList<>();
        List<String> invalidLogs = new ArrayList<>();

        // Read "input.txt" and validate each record
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalRecords++;
                String[] fields = line.split(",");

                if (fields.length == 3) {
                    validRecords++;
                    String transformedRecord = String.format("Email: %s, Name: %s, Age: %s", fields[2], fields[0], fields[1]);
                    transformedRecords.add(transformedRecord);
                } else {
                    invalidRecords++;
                    String invalidLog = String.format("Invalid record '%s': Expected 3 fields, got %d fields.", line, fields.length);
                    invalidLogs.add(invalidLog);
                    logger.error(invalidLog);
                }
            }
        } catch (IOException e) {
            logger.error("Error reading input.txt: " + e.getMessage(), e);
        }

        // Write transformed records to "output.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String record : transformedRecords) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error("Error writing output.txt: " + e.getMessage(), e);
        }

        // Print summary report
        System.out.println("Summary Report:");
        System.out.println("Total Records: " + totalRecords);
        System.out.println("Valid Records: " + validRecords);
        System.out.println("Invalid Records: " + invalidRecords);
        System.out.println("Invalid Logs: ");
        for (String log : invalidLogs) {
            System.out.println("  - " + log);
        }
    }
}
