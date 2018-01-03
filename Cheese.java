/**
 * The Cheese class derive from its Ingredient super class.
 * This is a base class for the different type of cheese.
 * Contains only static variables because all Cheeses have the same
 * characteristic
 *
 * @author Rathtana Duong
 * @version 2/8/17
 */
public class Cheese extends Ingredient {

    /**
     * A constructor that takes in  3 input and initialize the variables in
     * the super class by invoking the super's constructor.
     *
     * @param description (String)
     * @param cost (Money)
     * @param calories (int)
     */
    public Cheese(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
}
