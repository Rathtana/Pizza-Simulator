import java.awt.*;

/**
 * This Circle class derive from its super class Shape. Mainly for creating
 * round shape like circle
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Circle extends Shape {
    //instance variable
    private double radius;
    //class variable
    private static final double PI = 3.14;

    /**
     * A constructor that takes in 4 input and calls the super'construtor
     * and passes in x, y, and color to initialize the Shape.
     * call the setRadius() to initialize the instance variable
     *
     * @param x (int)
     * @param y (int)
     * @param radius (double)
     * @param color (Color)
     */
    public Circle(int x, int y, double radius, Color color) {
        super(x, y, color);
        setRadius(radius);
    }

    /**
     * A getArea method that calculate the area for the circle and return
     * the result.
     *
     * @return area (double)
     */
    @Override
    public double getArea() {
        return PI * (radius * radius);
    }

    /**
     * A draw method that draw the Circle
     *
     * @param g (Graphics)
     */
    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(getX() , getY(), (int) radius/4, (int) radius/4);
        g2d.setColor(Color.pink);


    }

    /**
     * A getter method for instance variable radius
     *
     * @return radius (double)
     */
    public double getRadius() {
        return radius;
    }

    /**
     * A setter method for instance variable radius
     * @throws RuntimeException (neg input)
     * @param radius
     */
    public void setRadius(double radius) {
        if(radius > 0) {
            this.radius = radius;
        }
        else {
            throw new RuntimeException("radius is neg");
        }
    }

    /**
     * A toString method that returns a string representation of the object
     *
     * @return "Circular" (String)
     */
    public String toString() {
        return "Circular";
    }

    /**
     * A clone method that overrides the abstract method in the base class. It
     * will copy the original object and generate a completely independent
     * reference address.
     *
     * Note: Couldn't use the super.clone() in the implementation because it
     * would just refer to the abstract method in this case.
     *
     * @return Object (needs to use the Type cast (Circle) when getting its
     *                return value
     */
    @Override
    public Object clone() {
        return new Circle(super.getX(),super.getY(),radius,getColor());
    }

}
