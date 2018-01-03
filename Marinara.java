/**
 * A Marinara class that derive from its Base super class.
 * Contains only static variables because all Marinara have the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Marinara extends Base {
    //3 final default class variables for the Marinara class
    public static final String DESCRIPTION = "Italian sauce made with tomatoes,"
                                            + " garlic, herbs, and onion";
    public static final Money COST = new Money(2,99);
    public static final int CALORIES = 445;

    /**
     * A no-arg constructor that calls the super class's constructor that takes
     * in 3 input from the final default class variables.
     */
    public Marinara() {
        super(DESCRIPTION, COST, CALORIES);
    }
}
