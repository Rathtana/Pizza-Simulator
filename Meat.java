/**
 * The Meat class derive from its Ingredient super class.
 * This is a base class for the different type of meat.
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Meat extends Ingredient {

    /**
     * A constructor that takes in 3 input and calls the super's constructor to
     * initialize it's instance variables.
     *
     * @param description (String)
     * @param cost (Money)
     * @param calories (int)
     */
    public Meat(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
}
