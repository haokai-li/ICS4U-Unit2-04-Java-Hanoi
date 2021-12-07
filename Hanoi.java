/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Haokai
* @version 1
* @since   2020-12-5
*/

import java.util.Scanner;

/**
* This is the standard "Towers of Hanoi" program.
*/
final class Hanoi {
    /**
    * The string.
    */
    public static final String TOPEG = " to peg ";

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Hanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function finds the index of a number, using Binary Search recursively.
    *
    * @param nOfDisks how many
    * @param startPeg start
    * @param endPeg end
    */
    static void hanoi(final int nOfDisks, final int startPeg,
                             final int endPeg) {
        // This function calculates where the disks should be placed in
        final int pegNumber = 6;
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + TOPEG
                               + endPeg);
        } else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                               + startPeg + TOPEG + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            final int nOfDisks = userInput.nextInt();
            System.out.println();
            if (nOfDisks > 0) {
                // process
                hanoi(nOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (java.util.InputMismatchException errorCode) {
            System.err.print("\nThis is not an integer");
        }
        System.out.println("\nDone.");
    }
}
