import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Assignment5 {
    public static void main(String[] args) {
        try{
            File textFile = new File("Assignment5_input.txt");
            FileWriter output = new FileWriter("Assignment5_Output.txt", false);
            int counter = counters(0, textFile);
            if(counter == 0){
                System.out.println("No valid data found. Please try again with vaild data");
            }
            else{
                String[] Totalarr = total_arr(counter, textFile);
                String[] Name_Arr =  names(counter, Totalarr);
                int[] Grade_Arr = grades(counter, Totalarr);
                
                End(Name_Arr, Grade_Arr, counter, output);

                output.close();
            }

            }catch(IOException e){
                System.out.println("Error: Unable to read/write file. Please try again");
                e.printStackTrace();
            }
        
    }

    public static void End(String[] Name_Arr, int[] Grade_Arr, int counter, FileWriter output){
        int max;
        int min;
        String name_max;
        String name_min;
        double avg;
        double avg_counter = 0.0;
        boolean error_value = false;
        
        bubbleSort(Grade_Arr, Name_Arr);
        
        for(int i = 0; i < Grade_Arr.length; i++){
            if(Grade_Arr[i] < 0){
                error_value = true;
                break;
            }
            avg_counter = avg_counter + Grade_Arr[i];
        }
        
        avg = avg_counter / Grade_Arr.length;
        if(error_value == true){
            System.out.println("Error with the input file formating, please try again");
        }
        else{

            max = Grade_Arr[Grade_Arr.length - 1];
            min = Grade_Arr[0];

            name_max = Name_Arr[Grade_Arr.length - 1];
            name_min = Name_Arr[0];

            String string1 = ("Total Students: " + counter + "\n");
            String string2 = String.format("Average Grade: %.1f", avg);
            String string3 = ("%\n");
            String string4 = ("Highest Grade: " + max + " (" + name_max + ")\n");
            String string5 = ("Lowest Grade: " + min + " (" + name_min + ")");
            try{
                output.write(string1);
                output.write(string2);
                output.write(string3);
                output.write(string4);
                output.write(string5);
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Error with writing to the file, please try again");
            }
            
        }
        
    }

    static void bubbleSort(int grades[], String names[]) {
        int n = grades.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (grades[j] > grades[j + 1]) {
                    // Swap grades
                    int temp = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = temp;
    
                    // Swap corresponding names
                    String temp2 = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp2;
    
                    swapped = true;
                }
            }
            if (!swapped) break; // Exit early if no swaps
        }
    }
    
    public static String[] names(int counter, String[] Totalarr){

        String[] Name_Arr = new String[counter];
        
        for (int i = 0; i < counter; i++) {
            String string = Totalarr[i];
            String[] temp = string.split(" ");
            Name_Arr[i] = temp[0];  // Get the name (first part of the split)
        }
    
        return Name_Arr;
    }

    public static int[] grades(int counter, String[] Totalarr){

        int[] Grade_Arr = new int[counter];
        
        for (int i = 0; i < counter; i++) {
            try{
                String string = Totalarr[i];
                String[] temp = string.split(" ");
                Grade_Arr[i] = Integer.parseInt(temp[1]);
            }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.out.println("Error: Invalid grade format at line " + (i + 1));
                Grade_Arr[i] = -1;
            }          
        
        }
    
        return Grade_Arr;
    }
    public static String[] total_arr(int counter, File textFile){
        String[] arr = new String[counter];
        try{
            Scanner fileScanner = new Scanner(textFile);
            

            for(int i = 0; i < counter; i++){
                String string = fileScanner.nextLine();
                arr[i] = string;
            }
            

            fileScanner.close();

        }catch(Exception e){
            e.printStackTrace();
            
        }
        return arr;
    }

    public static int counters(int counter, File textFile){
        try{ 

            Scanner fileScanner = new Scanner(textFile);
            
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();  // Read each line to count
                counter++;  // Increment line counter
            }
            fileScanner.close();

        }catch(IOException e){
            System.out.println("Error: File not found or cannot be read.");
            e.printStackTrace();
            
        }
        
        return counter;
    }

    public static void printArr(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
        
    
}

