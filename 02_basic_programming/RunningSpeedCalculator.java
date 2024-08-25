import java.util.Scanner;

public class RunningSpeedCalculator {
    public static void main(String[] args) {
        double kmPerMile = 1.609344;
        // complete this function to solve the problem
        Scanner scn = new Scanner(System.in);

        System.out.println("How many kilometers did you run?");
        double km = scn.nextDouble();

        System.out.println("How many minutes did it take you?");
        double min = scn.nextDouble();

        double avgSpeed = (km / kmPerMile) / (min / 60);

        System.out.println("Your average speed was " + avgSpeed + " miles per hour.");
    }
}
