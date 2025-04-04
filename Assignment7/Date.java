package Assignment7;

public class Date {

    // Variables to store day, month, and year
    private int Month;
    private int Year; 
    private int Day;

    // Temporary variables for formatting the date as a string
    private String temp;
    private String strDay;
    private String strMonth;

    // Array of valid month numbers (1-12)
    private int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    /*
     *  Mapping months to their number of days
     *  Used later to check if the date is valid
     */
    private String[] arrMonth = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // Constructor that takes day, month, and year as input
    public Date(int intDay, int intMonth, int intYear) throws Exception {
        
        // Set month, year, and day
        Month = intMonth;
        Year = intYear;
        Day = intDay;          

        // Check if month is within valid range (1-12)
        if (Month < 1 || Month > 12) {
            throw new Exception("Month is not valid");
        }

        // Check if the given day is valid for the corresponding month
        if (Month == arr[0] || Month == arr[2] || Month == arr[4] || Month == arr[6] ||
            Month == arr[7] || Month == arr[9] || Month == arr[11]) {
            // Months with 31 days
            if (Day > 31) {
                throw new Exception("Date is not valid for given month and/or year");
            }
        } else if (Month == arr[3] || Month == arr[5] || Month == arr[8] || Month == arr[10]) {
            // Months with 30 days
            if (Day > 30) {
                throw new Exception("Date is not valid for given month and/or year");
            }
        } else if (Month == arr[1]) {
            // February (check leap year)
            if (Year % 4 == 0 && Year % 100 != 0 || Year % 400 == 0) {
                // Leap year: February has 29 days
                if (Day > 29) {
                    throw new Exception("Date is not valid for given month and/or year");
                }
            } else {
                // Non-leap year: February has 28 days
                if (Day > 28) {
                    throw new Exception("Date is not valid for given month and/or year");
                }
            }
        }

        // Format day as two-digit string (e.g., 01, 02, ..., 31)
        if (Day < 10) {
            strDay = "0" + Day;
        } else {
            strDay = String.valueOf(Day);
        }

        // Format month as two-digit string (e.g., 01, 02, ..., 12)
        if (Month < 10) {
            strMonth = "0" + Month;
        } else {
            strMonth = String.valueOf(Month);
        }
    }

    // Default constructor: sets date to January 1, 2000
    public Date() throws Exception {
        this(1, 1, 2000);
    }

    // Returns the date in short format (DD/MM/YYYY)
    public String getShortDate() throws Exception {
        temp = strDay + "/" + strMonth + "/" + Year;
        return temp;
    }

    // Returns the date in long format (Month Day, Year)
    public String getLongDate() {
        temp = arrMonth[Month - 1] + " " + Day + ", " + Year;
        return temp;
    }
}
