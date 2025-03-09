import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {

        try {
            // Create a File object for the input file
            File textFile = new File("Assignment4_Input.txt");

            // Create a Scanner to read from the input file
            Scanner fileScanner = new Scanner(textFile);
            
            // Declare variables to store integer pairs
            int int1, int2;

            // Boolean flag to control loop execution
            boolean exit = false;

            // Create a FileWriter to write to the output file (overwrite mode)
            FileWriter output = new FileWriter("Assignment4_Output.txt", false);

            // Read pairs of integers from the file until no more numbers are available
            while (exit != true) {
                try {
                    // Read two integers from the file
                    int1 = fileScanner.nextInt();
                    int2 = fileScanner.nextInt();
                    
                    // Format the sum as an equation and write it to the output file
                    String temp = int1 + " + " + int2 + " = " + (int1 + int2);
                    output.write(temp + "\n");

                } catch (Exception e) {
                    // If an exception occurs (e.g., no more numbers), exit the loop
                    exit = true;
                }
            }

            // Close the file writer and scanner
            output.close();
            fileScanner.close();

        } catch (IOException e) {
            // Handle file-related errors (e.g., file not found, permission issues)
            e.printStackTrace();
        }
    }
}
