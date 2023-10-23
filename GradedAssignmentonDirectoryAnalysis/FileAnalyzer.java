import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class FileAnalyzer {
    
    private static String logFilePath;
    private static String validFileFormat;

    public static void main(String[] args) {
        // Load Configuration File
        loadConfig();

        // Command-line argument for the directory path
        if (args.length < 1) {
            System.out.println("Please specify the directory path to be analyzed.");
            return;
        }

        String directoryPath = args[0];
        String keyword = args.length > 1 ? args[1] : null;

        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFilePath, true))) {
            Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(validFileFormat))
                .forEach(path -> analyzeFile(path, keyword, logWriter));
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void loadConfig() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            logFilePath = prop.getProperty("logFilePath", "log.txt");
            validFileFormat = prop.getProperty("validFileFormat", ".txt");
        } catch (IOException ex) {
            System.out.println("Unable to load configuration file. Using default settings.");
            logFilePath = "log.txt";
            validFileFormat = ".txt";
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    // Do nothing
                }
            }
        }
    }

    private static void analyzeFile(Path path, String keyword, PrintWriter logWriter) {
        logWriter.println("Analyzing file: " + path.toString());
        
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (keyword != null && line.contains(keyword)) {
                    System.out.println("File: " + path + " [Line " + lineNumber + "]: " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            logWriter.println("An error occurred while analyzing the file: " + e.getMessage());
        }
    }
}
