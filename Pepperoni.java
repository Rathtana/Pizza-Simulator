/**
 * This is a Pepperoni class that derive from its super class Meat.
 * Contains only static variables because all pepperonis have the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Pepperoni extends Meat {
    //3 final default class variables of Pepperoni
    public static final String DESCRIPTION = "Sausage seasoned with pepper.";
    public static final Money COST = new Money(2,99);
    public static final int CALORIES = 210;

    /**
     * A no-arg constructor that calls the super class's constructor and passes
     * in the 3 default class variables of Pepperoni.
     */
    public Pepperoni() {
        super(DESCRIPTION, COST, CALORIES);
    }
}
