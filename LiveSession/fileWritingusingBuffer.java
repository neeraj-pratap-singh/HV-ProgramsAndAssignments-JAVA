import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class fileWritingusingBuffer {
    public static void main(String[] args) {
        String f1 = "./LiveSESSION/testFileWriting.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f1, true));
            File f = new File(f1); 
            if (f.length() == 0) {
                bw.write("Name, Age, TotalMarks, Class");
            }
            bw.newLine();
            bw.write("Nick, 27, 100, 10");
            bw.newLine();
            bw.write("Raj, 28, 99, 10");
            bw.newLine();
            bw.write("Ish, 29, 50, 10");
            bw.close();
        }

        catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }
}