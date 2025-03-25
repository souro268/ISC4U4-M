package Assignment7;

public class Constructor {
    
    
    int Month;
    int Year; 
    int Day;
    String temp;
    String strDay;
    String strMonth;
    
    private int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    /*
     *  0: (not used)
     *  1: January   31
     *  2: February   28/29
     *  3: March   31
     *  4: April   30
     *  5: May    31
     *  6: June   30
     *  7: July    31
     *  8: August   31
     *  9: September  30
     * 10: October   31
     * 11: November 30
     * 12: December  31
     */
    private String[] arrMonth = {"", "January", "February", "March", "April", "May", "June", 
        "July", "August", "Septemer", "October", "November", "December"};




    public Constructor( int intDay, int intMonth, int intYear){
        
        // 28,2,2025

        Month = intMonth;
        Year = intYear;
        Day = intDay;          

        

        if(Month == arr[1] || Month == arr[3] || Month == arr[5] || Month == arr[7] || Month == arr[8] || Month == arr[10] || Month == arr[12]){
            if(Day > 31){
                Day = -1;
            }
        } else if(Month == arr[4] || Month == arr[6] || Month == arr[9] || Month == arr[11]){
            if(Day > 30){
                Day = -1;
            }
        } else if(Month == arr[2]){
            if(Year % 4 == 0 && Year % 100 != 0 || Year % 400 == 0){
                if(Day > 29){
                    Day = -1;
                }
            } else {
                if(Day > 28){
                    Day = -1;
                }
            }
        }

        if(Day < 10){
            strDay = "0" + Day;
        } 


        if(intMonth >12){
            Month = -1;
        }


    }
    public Constructor() {
        this(1, 1, 2000); // Default to January 1st, 2000
    }

    public void getShortDate(){
        
    
        if(Day == -1){
            System.out.println("Invalid date Please try again");
        }
        else if(Month == -1){
            System.out.println("Invalid month Please try again");
        }
        else {
            if(Month < 10)
                strMonth = "0" + Month;
                System.out.println(strDay + "/" + strMonth + "/" + Year);
        }
        
    }

    public void getLongDate(){

        if(Day == -1){
            System.out.println("Invalid date Please try again");
        }
        else if(Month == -1){
            System.out.println("Invalid month Please try again");
        }
        else{
        
            if(Day == 1){
                temp = arrMonth[Month] + " " + strDay + "st, " + Year;
            }
            else if(Day == 2){
                temp = arrMonth[Month] + " " + strDay + "nd, " + Year;
            }
            else if(Day == 3){
                temp = arrMonth[Month] + " " + strDay + "rd, " + Year;
            }
            else{
                temp = arrMonth[Month] + " " + strDay + "th, " + Year;
            }
            System.out.println(temp);
        
        }
        
    }
}


