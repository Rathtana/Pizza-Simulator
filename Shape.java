import java.awt.*;

/**
 * This is an abstract Shape class that is a Base class for other shape type
 * subclasses. This abstract class cannot be instantiated
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public abstract class Shape implements Cloneable {
    //private instance variables
    private int x;
    private int y;
    private Color color;

    /**
     * A constructor that takes in 3 input and initialize the 3
     * instance variables
     *
     * @param x (int)
     * @param y (int)
     * @param color (Color)
     */
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;

    }

    /**
     * A getter method for instance variable x
     *
     * @return x (int)
     */
    public int getX(){
        return x;
    }

    /**
     * A getter method for instance variable y
     *
     * @return y (int)
     */
    public int getY() {
        return y;
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
     * A setter method for instance variable x
     *
     * @param x (int)
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * A setter method for instance variable y
     *
     * @param y (int)
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * A copy constructor that make an copy of the original object, but
     * with a completely independent reference address
     *
     * @param other (Shape)
     */
    public Shape(Shape other) {
        if (other != null ) {
            Shape that = other;
            this.x = that.x;
            this.y = that.y;
            this.color = that.color;
        }
        else {
            throw new RuntimeException("Shape can't be null");
        }
    }

    /**
     * An abstract getArea method for subclasses to override to calculate and
     * return the area of a specify shape
     *
     * @return area (double)
     */
    public abstract double getArea();

    /**
     * A toString method that returns a string representation of Shape
     *
     * @return String
     */
    public String toString() {
        return "Shape(" + x +"," +y+ ") and color:" +color+ "and area: "
                + getArea();
    }

    /**
     * An abstract draw method for subclasses to override to draw out a specify
     * Shape
     *
     * @param g (Graphic)
     */
    public abstract void draw(Graphics g);

    /**
     * An abstract clone method for subclasses to override to make copy of
     * a specify shape
     *
     * @return Object
     */
    @Override
    public abstract Object clone();
}
