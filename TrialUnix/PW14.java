import java.util.Scanner;

public class PW14 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scn.nextInt();

        for (int i = n - 1; i >= 1; i--) {
            if (n % i == 0) {
                System.out.println(i + " is the largest factor of " + n + ".");
                break;
            }
        }
    }
}