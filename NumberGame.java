import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1; // Minimum range for the generated number
        int maxRange = 100; // Maximum range for the generated number
        int maxAttempts = 5; // Maximum number of attempts allowed
        
        int score = 0; // Initialize score
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
            
            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                
                attempts++;
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                if (attempts >= maxAttempts) {
                    System.out.println("You have reached the maximum number of attempts. The correct number was " + randomNumber + ".");
                    break;
                }
            }
            
            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.next();
            
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Your score: " + score);
        
        scanner.close();
    }
}