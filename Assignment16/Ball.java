package Assignment16; // Declare the package name

import processing.core.*; // Import all classes from the processing.core package (for PApplet, etc.)
import java.util.Random;  // Import the Random class for generating random numbers

public class Ball { // Define the Ball class
    int x, y, dx, dy, radius; // Declare integer variables for position (x, y), velocity (dx, dy), and radius
    int r, g, b; // Declare integer variables for color components (red, green, blue)

    public Ball(int width, int height) { // Constructor for Ball, takes width and height of the canvas
        Random rand = new Random(); // Create a new Random object for random number generation
        x = width / 2; // Set initial x position to the center of the canvas
        y = height / 2; // Set initial y position to the center of the canvas
        dx = rand.nextInt(-5, 6); // Set dx to a random integer between -5 and 5 (inclusive)
        dy = rand.nextInt(-5, 6); // Set dy to a random integer between -5 and 5 (inclusive)
        radius = rand.nextInt(101); // Set radius to a random integer between 0 and 100 (inclusive)

        // Set random color once
        r = rand.nextInt(256); // Set red component to a random integer between 0 and 255
        g = rand.nextInt(256); // Set green component to a random integer between 0 and 255
        b = rand.nextInt(256); // Set blue component to a random integer between 0 and 255
    }

    public void update() { // Method to update the ball's position
        x += dx; // Increment x position by dx (move horizontally)
        y += dy; // Increment y position by dy (move vertically)
    }

    public void drawBall(PApplet canvas) { // Method to draw the ball on the given PApplet canvas
        canvas.fill(r, g, b);         // Set the fill color for the ball using its RGB values
        canvas.circle(x, y, radius);  // Draw a circle at (x, y) with the specified radius

        // Bounce logic
        if (x - radius <= 0 || x + radius >= canvas.width) { // If the ball hits the left or right edge
            dx = -dx; // Reverse the horizontal direction
        }
        if (y - radius <= 0 || y + radius >= canvas.height) { // If the ball hits the top or bottom edge
            dy = -dy; // Reverse the vertical direction
        }
    }
}
