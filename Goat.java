/**
 * A Goat class that derive from it's Cheese super class.
 * Contains only static variables because all Goat have the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Goat extends Cheese {
    //3 defaults final class variables for the Goat class
    public static final String  DESCRIPTION = "Cheese made from goat's milk";
    public static final Money COST = new Money(2,49);
    public static final int CALORIES = 325;

    /**
     * A no-arg constructor that calls the super class's constructor and
     * initialize it with the final default Goat class variables
     */
    public Goat() {
        super(DESCRIPTION, COST, CALORIES);
    }
}
