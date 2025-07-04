import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int target = rand.nextInt(100) + 1; 
        int guess;
        System.out.println("Guess the number between 1 and 100:");
        while (true) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            if (guess < target) {
                System.out.println("Too low. Try again.");
            } 
            else if (guess > target) {
                System.out.println("Too high. Try again.");
            } 
            else {
                System.out.println("Correct! You guessed the number.");
                break;
            }
        }
        sc.close();
    }
}
