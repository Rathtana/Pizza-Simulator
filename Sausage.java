/**
 * A Sausage class that derive from its super class Meat.
 * Contains only static variables because all Sausages have the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Sausage extends Meat {
    //3 final default class variables for the Sausage class
    public final static String DESCRIPTION = "Minced and seasoned meat";
    public final static Money COST = new Money(3,29);
    public final static int CALORIES = 200;

    /**
     * A no-arg constructor that calls the super class's constructor and passing
     * in 3 the default class variables of the Sausage class to initialize it.
     */
    public Sausage() {
        super(DESCRIPTION, COST, CALORIES);
    }
}
