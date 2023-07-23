package GradedAssignmentonArraysandFileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "./GradedAssignmentonArraysandFileHandling/catalog.csv"; // Replace "data.csv" with the actual CSV file name
        String line;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                for (String value : data) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

