/*
 This program is supposed to allow the user to add numbers to
 an array, stopping when the enter a negative value.
 At the end, it should display the contents of the array
 
 It's required that new values appear at the beginning of the array,
 not the end.
 
 The program isn't working correctly at all.
 
 Your task is to:
 
 1) Fix the program so that it actually correctly maintains
    the entered numbers, with new numbers appearing at the
    beginning of the list, and no negative numbers in the list
    
 2) Try to make the program error-proof; deal with cases where
    the user enters invalid values, or enters too many values.
    You cannot make the array bigger, or replace it with a
    different type of structure like a List.  Once the array
    is full, the program should just tell the user that they
    can't enter any more numbers, display the contents of the array
    and end
*/
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in); // Scanner to take user input
        
        int[] values = new int[100]; // Array to store up to 100 numbers
        int valueCount = 0; // Keeps track of how many numbers are stored
        int newValue = 0; // Used to control when to stop input
        
        while(newValue >= 0){ // Keep looping until user enters a negative number
            int temp = getInteger(sc); // Get a valid integer from the user

            if (valueCount >= 100) { // If array is full, stop taking input
                System.out.println("Array is full! No more numbers can be added.");
                break;
            }
            else if(temp < 0){ // If user enters a negative number, exit loop
                newValue = -1;
                break;
            }            

            // Shift existing numbers to the right to make space at index 0
            for(int i = valueCount; i > 0; i--){
                values[i] = values[i-1];
            }
            values[0] = temp; // Store the new number at the beginning
            
            valueCount++; // Increase the count of stored numbers
        }

        // Print out the numbers the user entered
        System.out.println("Done! Here are your numbers:");
        System.out.print("[ ");
        for (int i = 0; i < valueCount; i++){
            System.out.format("%d ", values[i]); // Print each number in the array
        }
        System.out.println("]");

        // Close the Scanner to prevent resource leaks
        sc.close();
    }
    
    public static int getInteger(Scanner sc){
        int nValue = 0; // Stores the valid number entered by the user
        boolean bValueInput = false; // Flag to track if input is valid
    
        while (!bValueInput){ // Keep asking for input until user enters a valid integer
            try{
                System.out.print("Please enter a number (type a negative number to end): ");
                nValue = sc.nextInt(); // Read user input
                bValueInput = true; // Input is valid, exit loop

            }catch (Exception e) { // If user enters something invalid
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // Clear invalid input
                bValueInput = false; // Keep asking for input
            }
        }

        return nValue; // Return the valid number
    }
}
