package edu.nyu.cs.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A program to play blackjack.
 * 
 */
public class Blackjack {
    /* Do not modify this method */
    public static Random initRandom(String[] args) {
        if (args.length >= 1) {
            return new Random(Long.parseLong(args[0]));
        } else {
            return new Random();
        }
    }

    public static void main(String[] args) throws Exception {
        Random rand = initRandom(args);
        Scanner scn = new Scanner(System.in);

        // variables - keep track of sum but also individual cards
        int userTotal = 0;
        int dealerTotal = 0;
        ArrayList<Integer> userCards = new ArrayList<Integer>();
        ArrayList<Integer> dealerCards = new ArrayList<Integer>();
        boolean repeat;
        boolean gameOver = false;
        String winner = "";

        System.out.println("Welcome to Blackjack!");

        // deal first 2 cards for user and dealer
        userCards.add(rand.nextInt(10) + 2); // random card between 2 and 11
        userCards.add(rand.nextInt(10) + 2);

        dealerCards.add(rand.nextInt(10) + 2);
        dealerCards.add(rand.nextInt(10) + 2);

        // print out user stuff
        do {
            System.out.print("Your cards are: ");
            for (int i = 0; i < userCards.size(); i++) {
                System.out.print(userCards.get(i)); // Fixed punctuation.
                if (i < userCards.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("\nWould you like to hit or stand?");
            String userAns = scn.nextLine();

            if (userAns.equals("hit")) { // do we need to account for invalid input?
                userCards.add(rand.nextInt(10) + 2);
                repeat = true;
            } else
                repeat = false;

            for (int i = 0; i < userCards.size(); i++) {
                userTotal += userCards.get(i);
            }
            if (userTotal > 21) {// check for bust
                System.out.println("You have bust!");
                repeat = false;
                gameOver = true;
                winner = "Dealer";
            }
            userTotal = 0; // reset variable for next round
        } while (repeat == true);

        while (gameOver == false) { // dealer stuff
            if (rand.nextBoolean()) {
                System.out.println("The dealer hits.");
                dealerCards.add(rand.nextInt(10) + 2);
            } else {
                System.out.println("The dealer stands.");
                gameOver = true;
            }
            for (int i = 0; i < dealerCards.size(); i++) { // check total
                dealerTotal += dealerCards.get(i);
            }
            if (dealerTotal > 21) {// check for bust
                System.out.println("The dealer has bust!");
                gameOver = true;
                winner = "User";
            }
            dealerTotal = 0; // reset total
        }

        // display cards afterwards
        System.out.print("Your cards are: ");
        for (int i = 0; i < userCards.size(); i++) {
            System.out.print(userCards.get(i));
            userTotal += userCards.get(i);
            if (i < userCards.size() - 1) { // Fixed punctuation
                System.out.print(", ");
            }
        }
        System.out.print("\nThe dealer's cards are: ");
        for (int i = 0; i < dealerCards.size(); i++) {
            System.out.print(dealerCards.get(i));
            dealerTotal += dealerCards.get(i);
            if (i < dealerCards.size() - 1) { // Fixed punctuation
                System.out.print(", ");
            }
        }

        // win message
        System.out.println("");
        if (!winner.equals("")) {
            if (winner.equals("Dealer"))
                System.out.println("Dealer wins!");
            else
                System.out.println("You win!");
        } else {
            if (dealerTotal > userTotal)
                System.out.println("Dealer wins!");
            else if (userTotal > dealerTotal)
                System.out.println("You win!");
            else
                System.out.println("Tie!");
        }

    }

}
