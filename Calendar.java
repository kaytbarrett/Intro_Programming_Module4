/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #4 (Part 1)
 * 
 * References used for this assignment: 
 * getStartDay.java
 * Google (only to find out what qualifies a leap year)
 */

import java.util.Scanner;

public class Calendar {
    public static void main (String [] args)
    {
        // Declare and initialize variables for month and year
        int m = 0;
        int y = 0;

        // Declare and initialize a scanner for use input
        Scanner input = new Scanner(System.in);

        // Prompt the user for a month and year, put those input values into m and y
        System.out.println("Please enter a month (1 - 12) followed by a year (ex: 10 1998): ");
        m = input.nextInt();
        y = input.nextInt();

        // Call the function printMonthCalender and pass the arguments of month and year
        printMonthCalendar(m, y);

        // Close scanner
        input.close();
    }

    public static void printMonthCalendar(int m, int y)
    {
        // Set day always equal to 1
        int d = 1;

        // Call the getStartDay method to get the day of the week that this month/year starts on
        int startDay = getStartDay(m, d, y);

        // Call the getNumDaysInMonth method to get the number of days in that month
        int numDaysInMonth = getNumDaysInMonth(m, y);

        // Print out the Month Header and Body, with some extra spacing with new lines
        System.out.println("\n");
        printMonthHeader(m, y);
        printMonthBody(startDay, numDaysInMonth);
        System.out.println("\n\n");
    }

    public static int getStartDay( int m, int d, int y )
    {
        // Adjust month number & year to fit Zeller's numbering system
        if (m < 3) 
        {
            m = m + 12;
            y = y - 1;
        }
        
        int k = y % 100;      // Calculate year within century
        int j = y / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month 'm'
        
        h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
            ( 5 * j ) ) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ( ( h + 5 ) % 7 ) + 1;     
        
        return dayNum;
    }

    
    public static void printMonthHeader(int m, int y)
    {
        // Get the string of the month Name to print in the header with the year
        String monthName = getMonthName(m);
        System.out.println("\t" + monthName + " " + y);
        System.out.println("-----------------------------");
    }

    public static void printMonthBody(int startDay, int numDaysInMonth)
    {
        // Print out the days of the week
        System.out.print(" Sun Mon Tue Wed Thu Fri Sat");
        System.out.println();

        // Declare and initialize a variable called spacing to keep track of spacing for a new line
        int spacing = 0;

        // Print blank spaces for week days that come before the start day
        if (startDay == 7 )
        {
            // Do nothing, this is Sun so that is really day 1 of our calendar
        } else 
        {
            // Create blank spaces with no number
            for (int j = 0; j < startDay; j++)
            {
                System.out.print("    ");
                spacing++;
            }
        }
        
        // Print out each day of the month under the correct weekday
        for (int i = 1; i <= numDaysInMonth; i++)
        {
            // Create a new line if we get to the end of the week
            if (spacing % 7 == 0 && spacing != 0) {
                System.out.println();
            }

            // Print out the correct day with the correct spacing
            if (i < 10) {
                System.out.print("   " + i );
            } else {
                System.out.print("  " + i );
            }
    
            spacing++;
        }
    }

    public static String getMonthName(int m)
    {
        // Get the month name using a switch statement for months 1-12
        String monthName = "None";
        switch (m) {
            case 1: monthName = "January";
                    break;
            case 2: monthName = "February";
                    break;
            case 3: monthName = "March";
                    break;
            case 4: monthName = "April";
                    break;
            case 5: monthName = "May";
                    break;
            case 6: monthName = "June";
                    break;
            case 7: monthName = "July";
                    break;
            case 8: monthName = "August";
                    break;
            case 9: monthName = "September";
                    break;
            case 10: monthName = "October";
                    break;
            case 11: monthName = "November";
                    break;
            case 12: monthName = "December";
                    break;
        }

        return monthName;
    }

    public static int getNumDaysInMonth( int m, int y)
    {
        // Declare and initialize the number of days in a month
        int numDaysInMonth = 0;
        // Call the isLeapYear method to determine if the input year is leap or not
        boolean isLeapYear = isLeapYear(y);

        // Determine the number of days in the month based on month and whether or not it's a leap year
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        {
            numDaysInMonth = 31;
        } else if ( m == 4 || m == 6 || m == 9 || m == 11)
        {
            numDaysInMonth = 30;
        } else if ( m == 2 && isLeapYear )
        {
            numDaysInMonth = 29;
        } else if ( m == 2 && !isLeapYear )
        {
            numDaysInMonth = 28;
        }

        return numDaysInMonth;
    }

    public static boolean isLeapYear( int y )
    {
        // Determine if a year is a leap year, return true if it is and false if it is not
        if ( y % 4 == 0 )           // Leap year must be divisible by 4
        {
            if ( y % 100 == 0)      // Leap year must not be divisible by 100 unless it's also divisible by 400
            {
                if ( y % 400 == 0)
                {
                    return true;
                } else 
                {
                    return false;
                }
            } else
            {
                return true;
            }
        } else 
        {
            return false;
        }
    }
}
