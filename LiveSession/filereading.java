import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class filereading {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("demo.txt"));
            for (String line : lines) {
                // Process the line of data
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
