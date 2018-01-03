/**
 * The Base class derived from its Ingredient super class.
 * This is a base Class for Pizza sauce.
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Base extends Ingredient {

    /**
     * A constructor that takes 3 input and calls the super's constructor to
     * initialize it's instance variables
     *
     * @param description (String)
     * @param cost (Money)
     * @param calories (int)
     */
    public Base(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
}
