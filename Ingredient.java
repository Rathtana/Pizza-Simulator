/**
 * This is an Ingredient super class that is the top of the hierarchy.
 * It contains 3 final attributes DESCRIPTION, COST, and CALORIES.
 * Ingredient implements Comparable <Money> (type cast Money)
 *
 * @author Rathtana Duong
 * @version 2/8/17
 */
public class Ingredient implements Comparable {
    //3 final instances variables that is initialize during the creation of
    //the object in the constructor
    public final String DESCRIPTION;
    public final Money COST;
    public final int CALORIES;

    /**
     * A Constructor that accepts 3 input and initialize them to the final
     * instance variables
     *
     * @param description (String)
     * @param cost (Money)
     * @param calories (int)
     */
    public Ingredient(String description, Money cost, int calories) {
        this.DESCRIPTION = description;
        this.COST = (Money) cost.clone();
        this.CALORIES = calories;

    }

    /**
     * A compareTo method that compares the cost of the Ingredient.
     * Invoke the compareTo method in the Money class to compare the prince.
     *
     * @param o (Money)
     * @return (int) 1 (if current amount is greater than the other)
     *              -1 (if current amount is less than the other)
     *               0 (if current amount is equal to the other)
     */
    @Override
    public int compareTo(Object o) {
        if (o != null && o instanceof Ingredient) {

            return COST.compareTo(((Ingredient) o).COST);
        } else {
            throw new PizzaException("un-Comparable object");
        }
    }

    /**
     * An equals method the compares if the current Ingredient is equal to
     * the other Ingredient.
     *
     * @param o (Object)
     * @return true if they are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Ingredient) {
            Ingredient that = (Ingredient) o;
            if (DESCRIPTION.equals(that.DESCRIPTION) &&
                    COST.equals(that.COST) &&
                    CALORIES == that.CALORIES) {
                return true;
            }
        }

        return false;
    }

    /**
     * A toString method that returns a String representation of the Ingredient
     *
     * @return (String)
     */
    public String toString() {
        return "Description:" + DESCRIPTION + ", Cost:" + COST + ", calories:"
                + CALORIES;
    }

}
