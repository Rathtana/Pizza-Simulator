import java.awt.*;

/**
 * A Pepper class that derive from its super class Vegetable. Contains static
 * variable because those variable is the same for all Pepper object.
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Pepper extends Vegetable {
    //3 final default class variables
    public static final String DESCRIPTION =  "Pepper, the mild, "
                                            + "ripe fruit of the sweet pepper.";
    public static final Money COST = new Money(1,49);
    public static final int CALORIES = 100;


    /**
     * A no-arg constructor that calls its super class's constructor and passes
     * in the 3 input of final default class variables
     */
    public Pepper() {
        super(DESCRIPTION, COST, CALORIES);
    }

    /**
     * An Overload Constructor that takes in an input of Color.
     * Call the super class's constructor and passes in the 3 default class
     * variables and the color input.
     *
     * @param color (Color)
     */
    public Pepper(Color color) {
        super(DESCRIPTION, COST, CALORIES, color);

    }
}
