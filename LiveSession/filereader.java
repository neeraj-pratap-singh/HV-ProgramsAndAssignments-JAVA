
import java.io.FileReader;

public class filereader {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("demo.txt");
        int i;
        while ((i = fr.read()) != -1)
            System.out.print((char) i);
        fr.close();
    }

    public static void close() {
    }
}
