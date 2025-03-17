import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Processes student grades from a file and writes the results to an output file.
 */
public class Assignment5 {

    /**
     * Main method that controls file reading, processing, and writing output.
     * @param args Command-line arguments (not used).
     * @throws {@link java.io.IOException} if the input or output file cannot be accessed.
     */
    public static void main(String[] args) {
        try {
            // Creating a File object for reading the input file
            File textFile = new File("Assignment5_input.txt");
            // Creating a FileWriter object to write output to the output file
            FileWriter output = new FileWriter("Assignment5_Output.txt", false);

            // Calling the counters function to count the number of students (lines in the file)
            int counter = counters(0, textFile);
            // Checking if no data is found
            if(counter == 0) {
                System.out.println("No data found."); // Printing message if no data
            }
            else {
                // Calling total_arr to read the data into an array
                String[] Totalarr = total_arr(counter, textFile);
                // Calling names function to extract names of students
                String[] Name_Arr = names(counter, Totalarr);
                // Calling grades function to extract grades of students
                int[] Grade_Arr = grades(counter, Totalarr);

                // Calling End function to compute and write the statistics to the output file
                End(Name_Arr, Grade_Arr, counter, output);

                // Closing the output file after writing is complete
                output.close();
            }

        } catch(IOException e) {
            // Catching IOException and printing an error message if file reading/writing fails
            System.out.println("Error: Unable to read/write file. Please try again");
            e.printStackTrace(); // Printing the stack trace for debugging
        }
    }

    /**
    * Processes student data to compute the average grade, highest grade, 
    * lowest grade, and outputs this information to a file.
    *
    * @param Name_Arr Array of student names.
    * @param Grade_Arr Array of student grades.
    * @param counter The total number of students.
    * @param output A {@link java.io.FileWriter} object used to write the results to a file.
    * @throws {@link java.io.IOException} If there is an error while writing to the output file.
    */
    public static void End(String[] Name_Arr, int[] Grade_Arr, int counter, FileWriter output) {
        int max; // Variable to store the highest grade
        int min; // Variable to store the lowest grade
        String name_max = ""; // String to store names of students with the highest grade
        String name_min = ""; // String to store names of students with the lowest grade
        double avg; // Variable to store the average grade
        double avg_counter = 0.0; // Variable to accumulate grade totals for average calculation
        boolean error_value = false; // Flag to check if there's an error in the input file format
        
        // Sorting grades and corresponding names using bubbleSort
        bubbleSort(Grade_Arr, Name_Arr);

        // Loop through all grades to calculate the average and check for errors
        for (int i = 0; i < Grade_Arr.length; i++) {
            if (Grade_Arr[i] < 0) { // Checking for invalid grade value
                error_value = true; // Set error flag to true
                break; // Exit the loop if an error is found
            }
            avg_counter = avg_counter + Grade_Arr[i]; // Adding grade to the total
        }

        // Calculating the average grade
        avg = avg_counter / Grade_Arr.length;
        
        // If there's an error with the input file, print an error message
        if (error_value == true) {
            System.out.println("Error with the input file formating, please try again");
        } else {
            // Assigning the highest and lowest grades after sorting
            max = Grade_Arr[Grade_Arr.length - 1];
            min = Grade_Arr[0];

            // Loop through grades to find names of students with the highest and lowest grades
            for (int i = 0; i < Grade_Arr.length; i++) {
                if (Grade_Arr[i] == max) { // If the grade is equal to max, add the name to the max list
                    name_max = name_max + ", " + Name_Arr[i];
                }
                if (Grade_Arr[i] == min) { // If the grade is equal to min, add the name to the min list
                    name_min = name_min + ", " + Name_Arr[i];
                }
            }

            // Creating formatted strings to display total students, average, highest and lowest grades
            String string1 = ("Total Students: " + counter + "\n");
            String string2 = String.format("Average Grade: %.1f", avg); // Formatting the average grade
            String string3 = ("%\n");
            String string4 = ("Highest Grade: " + max + " (" + name_max.substring(2) + ")\n"); // Removing the first comma
            String string5 = ("Lowest Grade: " + min + " (" + name_min.substring(2) + ")");

            try {
                // Writing the statistics to the output file
                output.write(string1);
                output.write(string2);
                output.write(string3);
                output.write(string4);
                output.write(string5);
            } catch(IOException e) {
                // Catching IOException in case of errors while writing to the output file
                e.printStackTrace();
                System.out.println("Error with writing to the file, please try again");
            }
        }
    }

