package edu.nyu.cs.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A program to analyze the use of verbal tics in any transcribed text.
 * Complete the functions to perform the tasks indicated in the comments.
 * Refer to the README.md file for additional requirements and helpful hints.
 */
public class TextAnalysis {
    // use this "global"-ish Scanner variable when getting keyboard input from the
    // user within any function; this avoids common problems using several different
    // Scanners within different functions
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The main function is automatically called first in a Java program.
     * This function contains the main logic of the program that makes use of all
     * the other functions to solve the problem.
     * This main function MUST make use of the other functions to perform the tasks
     * those functions are designed for, i.e.:
     * - you must use the getFilepathFromUser() to get the file path to the text
     * file that the user wants to analyze
     * - you must use the getContentsOfFile() function whenever you need to get the
     * contents of the text file
     * - you must use the getTicsFromUser() function whenever you need to get the
     * set of tics the user wants to analyze in the text
     * - you must use the countOccurrences() function whenever you want to count the
     * number of occurrences of a given tic within the text
     * - you must use the calculatePercentage() function whenever you want to
     * calculate the percentage of all tics in the text that a given tic consumes
     * - you must use the calculateTicDensity() function to calculate the proportion
     * of all words in the text that are tic words
     *
     * @param args An array of any command-line arguments.
     */
    public static void main(String[] args) throws Exception {

        String filePath = getFilepathFromUser();
        String file = getContentsOfFile(filePath);
        String[] ticsList = getTicsFromUser();

        System.out.println("\n...............................Analyzing text.................................\n");
        // total number of tics
        int totalTics = totalTicCount(ticsList, file);
        System.out.println("Total number of Tics: " + totalTics);

        // density
        double density = calculateTicDensity(ticsList, file);
        System.out.println("Density of tics: " + density);

        System.out.println("\n...............................Tic breakdown..................................\n");
        // countOccurences for a GIVEN tic... + percentage
        // percentage
        for (String tic : ticsList) {
            int occurrences = countOccurrences(tic, file);
            System.out.print(tic + "      / " + occurrences);
            System.out.print("          / "); // give space, next percentage!

            int percentage = calculatePercentage(occurrences, totalTics);
            System.out.print(percentage + "% of all tics");
            System.out.print("\n");
        }

    }

    /**
     * getFilepathFromUser method
     * Asks the user to enter the path to the text file they want to analyze.
     * Hint:
     * - use the "global"-ish Scanner variable scn to get the response from the
     * user, rather than creating a new Scanner variable ithin this function.
     * - do not close the "global"-ish Scanner so that you can use it in other
     * functions
     *
     * @return The file path that the user enters, e.g.
     *         "trump_speech_010621.txt"
     */
    public static String getFilepathFromUser() {
        // complete the getFilepathFromUser function according to the instructions above
        System.out.println("What file would you like to open?");
        String fPath = scanner.nextLine();

        return fPath; // replace this line by the actual return
    }

