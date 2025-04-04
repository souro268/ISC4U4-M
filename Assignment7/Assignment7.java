
package Assignment7;

public class Assignment7 {



    public static void main(String[] args) throws Exception 
    {

        //Here's how we might use the Date class
        //This object represents today's day, March 20th, 2025
        Date today = new Date(28,2,2024);

        //Let's also create a default one; January 1st, 2000
        Date defaultDate = new Date();

        //Display both dates in short format
        System.out.println(today.getShortDate());        // 20/03/2025
        System.out.println(defaultDate.getShortDate());  // 01/01/2000

        //Display both dates in long format
        System.out.println(today.getLongDate());        // March 20, 2025
        System.out.println(defaultDate.getLongDate());  // January 1, 2000
    }
}
