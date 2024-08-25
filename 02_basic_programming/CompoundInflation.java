import java.util.Scanner;

public class CompoundInflation {
    public static void main(String[] args) {
        // complete this function to solve the problem
        Scanner scn = new Scanner(System.in);

        System.out.println("Please enter your monthly savings rate:");
        String savingsS = scn.nextLine();

        double savings = Double.parseDouble(savingsS);
        // Display the equivalent value of the account, in today’s dollars, after the
        // sixth month of savings mixed with heavy inflation. Assume a 0.9% monthly
        // inflation rate.

        double value = savings * Math.pow((1 - 0.009), 6);

        System.out.println("If you save $" + (int) savings
                + " per month with 0.9% monthly inflation, after 6 months, your account will hold an amount equivalent to $"
                + (int) Math.round(value) + " today.");

    }
}