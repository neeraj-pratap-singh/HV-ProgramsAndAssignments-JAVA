// 1. Create a Java program that analyzes a directory and its subdirectories. The program should do the following:

//    - Recursively traverse the directory and its subdirectories.

//    - Identify and list all files with a ".txt" extension.

//    - Calculate the total size (in bytes) of all ".txt" files in the directory and its subdirectories.

//    - Identify and list all unique words found in these ".txt" files (case insensitive).

//    - Count the frequency of each unique word and display the top 10 most frequent words.

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DirectoryAnalyzer {
    private static long totalSize = 0;
    private static final Map<String, Integer> wordFrequency = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        analyzeDirectory(directory);

        System.out.println("Total size of .txt files: " + totalSize + " bytes");
        System.out.println("Top 10 frequent words: ");
        printTopFrequentWords(10);
    }

    private static void analyzeDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    analyzeDirectory(file);
                } else if (file.getName().endsWith(".txt")) {
                    totalSize += file.length();
                    analyzeFile(file.toPath());
                }
            }
        }
    }

    private static void analyzeFile(Path path) {
        try {
            String content = new String(Files.readAllBytes(path)).toLowerCase();
            String[] words = content.split("\\W+");
            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void printTopFrequentWords(int n) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );
        pq.addAll(wordFrequency.entrySet());

        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
