package ProblemStatementsGame;

import java.util.Random;
import java.util.Scanner;

public class hangman {

    public static void main(String[] args) {
        // Task: Create an array of words to use as the word bank.
        Scanner scanner = new Scanner(System.in);
        String[] wordBank = { "apple", "banana", "orange", "grape", "mango" };

        // Task: Randomly select a word from the word bank.
        Random random = new Random();
        String selectedWord = wordBank[random.nextInt(wordBank.length)];

        // Task: Initialize variables to keep track of the player's guessed letters and
        // incorrect guesses count.
        int allowedIncorrectGuesses = 6;
        int incorrectGuesses = 0;
        boolean resultFlag = false;
        // StringBuilder guessedLetters = new StringBuilder();
        char[] guessedLetters = new char[selectedWord.length()];

        //check all vowels in the selected word
        for (int i = 0; i < selectedWord.length(); i++) {
            char letter = selectedWord.charAt(i);
            if (Character.isLetter(letter) && "aeiouAEIOU".indexOf(letter) != -1) {
                guessedLetters[i] = letter;
            }
        }

        // Task: Display a welcome message to the player.
        System.out.println("Welcome to Word Guessing Game!" + selectedWord);

        // Task: Implement the game loop, which continues until the player wins or
        // loses.
        while (incorrectGuesses < allowedIncorrectGuesses) {
            // Task: Display the partially guessed word, showing underscores (_) for
            // unguessed letters.
            // Hint: Use a loop to iterate through the selectedWord characters and check if
            // the character is guessed or not.
            //code to display guessed characters
            System.out.println("Letters");
            for (char letter : guessedLetters) {
                System.out.print(letter == '\u0000' ? "_ " : letter + " ");
            }
            System.out.println("");

            // Task: Display the number of incorrect guesses and the hangman figure.
            // Hint: You can use a switch statement to draw the hangman figure based on the
            // incorrect guesses count.
            switch (incorrectGuesses) {
                case 0:
                    System.out.println("  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========");
                    break;
                case 1:
                    System.out.println("  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========");
                    break;
                case 2:
                    System.out.println("  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========");
                    break;
                case 3:
                    System.out.println("  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========");
                    break;
                case 4:
                    System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========");
                    break;
                case 5:
                    System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========");
                    break;
                case 6:
                    System.out.println("  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========");
                    break;
            }
            

            // Task: Display the guessed letters.
            // Hint: Use guessedLetters.toString() to convert StringBuilder to String.

            // Task: Prompt the player to enter a letter.
            // Hint: Use Scanner class to read player input.
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);
            System.out.println("");

            // Task: Check if the letter is present in the selected word.
            // - If yes, reveal the letter in the word and update the partially guessed word
            // accordingly.
            // - If no, increase the incorrect guesses count and add the guessed letter to
            // the guessed letters list.
            boolean guessedCorrectly = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    guessedLetters[i] = guess;
                    guessedCorrectly = true;
                }
            }
            if(!guessedCorrectly){
                incorrectGuesses++;
            }

            String guessedLettersAsString = new String(guessedLetters);
            if(selectedWord.equals(guessedLettersAsString)){
                System.out.println("you have spelled correct word, you have won");
                resultFlag = true;
                break;
            }

            // Task: Check if the player has correctly guessed the entire word.
            // - If yes, display a victory message and break the game loop.
            // - If no, continue to the next iteration of the game loop.
        }

        // Task: Display a victory or defeat message based on the game outcome.
        // Hint: Use a conditional statement to check if the player won or lost.
        if(!resultFlag){
                System.out.println("you have Lost");
            }

        // Task: Reveal the selected word to the player.
        System.out.println("The word was: " + selectedWord);
        scanner.close();
    }
}
