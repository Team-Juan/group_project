package Util;

import java.util.Scanner;

/**
 * This validates that all information entered into the scanner is correct.
 * @author Team-Juan
 * @version 1.0
 */

public class Validator {
	
	/**
	 * Validates the input
	 * @param sc The scanner object
	 * @param prompt The inputted text
	 * @return The formatted string
	 */
    public static String getLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
    
    /**
     * Validates the input with regex
     * @param sc The scanner object
     * @param prompt The inputed text
     * @param regex The regex expected
     * @return The formatted string
     */

    public static String getLine(Scanner sc, String prompt, String regex) {
        boolean isValid = false;
        String s = "";
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextLine()) {
                s = sc.nextLine();
                if (s.matches(regex)) {
                    isValid = true;
                } else {
                    System.out.println("\nError! Invalid value. Try again.\n");
                }
            }
        }
        return s;
    }
    
    /**
     * Validates the inputed integer
     * @param sc The scanner object
     * @param prompt The inputed int
     * @return The formatted int
     */

    public static int getInt(Scanner sc, String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }
    
    /**
     * Validates the inputed integer with a min and max value
     * @param sc The scanner object
     * @param prompt The inputed int
     * @param min The minimum value
     * @param max The maximum value
     * @return
     */

    public static int getInt(Scanner sc, String prompt, int min, int max) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    /**
     * Validates the inputed long
     * @param sc The scanner object
     * @param prompt The inputed long
     * @return The formatted long
     */
    public static long getLong(Scanner sc, String prompt) {
        boolean isValid = false;
        long i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextLong()) {
                i = sc.nextLong();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid long value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }
    
    /**
     * Get the inputed long with a min and a max value
     * @param sc The scanner object
     * @param prompt The inputed long
     * @param min The minimum value
     * @param max The maximum value
     * @return
     */

    public static long getLong(Scanner sc, String prompt, long min, long max) {
        boolean isValid = false;
        long i = 0;
        while (isValid == false) {
            i = getLong(sc, prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }
    
    /**
     * Validates the inputed double
     * @param sc The scanner object
     * @param prompt The inputed double
     * @return The formatted double
     */

    public static double getDouble(Scanner sc, String prompt) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
    
    /**
     * Validates the inputed double
     * @param sc The scanner object
     * @param prompt The inputed double
     * @param min The minimum value
     * @param max The maximum value
     * @return The formatted double
     */

    public static double getDouble(Scanner sc, String prompt, double min, double max) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (d > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
}
