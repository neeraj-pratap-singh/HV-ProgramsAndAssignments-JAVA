import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        // Add some sample data to the StringBuilder
        stringBuilder.append("Hello, Neeraj, how are you").append(System.lineSeparator());
        stringBuilder.append("Welcome to java coding!").append(System.lineSeparator());
        stringBuilder.append("The final comment").append(System.lineSeparator());

        // Specify the file path where you want to write the data
        String filePath = "./LiveSESSION/fileoutputStringbuilder.txt";

        // Call the method to write the StringBuilder's content to the file
        writeToFile(filePath, stringBuilder);
    }

    private static void writeToFile(String filePath, StringBuilder data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the content of the StringBuilder to the file
            writer.write(data.toString());

            // Flush and close the writer to ensure data is written to the file
            writer.flush();
            writer.close();

            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
