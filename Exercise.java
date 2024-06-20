import java.util.Scanner;

public class Exercise 
{
    public static void main ( String [] args )
    {
        int x = 0;
        int y = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("This program sums all integers together within a specified range.");
        System.out.println("Please enter in two integers (ex: 1 6): ");
        x = input.nextInt();
        y = input.nextInt();

        input.close();

       int sumInt = sum(x, y);

       System.out.println(sumInt); 

    }

    public static int sum (int x, int y)
    {
        int sum = 0;

        for (int i = x; i <= y; i++)
        {
            sum += i;
        }

        return sum;
    }
}