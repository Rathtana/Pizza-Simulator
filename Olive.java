import java.awt.*;

/**
 * An Olive class that derive from its super class Vegetable.
 * Contains only static variables because all Olives have the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Olive extends Vegetable {
    //3 defaults final class variables
    public static final String DESCRIPTION = "Olive, a small oval fruit.";
    public static final Money COST = new Money(1,29);
    public static final int CALORIES = 70;

    /**
     * A no-arg constructor that calls the super class's constructor and passes
     * in the 3 final class variables
     */
    public Olive() {
        super(DESCRIPTION, COST, CALORIES);
    }

    /**
     * An Overload constructor that takes in a Color input.
     * Calls the super class's constructor and passes in the 3 final class
     * variables and the color input
     *
     * @param color (Color)
     */
    public Olive(Color color) {
        super(DESCRIPTION, COST, CALORIES, color);
    }
}
