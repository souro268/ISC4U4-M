
import java.util.Scanner;  // Import Scanner class for user input

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for input
        int input; // decare variable to store user input

        // Keep asking the user until they enter a positive integer
        do {
            System.out.print("Please enter a positive integer: ");
            input = scanner.nextInt(); // scans the input and stores it in the variable input
        } while (input <= 0);  // loop repeats if input value is less than or equal to 0

        scanner.close();  // Close the scanner to free resources

        int a = 0, b = 1;  // defines the first two fib numbers

        // for loop to calculate the fib number
        for (int i = 1; i < input; i++) {  
            int temp = a + b;  // adds the previous two numbers
            a = b;
            b = temp;
        }

        // Prints the output of the fib number
        System.out.println("The " + input + "th Fibonacci number is " + a);
    }
}
