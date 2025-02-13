
import java.util.Scanner;  // Import Scanner class for user input

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for input
        int input; // declare  variable to store user input

        // Keep asking the user until they enter a positive integer
        do {
            System.out.print("Please enter a positive integer: ");
            input = scanner.nextInt(); // scans the input and stores it in the variable input
        } while (input <= 0);  // loop repeats if input value is less than or equal to 0

        scanner.close();  // Close the scanner to free resources

        int a = 0, b = 1;  // defines the first two fib numbers 0, 1 as a and b

        // Special cases for 1st, 2nd, and 3rd Fibonacci numbers to format output correctly
        if(input == 1){ 
            System.out.println("The 1st Fibonacci number is 0");
        }
        else if(input == 2){ 
            System.out.println("The 2nd Fibonacci number is 1");
        }
        else if(input == 3){// Loop to calculate the Fibonacci number  
            for (int i = 1; i < input; i++) {  
                int temp = a + b;  // Add the previous two numbers  
                // Swap values: 'a' moves to 'b', and 'b' becomes the new Fibonacci number  
                a = b;  
                b = temp;  
            }
            // Prints the output of the fib number
            System.out.println("The 3rd Fibonacci number is " + a);
        }
        else{ // the main part logic with the correct outputs. (numbers after 3 have 'th' after them)
            
            // Loop to calculate the Fibonacci number  
            for (int i = 1; i < input; i++) {  
                int temp = a + b;  // Add the previous two numbers  
                // Swap values: 'a' moves to 'b', and 'b' becomes the new Fibonacci number  
                a = b;  
                b = temp;  
            }
            // Prints the output of the fib number
            System.out.println("The " + input + "th Fibonacci number is " + a);

        }
    }
}
