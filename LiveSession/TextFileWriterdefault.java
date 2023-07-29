import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriterdefault {
    public static void main(String[] args) {
        // Add some sample data as individual strings
        String line1 = "Hello, Neeraj, how are you";
        String line2 = "Welcome to java coding!";
        String line3 = "The final comment";

        // Specify the file path where you want to write the data
        String filePath = "./LiveSESSION/fileoutputNoStringBuilder.txt";

        // Call the method to write the content to the file
        writeToFile(filePath, line1, line2, line3);
    }

    private static void writeToFile(String filePath, String... lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write each line to the file
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Add a new line after each line of text
            }

            // Flush and close the writer to ensure data is written to the file
            writer.flush();
            writer.close();

            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
