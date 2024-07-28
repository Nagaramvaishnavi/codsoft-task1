import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (playAgain) {
                int numberToGuess = random.nextInt(100) + 1;
                int attempts = 0;
                boolean guessedCorrectly = false;
                final int maxAttempts = 10;

                System.out.println("I have generated a random number between 1 and 100. Try to guess it!");

                while (!guessedCorrectly && attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < numberToGuess) {
                        System.out.println("Too low!");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Correct! You've guessed the number.");
                        guessedCorrectly = true;
                    }

                    if (attempts == maxAttempts && !guessedCorrectly) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + numberToGuess + ".");
                    }
                }

                if (guessedCorrectly) {
                    totalScore += maxAttempts - attempts + 1; 
                }

                System.out.println("Your current score is: " + totalScore);

                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            }
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
    }
}
