/**
 * This is a fraction class for creating Fraction typed object that contains
 * a Numerator and Denominator.
 * Fraction also implements the comparable interface with type parameter
 * of Fraction
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Fraction implements Comparable <Fraction> {
    //private instance variables for Fraction objects
    public final double NUMERATOR;
    public final double DENOMINATOR;


    /**
     * Fraction Constructor that initialize the two instance variables
     * numerator and denominator. Find the GCD values, and simplify the fraction
     * in the most simplest form before setting it to the 2 final instance
     * variables numerator and denominator
     *
     * @param numerator   (int)
     * @param denominator (int)
     * @throws PizzaException (when input denominator is 0);
     */
    public Fraction(int numerator, int denominator) {

        //won't allow you to set the denominator equal to 0 because dividing by a 0 gives you an error
        if (denominator == 0) {
            throw new PizzaException("denominator can't be 0");
        } else {
            //finding the GCD value depending on num and den
            int gcd = findGCD(numerator, denominator);

            //numerator/gcd and denominator/gcd give a reduced form and initialize them
            numerator = numerator / gcd;
            denominator = denominator / gcd;

            // if they both are negatives
            //Convert them to positive
            if (numerator < 0 && denominator < 0) {
                numerator = Math.abs(numerator);
                denominator = Math.abs(denominator);
            }
            //move the negative sign to the top for comparison reason
            else if (numerator > 0 && denominator < 0) {
                numerator = -numerator;
                denominator = Math.abs(denominator);
            }
            //set the final value for numerator and constructor
            this.NUMERATOR = numerator;
            this.DENOMINATOR = denominator;
        }

    }

    /**
     * A copy Constructor that will make a new copy of the object, but
     * completely independent in memory address
     *
     * @param fraction (Fraction)
     * @throws PizzaException (input fraction can't be null)
     */
    public Fraction(Fraction fraction)  {
        if (fraction == null) {
            throw new PizzaException("fraction can't be null");
        } else {
            this.NUMERATOR = fraction.NUMERATOR;
            this.DENOMINATOR = fraction.DENOMINATOR;
        }
    }

    /**
     * findGCD method take takes in the numerator and denominator as input,
     * and determines the the gcd values that will simplify the fraction.
     *
     * @param n1 (int)
     * @param n2 (int)
     * @return n1 (int) the calculated gcd value
     */
    private int findGCD(int n1, int n2) {
        //n1 and n2 must always be positive for this GCD algorithm
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);

        //continue through the loop if n2 is greater than 0
        while (n2 > 0) {
            int remainder = n1 % n2;
            //n1 will keep track of  the GCD value
            n1 = n2;
            //n2 will keep track of the remainder
            n2 = remainder;
        }
        //setting n1 is the gcd value
        return n1;
    }

    /**
     * A getValue method that calculate and returns the value of the of the
     * fraction object
     *
     * @return fraction value (double)
     */
    public double getValue() {
        return NUMERATOR / DENOMINATOR;
    }

    /**
     * Equal method that compares the class instance with other class object
     *
     * @param other type Object Fraction
     * @return true if the instance object equal to parameter object
     */
    public boolean equals(Fraction other) {
        if (NUMERATOR / DENOMINATOR == other.NUMERATOR / other.DENOMINATOR) {
            return true;
        }
        return false;
    }

    /**
     * ToString method of Fraction class object
     *
     * @return String representation of Fraction object
     */
    @Override
    public String toString() {
        return (int) NUMERATOR + "/" + (int) DENOMINATOR;
    }

    /**
     * A comparable method that compare the current fraction value to other
     * fraction value.
     *
     * @param o (Fraction)
     * @return (int) 1 if current fraction is greater than other
     *              -1 if current fraction is less than other
     *               0 if they both equal
     */
    @Override
    public int compareTo(Fraction o) {
        if (this.getValue() > o.getValue()) {
            return 1;
        } else if (this.getValue() < o.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}

