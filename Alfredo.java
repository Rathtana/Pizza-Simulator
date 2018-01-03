/**
 * This is an Alfredo class that derive from its Base super class.
 * Contains only static variables because all Alfredo have the same
 * characteristic
 */
public class Alfredo extends Base {
    //3 final default class variables for the Alfredo class
    public static final String DESCRIPTION = "A sauce made with butter, cream, "
                                            + "garlic, and Parmesan cheese.";
    public static final Money COST = new Money(3,20);
    public static final int CALORIES = 450;

    /**
     * A no-arg constructor that calls its super class's constructor and passes
     * in 3 input of the final default class variables
     */
    public Alfredo() {
        super(DESCRIPTION, COST, CALORIES);
    }
}
