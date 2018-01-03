import java.awt.*;

/**
 * The Vegetable class derive from its super class Ingredient.
 * This is a base class for the different type of vegetable.
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Vegetable extends Ingredient {
    //setting White as a default color to avoid null pointer if no color was
    //initialize during the creation of the object
    private Color color;

    /**
     * A constructor that takes in 3 input and calls the super's constructor to
     * initialize it's instance variables.
     * Instance variable color (Color) will get a default color of White to
     * avoid it being equal to "null" (cause null-pointer when comparing object)
     * when the object has been created.
     *
     * @param description (String)
     * @param cost (Money)
     * @param calories (int)
     */
    public Vegetable(String description, Money cost, int calories) {
        super(description, cost, calories);
        //giving a default color
        this.color = Color.WHITE;
    }

    /**
     * An Overload constructor that takes in 4 input and calls it super
     * constructor to initialize it's instance variables. It then initialize
     * the Vegetable class instance variable color.
     *
     * @param description (String)
     * @param cost (Money)
     * @param calories (int)
     * @param color (Color)
     */
    public Vegetable(String description, Money cost, int calories,Color color) {
        super(description, cost, calories);
        setColor(color);
    }

    /**
     * A setter method for initializing and getting the color variable
     *
     * @param color (Color)
     * @throws IllegalArgumentException (null input)
     */
    public void setColor(Color color) throws IllegalArgumentException {
        if(color != null) {
            this.color = color;
        }
        else {
            throw new IllegalArgumentException("color can't be null");
        }

    }

    /**
     * A getter method for instance variable color
     *
     * @return color (Color)
     */
    public Color getColor() {
        return color;
    }

    /**
     * A to String method that returns a String representation of the ingredient
     * from the super class, and the Color of the vegetable.
     *
     * @return String
     */
    public String toString() {
        return super.toString() + ", Color:" + color;
    }

    /**
     * An equals method that compares the color of the vegetable. If the color
     * of the 2 Vegetables matches, it will then compare the 2 ingredient.
     *
     * @param o (Object)
     * @return true if ingredient and color matches and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(o != null && this.getClass() == o.getClass()) {
            Vegetable v = (Vegetable) o;
            if(this.color.equals(v.getColor())) {
                return super.equals(v);
            }
        }
        return false;
    }
}