        /**
     * Bubble sort algorithm to sort grades and corresponding names in ascending order.
     * The algorithm repeatedly compares adjacent elements and swaps them if they are in the wrong order.
     * It continues this process until the array is sorted.
     * 
     * @param grades Array of student grades to be sorted.
     * @param names Array of student names, where each name corresponds to a grade.
     */
    static void bubbleSort(int grades[], String names[]) {
        int n = grades.length; // Length of the grades array
        boolean swapped; // Flag to check if a swap was made in the inner loop

        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reset swapped flag at the start of each pass
            for (int j = 0; j < n - i - 1; j++) {
                if (grades[j] > grades[j + 1]) { // If the current grade is greater than the next
                    // Swap grades
                    int temp = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = temp;

                    // Swap corresponding names
                    String temp2 = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp2;

                    swapped = true; // Indicating that a swap was made
                }
            }
            if (!swapped) break; // Exit early if no swaps were made
        }
    }

    /**
     * Extracts student names from an array of student data (Totalarr) that contains both names and grades.
     * This method assumes the name is the first part of the data, and the grade follows it.
     * 
     * @param counter The number of students (the length of the Totalarr array).
     * @param Totalarr Array of strings representing student data, where each element contains a name and a grade.
     * @return An array of strings containing the names of the students.
     */
    public static String[] names(int counter, String[] Totalarr) {
        String[] Name_Arr = new String[counter]; // Creating an array to store names

        // Looping through the data and splitting to get the name part
        for (int i = 0; i < counter; i++) {
            String string = Totalarr[i]; // Get the student data
            String[] temp = string.split(" "); // Split the data into name and grade
            Name_Arr[i] = temp[0]; // Extract the name (first part of the split)
        }

        return Name_Arr; // Return the array of names
    }


    /**
    * Extracts grades from a given array of strings (representing student data) 
    * and converts them into an integer array.
    *
    * @param counter The number of students (length of Totalarr).
    * @param Totalarr Array of strings representing student names and grades.
    * @return An array of integers representing the grades of students.
    * @throws {@link java.lang.NumberFormatException} If a grade cannot be parsed as an integer.
    * @throws {@link java.lang.ArrayIndexOutOfBoundsException} If there is a mismatch in the number of fields.
    * @return Grade_Arr An array of integers representing the grades of students.
    */
    public static int[] grades(int counter, String[] Totalarr) {

        int[] Grade_Arr = new int[counter]; // Creating an array to store grades

        // Looping through the student data to extract grades
        for (int i = 0; i < counter; i++) {
            try {
                String string = Totalarr[i]; // Get the student data
                String[] temp = string.split(" "); // Split the data into name and grade
                Grade_Arr[i] = Integer.parseInt(temp[1]); // Parse the grade (second part of the split)
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Handling any parsing errors or array indexing issues
                System.out.println("Error: Invalid grade format at line " + (i + 1));
                Grade_Arr[i] = -1; // Assigning a value of -1 in case of error
            }
        }

        return Grade_Arr; // Return the array of grades
    }

    /**
    * Reads student data from a file and stores each line as a string in an array.
    *
    * @param counter The number of students (used to define the array size).
    * @param textFile The file containing the student data.
    * @return An array of strings, each representing a student's data (name and grade).
    * @throws {@link java.io.FileNotFoundException} If the file is not found.
    * @throws {@link java.io.IOException} If there is an error reading from the file.
    * @return arr An array of strings, each representing a student's data (name and grade).
    */
    public static String[] total_arr(int counter, File textFile) {
        String[] arr = new String[counter]; // Creating an array to store student data
        try {
            // Creating a scanner object to read the input file
            Scanner fileScanner = new Scanner(textFile);

            // Reading each line from the file and storing it in the array
            for (int i = 0; i < counter; i++) {
                String string = fileScanner.nextLine(); // Read the next line from the file
                arr[i] = string; // Store the line in the array
            }

            fileScanner.close(); // Close the file scanner

        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for any exception that occurs
        }
        return arr; // Return the array containing student data
    }

    /**
    * Counts the number of lines in a given file to determine the number of students.
    *
    * @param counter The initial count (typically 0).
    * @param textFile The file to be read.
    * @return The total number of lines (students) in the file. 
    *         In case of an {@link java.io.IOException}, returns a negative 
    *         value to indicate an {@code Exception} occurred.
    * @throws {@link java.io.IOException} If there is an error reading the file.
    * @return counter The total number of lines (students) in the file.
    */
    public static int counters(int counter, File textFile) {
        try {
            // Creating a scanner object to read the file
            Scanner fileScanner = new Scanner(textFile);

            // Looping through the file to count the number of lines (students)
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine(); // Read each line
                counter++; // Increment the counter for each line
            }
            fileScanner.close(); // Close the file scanner

        } catch (IOException e) {
            // Catching IOException if the file is not found or can't be read
            System.out.println("Error: File not found or cannot be read.");
            e.printStackTrace(); // Print the stack trace for debugging
        }

        return counter; // Return the final count of students
    }
}
