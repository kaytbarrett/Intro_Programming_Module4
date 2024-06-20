/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #4 (Part 2)
 * 
 * References used for this assignment: 
 * getStartDay.java
 * Calendar.java
 */

import java.util.Scanner;

public class YearCalendar {
        public static void main (String [] args)
    {
        // Declare and initialize a variable for the year
        int y = 0;

        // Declare and initialize a scanner for use input
        Scanner input = new Scanner(System.in);

        // Prompt the user for a year and put that input value into y
        System.out.println("Please enter a year (ex: 1998): ");
        y = input.nextInt();

        // Loop through each month of the year and print out that month's calendar
        for (int i = 1; i <= 12; i++ )
        {
            int m = i;
            printMonthCalendar(m, y);
        }

        // Close scanner
        input.close();
    }

    public static void printMonthCalendar(int m, int y)
    {
        int d = 1;
        int startDay = getStartDay(m, d, y);
        int numDaysInMonth = getNumDaysInMonth(m, y);

        System.out.println();
        printMonthHeader(m, y);
        printMonthBody(startDay, numDaysInMonth);
        System.out.println();
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
        String monthName = getMonthName(m);
        System.out.println("\t" + monthName + " " + y);
        System.out.println("-----------------------------");
    }

    public static void printMonthBody(int startDay, int numDaysInMonth)
    {
        System.out.print(" Sun Mon Tue Wed Thu Fri Sat");
        System.out.println();
        int lines = 0;

        if (startDay == 7 )
        {
            // Do nothing
        } else 
        {
            for (int j = 0; j < startDay; j++)
            {
                System.out.print("    ");
                lines++;
            }
        }
        

        for (int i = 1; i <= numDaysInMonth; i++)
        {
            if (lines % 7 == 0 && lines != 0) {
                System.out.println();
            }

            if (i < 10) {
                System.out.print("   " + i );
            } else {
                System.out.print("  " + i );
            }
    
            lines++;
        }
    }

    public static String getMonthName(int m)
    {
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
        int numDaysInMonth = 0;
        boolean isLeapYear = isLeapYear(y);

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
        if ( y % 4 == 0 )
        {
            if ( y % 100 == 0)
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