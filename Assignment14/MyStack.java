package Assignment14;

public class MyStack implements SimpleStack {

    int[] values;
    int tail;
    int currentSize;

    //Constructor; set up the empty stack
    //capacity indicates the maximum size of the stack 
    public MyStack(int capacity)
    {
        values = new int[capacity];  // Initialize array to hold values up to capacity
        tail = 0;                    // Start with tail at index 0 (no items yet)
        currentSize = 0;             // Initially, the stack is empty
    }

    @Override
    public boolean push(int value) {
        //Check if the stack is full; if so, return false
        //Increase the index of the top of the stack
        //Store the new value at the top of the stack

        
        if(currentSize < values.length - 1){

            tail++;                    // Move to next index
            values[tail] = value;      // Insert the new value
            currentSize++;             // Update the size counter
            return true;               // Successfully added
        }

        return false;  // Stack is full
    }

    @Override
    public int pop() {
        //Check if the stack is empty, if so, return 0
        //Check the value at the top of the stack
        //Reduce the index of the top of the stack by 1
        //Return the value that was at the top of the stack

        
        if(currentSize > 0){
            int num = values[tail];    // Get value at top

            tail--;                    // Move tail down
            currentSize--;            // Decrease size
            return num;               // Return removed value
        }
        return 0;  // Stack is empty
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return currentSize;  //Return current number of items in the stack
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return currentSize == 0;  //checks if the size is empty
    }

}
