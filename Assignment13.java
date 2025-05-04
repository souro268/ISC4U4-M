package Assignment13;
import java.util.Scanner;

public class Assignment13 {

    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user for dimensions of the 2D array
        System.out.println("Create a table");
        System.out.print("How many rows: ");
        int rows = input.nextInt(); // Number of rows
        System.out.print("How many columns: ");
        int cols = input.nextInt(); // Number of columns

        // Create a 2D array with the given size, all values default to 0
        int[][] table = new int[rows][cols];

        // Main loop: keeps asking user to input values until they enter an invalid location
        while (true) {
            // Display the current table contents
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(table[i][j] + " "); // Print each value in row
                }
                System.out.println(); // Newline after each row
            }

            // Print total of each row using rowTotal method
            System.out.print("Row totals: ");
            for (int i = 0; i < rows; i++) {
                System.out.print(rowTotal(table, i) + " ");
            }
            System.out.println(); // Newline after row totals

            // Print total of each column using columnTotal method
            System.out.print("Column totals: ");
            for (int j = 0; j < cols; j++) {
                System.out.print(columnTotal(table, j) + " ");
            }
            System.out.println(); // Newline after column totals

            // Ask user where to place a new value
            System.out.print("\nRow: ");
            int row = input.nextInt(); // Row index (0-based)
            System.out.print("Column: ");
            int col = input.nextInt(); // Column index (0-based)

            // If input is out of bounds, end the program
            if (row < 0 || col < 0 || row >= rows || col >= cols) {
                System.out.println("Invalid location. Ending program.");
                break;
            }

            // If input is valid, ask for the value and place it in the table
            System.out.print("Value: ");
            int value = input.nextInt(); // Value to insert
            table[row][col] = value; // Update the array with new value
            System.out.println(); // Space before next loop
        }

        input.close(); // Close the scanner
    }
    // Method to calculate the total of a specific row in the table
    public static int rowTotal(int[][] array, int row) {
        int total = 0;
        // Loop through each column in the specified row and add the values
        for (int col = 0; col < array[row].length; col++) {
            total += array[row][col];
        }
        return total;
    }

    // Method to calculate the total of a specific column in the table
    public static int columnTotal(int[][] array, int col) {
        int total = 0;
        // Loop through each row for the specified column and add the values
        for (int row = 0; row < array.length; row++) {
            total += array[row][col];
        }
        return total;
    }
}
