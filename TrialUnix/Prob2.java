import java.util.Scanner;

public class Prob2 {
    public static boolean userChoice() {
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine();
        String trimmed = input.trim();
        if (trimmed.equals("yes"))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(userChoice());
    }
}