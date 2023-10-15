// 2. Implement a file validation and transformation process for text files:
//    - Create a file named "input.txt" with sample text data, including both valid and invalid records.

//    - Read the "input.txt" file and validate each record.

//      - Valid records should have a specific format (e.g., a CSV-like format with specific columns).

//      - Invalid records should be logged with details about what makes them invalid.

//    - Transform the valid records into a new format and write them to an "output.txt" file.

//    - Create a summary report that includes the number of valid and invalid records.
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileValidationAndTransformation {
    public static void main(String[] args) {
        // Initialize counters and lists
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

                // Validate record format: "Name,Age,Email"
                if (fields.length == 3) {
                    validRecords++;
                    // Transform and store the valid record
                    String transformedRecord = String.format("Email: %s, Name: %s, Age: %s", fields[2], fields[0], fields[1]);
                    transformedRecords.add(transformedRecord);
                } else {
                    invalidRecords++;
                    // Log the invalid record
                    invalidLogs.add(String.format("Invalid record '%s': Expected 3 fields, got %d fields.", line, fields.length));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input.txt: " + e.getMessage());
        }

        // Write the transformed records to "output.txt"
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String record : transformedRecords) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing output.txt: " + e.getMessage());
        }

        // Print the summary report
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
