public class Assignment2 {

    public static void main(String[] args) {

        // Swapped the max and min values because they were switched for the function - runtime error
        int[] values = GetValues(100, 1); 
        //              ^ max and min were switched

        // For loop should start at 1 because you want to output 1-100, not 0-100 - logic error
        for (int i = 1; i < values.length; i++) { 
            //       ^ logic error

            // Values should have square brackets because it's an array - syntax error
            System.out.format("%d ", values[i]); 
            //                                      ^ square brackets instead of curly
        }
    }

    // Function that stores all the numbers from 1-100, then moves them to another array, which is the return value
    public static int[] GetValues(int max, int min) { 
        
        // The length has to be max + 1 because that should be the total length of the array, not max + min - logic error
        int length = max + min; 
        //              ^ logic error        

        // Checks if the array size is less than 0, and if it is, it will return a null value
        if (length < 0) {  
            return null;
        }

        // Creating an int array called arr with a size of length
        int[] arr = new int[length];  

        // This for loop goes through 0 - length and stores it in the array at the index (numbers 1 - 100)
        for (int i = 0; i < length; i++) { 
            arr[i] = i; 
        }

        return arr; // returns the arr at the end of the function
    }
}
