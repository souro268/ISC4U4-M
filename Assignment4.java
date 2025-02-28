import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {

        File textFile = new File("Assignment4_Input.txt");
        
        Scanner fileScanner;

        try {

            fileScanner = new Scanner(textFile);
            String string = fileScanner.nextLine();


            String[] strArr = string.split(" "); // Split by spaces
            
            int[] arr = new int[strArr.length]; // Create integer array

            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i]); // Convert to int
            }
            
            FileWriter output = new FileWriter("Assignment4_Output.txt", false);
            
            for(int i = 0; i < arr.length; i+=2){
                String temp = arr[i] + " + " + arr[i+1] + " = " + (arr[i] + arr[i+1]);
                output.write(temp + "\n");

            }

            output.close();
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace(); // Prints full exception details
        }

    }
}