    /**
     * getContentsOfFile method
     * Opens the specified file and returns the text therein.
     * If the file can't be opened, print out the message,
     * "Oh no... can't find the file!"
     *
     * @param filename The path to a text file containing a speech transcript with
     *                 verbal tics in it.
     * @return The full text in the file as a String.
     */
    public static String getContentsOfFile(String filepath) {
        // the code in this function is given to you as a gift... don't change it.

        String fullText = "";
        // opening up a file may fail if the file is not there, so use try/catch to
        // protect against such errors
        try {
            // try to open the file and extract its contents
            Scanner scn = new Scanner(new File(filepath));
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                fullText += line + "\n"; // nextLine() removes line breaks, so add them back in
            }
            scn.close(); // be nice and close the Scanner
        } catch (FileNotFoundException e) {
            // in case we fail to open the file, output a friendly message.
            System.out.println("Oh no... can't find the file!");
        }
        return fullText.toLowerCase(); // return the full text
    }

    /**
     * getTicsFromUser method
     * Asks the user to enter a comma-separated list of tics, e.g. "uh,like, um,
     * so", and returns an array containing those tics, e.g. { "uh", "like",
     * "um", "so" }. You don't need to care about the repeated words, just
     * seperate them all.
     * 
     * Hint:
     * - use the "global"-ish Scanner variable scn to get the response from the
     * user, rather than creating a new Scanner variable within this function.
     * - do not close the "global"-ish Scanner so that you can use it in other
     * functions
     * 
     * Notice: Never trust users! The input could have many dummy commas and spaces
     * such as ",,, ,,,, ,,,, , , , , , , ". Return a String array with size = 0
     * when there is no word in the input.
     *
     * @return A String array containing each of the tics to analyze, with any
     *         leading or trailing whitespace removed from each tic.
     */

    public static String[] getTicsFromUser() {
        System.out.println("What words would you like to look for?");
        String ticsList = scanner.nextLine();
        String[] ticsArraySpace = ticsList.split("[, ]"); // DO I ONLY SEPARATE BY COMMAS OR BY SPACE TOO?

        // this is not gonna be efficient
        int countTics = 0; // use to ensure they put tics in
        for (int i = 0; i < ticsArraySpace.length; i++) { // iterate through each item in array and remove space

            if (ticsArraySpace[i].trim() != "") // if there is a word
                countTics++;
        }

        String[] ticsArray = new String[countTics];
        int j = 0; // will use this to iterate through ticsArraySpace

        for (int i = 0; i < ticsArray.length; i++) { // iterate through each item in array and remove space, making new
                                                     // array
            for (; j < ticsArraySpace.length;) {
                if (ticsArraySpace[j].trim() != "") {
                    ticsArray[i] = ticsArraySpace[j].trim();
                    j++;
                    break;
                } else
                    j++; // this is not proper code.... but it works
            }

        }

        if (countTics == 0) {
            String[] empty = new String[0];
            ticsArray = empty;
        }

        return ticsArray;
    }

    /**
     * countOccurrences method
     * Counts how many times a given string (the needle) occurs within another
     * string (the haystack), ignoring case.
     * 
     * Notice: Please use a for loop to count the token number. And there could
     * be a tricky bug during you implement this function, make sure your code
     * will not get into the for loop when the input is null or "". when the
     * input is "" or null, return 0.
     *
     * @param needle   The String to search for.
     * @param haystack The String within which to search.
     * @return THe number of occurrences of the "needle" String within the
     *         "haystack" String, ignoring case.
     */

    public static int countOccurrences(String needle, String haystack) {
        int count = 0;

        String[] haystackArray = haystack.split("[ ,.!?\n\t]");
        for (String item : haystackArray) {
            if (needle.equals("")) // exit because there is no word!
                break;
            if (item.equalsIgnoreCase(needle))
                count++;
        }

        return count;
    }

    /**
     * calculatePercentage method
     * Calculates the equivalent percentage from the proportion of one number to
     * another number.
     *
     * @param num1 The number to be converted to a percentage. i.e. the numerator in
     *             the ratio of num1 to num2.
     * @param num2 The overall number out of which the num1 number is taken. i.e.
     *             the denominator in the ratio of num1 to num2.
     * @return The percentage that rum1 represents out of the total of num2, rounded
     *         to the nearest integer.
     */

    public static int calculatePercentage(double num1, double num2) {
        double PercentageD = ((num1 / num2) * 100);
        int Percentage = (int) Math.round(PercentageD); // rounds to closest integer
        return Percentage;
    }

    /**
     * calculateTicDensity method
     * Calculates the "density" of tics in the text. In other words, the proportion
     * of tic words to the total number of words in a text.
     * Hint:
     * - assume that words in the text are separated from one another by any of the
     * following characters: space ( ), line break (\n), tab (\t), period (.), comma
     * (,), question mark (?), or exclamation mark (!)
     * - all Strings have a .split() method which can split by any of a collection
     * of characters given as an argument; This function returns an array of the
     * remaining text that was separated by any of those characters
     * - e.g. "foo-bar;baz.bum".split("[-;.]+") will result in an array with {
     * "foo", "bar", "baz", and "bum" } as the values.
     * 
     * Notice: the input text could be "", which means you might divide by 0. In
     * that case, return 0.0 and print a message "the text is empty! return 0.0".
     * 
     * Also, take care of the case that the input is null.
     *
     * @param tics     An array of tic words to analyze.
     * @param fullText The full text.
     * @return The proportion of the number of tic words present in the text to the
     *         total number of words in the text, as a double.
     */

    public static double calculateTicDensity(String[] tics, String fullText) {
        if (fullText.equals("")) {
            System.out.println("warning: the text is empty! return 0.0");
            return 0.0;
        }
        if (tics.length == 0) {
            System.out.println("you gave no tics! return 0.0");
            return 0.0;
        }

        String[] fullTextArray = fullText.split("[ .,?!\n\t]");

        int countTic = 0;
        int countDenom = 0;
        for (String item1 : tics) {
            for (String item2 : fullTextArray) { // DO I NEED TO IGNORE CASE????????
                if (item1.equalsIgnoreCase(item2)) {
                    countTic++;
                }
            }
        }

        for (String item2 : fullTextArray) { // don't want empty strings
            if (!item2.equals("")) { // need to countDenom separately or else I'd be double-counting!!!
                countDenom++;
            }
        }

        // density
        double density = (double) countTic / countDenom;
        /// ROUND TO THE hundreths PLACE
        String roundedDensityString = String.format("%.2f", density);
        Double roundedDensity = Double.parseDouble(roundedDensityString);

        return roundedDensity;
    }

    /**
     * totalTicCount method
     * Given a String fullText and a String array tics, compute the total number of
     * tics in fullText.
     * 
     * @param tics
     * @param fullText
     * @return
     */
    public static int totalTicCount(String[] tics, String fullText) {
        int count = 0;
        String[] fullTextArray = fullText.split("[ .,?!\n\t]");

        for (String item1 : tics) {
            for (String item2 : fullTextArray) { // DO I NEED TO IGNORE CASE????????
                if (item1.equalsIgnoreCase(item2)) {
                    count++;
                }
            }
        }
        return count;
    }

} // end of class