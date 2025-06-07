package Assignment16; // Declare the package name

import processing.core.*; // Import all classes from the processing.core package (for PApplet, etc.)
import java.util.Scanner; // Import Scanner for user input

public class Main extends PApplet { // Define the Main class, extending PApplet for Processing

    Ball[] newBall; // Declare an array to hold Ball objects
    int num;        // Declare an integer to store the number of balls

    public static void main(String[] args) { // Main method, entry point of the program
        PApplet.main("Assignment16.Main"); // Launch the Processing sketch with the Main class
    }

    public void settings() { // Processing method to set up the canvas size
        size(800, 800); // Set the canvas size to 800x800 pixels
    }

    public void setup() { // Processing setup method, runs once at the start
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input
        System.out.print("Please enter the number of balls you want (Limit 100): "); // Prompt user for number of balls
        num = sc.nextInt(); // Read the integer input from the user
        num = Math.min(num, 100); // Limit the number of balls to a maximum of 100

        newBall = new Ball[num]; // Initialize the Ball array with the specified size
        for (int i = 0; i < num; i++) { // Loop through each index in the array
            newBall[i] = new Ball(width, height); // Create a new Ball object at each index
        }

        sc.close(); // Close the Scanner to free resources
    }

    public void draw() { // Processing draw method, runs continuously in a loop
        background(0); // Set the background color to black
        for (int i = 0; i < num; i++) { // Loop through each Ball in the array
            newBall[i].drawBall(this); // Draw the Ball on the canvas
            newBall[i].update();       // Update the Ball's position
        }
    }
}
