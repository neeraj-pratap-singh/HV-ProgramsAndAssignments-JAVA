import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filereaderusingbufferedreader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("demo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line of data
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
