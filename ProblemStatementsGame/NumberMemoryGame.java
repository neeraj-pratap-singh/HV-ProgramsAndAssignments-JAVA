// Game Description: "Number Memory Game"

// Objective: The player needs to memorize a sequence of randomly generated numbers and then enter the numbers in the correct order. The game will gradually increase the sequence length to challenge the player's memory.

// Steps to Implement the Game:

// Generate a random sequence of numbers and store them in an array.
// Display the sequence of numbers to the player for a few seconds to allow them to memorize it.
// Clear the screen to hide the sequence.
// Prompt the player to enter the numbers in the sequence.
// Compare the player's input with the original sequence to check if it's correct.
// Gradually increase the length of the sequence for each round.
// Keep track of the player's score based on the number of correct guesses.

package ProblemStatementsGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberMemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceLength = 3;
        int score = 0;

        System.out.println("Welcome to the Number Memory Game!");

        while (true) {
            int[] sequence = generateRandomSequence(sequenceLength);
            displaySequence(sequence);

            // Wait for a few seconds to allow the player to memorize the sequence
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clearScreen();

            System.out.println("Enter the numbers in the sequence:");

            // Read the player's input
            int[] playerInput = new int[sequenceLength];
            for (int i = 0; i < sequenceLength; i++) {
                playerInput[i] = scanner.nextInt();
            }

            // Compare player's input with the original sequence
            if (Arrays.equals(sequence, playerInput)) {
                System.out.println("Correct! Well done!");
                score++;
            } else {
                System.out.println("Wrong! Game Over. Your score: " + score);
                break;
            }

            // Increase sequence length for the next round
            sequenceLength++;
        }
        scanner.close();
    }

    private static int[] generateRandomSequence(int length) {
        Random random = new Random();
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = random.nextInt(10); // Generate random numbers between 0 and 9
        }
        return sequence;
    }

    private static void displaySequence(int[] sequence) {
        System.out.print("Memorize this sequence: ");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

