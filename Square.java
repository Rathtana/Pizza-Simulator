import java.awt.*;

/**
 * This is a Square Class that derive from its base class Shape. For creating
 * square shape.
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Square extends Shape {
    //private instance variable of Square
    private int sideLength;

    /**
     * A constructor that takes in 4 input and calls the super's constructor to
     * initialize it's instance variables. This will also initialize the Square
     * instance variables after the super call.
     *
     * @param x (int)
     * @param y (int)
     * @param sideLength (int)
     * @param color (Color)
     */
    public Square(int x, int y, int sideLength, Color color) {
        super(x,y, color);
        this.sideLength = sideLength;
    }

    /**
     * A getArea method that calculates the area of the square and returns its
     * value.
     *
     * @return are (double)
     */
    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    /**
     * A to String method that returns a string representation of the object
     * Square.
     *
     * @return String
     */
    public String toString() {
        return "Square";
    }

    /**
     * A draw method that was override from the super class to draw the square
     * on the panel
     *
     * @param g (Graphic)
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(getX(),getY(),sideLength,sideLength);
    }

    /**
     * A clone method that makes a copy of an object with a completely
     * independent memory address.
     *
     * @return (Object) (use type cast (Square) to use correctly when return the
     *                   object)
     */
    @Override
    public Object clone() {
        return new Square(getX(),getY(),sideLength,getColor());

    }

}

