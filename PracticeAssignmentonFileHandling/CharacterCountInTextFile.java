package PracticeAssignmentonFileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCountInTextFile {
    public static void main(String[] args) {
        String fileName = "./PracticeAssignmentonFileHandling/HeroVired.txt";
        int totalCharacters = countCharactersInFile(fileName);
        System.out.println("Total number of characters in file are: " + totalCharacters);
    }

    public static int countCharactersInFile(String fileName) {
        int characterCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int character;
            while ((character = reader.read()) != -1) {
                characterCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterCount;
    }
}
