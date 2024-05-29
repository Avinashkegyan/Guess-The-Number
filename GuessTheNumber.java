package com.avi.Guess_The_Number;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int rounds = 1; 
        boolean playAgain = true;

        while (playAgain && rounds > 0) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to 'Guess the Number'!");
            System.out.println("I have selected a number between 1 and 100. Can you guess what it is?");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (numberOfAttempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - numberOfAttempts));
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
            rounds--;
        }

        System.out.println("Thank you for playing 'Guess the Number'! Goodbye.");
        scanner.close();
    }
}
