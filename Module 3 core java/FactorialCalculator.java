import java.util.Scanner;
public class FactorialCalculator {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Enter a number for its factorial:");
            int num = sc.nextInt();
            if (num < 0) {
                System.out.println("Factorial is not defined for negative numbers.");
            } 
            else {
                long factorial = 1;
                for (int i = 1; i <= num; i++) {
                    factorial *= i;
                }
                System.out.println("Factorial of " + num + " is: " + factorial);
                break;
            }
        }
    }
}
