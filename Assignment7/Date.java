package Assignment7;

public class Date {
    
    
    private int Month;
    private int Year; 
    private int Day;
    private String temp;
    private String strDay;
    private String strMonth;
    
    private int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    /*
     *  0: January   31
     *  1: February   28/29
     *  2: March   31
     *  3: April   30
     *  4: May    31
     *  5: June   30
     *  6: July    31
     *  7: August   31
     *  8: September  30
     *  9: October   31
     *  10: November 30
     *  11: December  31
     */
    private String[] arrMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};




    public Date( int intDay, int intMonth, int intYear) throws Exception{
        
        // 28,2,2025

        Month = intMonth;
        Year = intYear;
        Day = intDay;          

        if (Month < 1 || Month > 12) {
            throw new Exception("Month is not valid");
        }

        if(Month == arr[0] || Month == arr[2] || Month == arr[4] || Month == arr[6] || Month == arr[7] || Month == arr[9] || Month == arr[11]){
            if(Day > 31){
                throw new Exception("Date is not valid for given month and/or year");
            }
        } else if(Month == arr[3] || Month == arr[5] || Month == arr[8] || Month == arr[10]){
            if(Day > 30){
                throw new Exception("Date is not valid for given month and/or year");
            }
        } else if(Month == arr[1]){
            if(Year % 4 == 0 && Year % 100 != 0 || Year % 400 == 0){
                if(Day > 29){
                    throw new Exception("Date is not valid for given month and/or year");
                }
            } else {
                if(Day > 28){
                    throw new Exception("Date is not valid for given month and/or year");
                }
            }
        }

        if (Day < 10) {
            this.strDay = "0" + Day;
        } else {
            this.strDay = String.valueOf(Day);
        }
        
        if (Month < 10) {
            this.strMonth = "0" + this.Month;
        } else {
            this.strMonth = String.valueOf(Month);
        }


    }
    public Date() throws Exception {
        this(1, 1, 2000);
    }
    public String getShortDate() throws Exception{
        
        temp = strDay + "/" + strMonth + "/" + Year;
        return temp;
        
        
    }

    public String getLongDate() {
        this.temp = arrMonth[this.Month-1] + " " + this.Day + ", " + this.Year;
        return temp;
    }
}


