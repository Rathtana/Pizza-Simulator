/**
 * A Mozzarella class that derive from the Cheese super class.
 * Contains only static variables because all Mozzarella has the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Mozzarella extends Cheese {
    //3 default final class variables
    public static final String DESCRIPTION = "White Italian cheese,";
    public static final Money COST = new Money(2, 19);
    public static final int CALORIES = 310;

    /**
     * A no-arg constructor that calls the super class's constructor and
     * initialize with the 3 default class variables
     */
    public Mozzarella() {
        super(DESCRIPTION, COST, CALORIES);
    }
}
