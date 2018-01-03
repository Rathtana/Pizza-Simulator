import java.awt.*;
import java.util.Random;

/**
 * This is a Pizza class for building you own your own personal pizza with
 * ingredients and stores all the ingredient.
 * This will also keep track of the cost, pizza shape, fraction, and calories
 * when changes are made to the pizza.
 * Pizza implements PizzaComparable for different comparison.
 *
 * @author Rathtana Duonng
 * @version 3/8/17
 */
public class Pizza implements PizzaComparable {
    //private instance variables to keep track off
    private ArrayList<Ingredient> list = new ArrayList<>();
    private int totalCalories;
    private Money totalCost;
    private Shape shape;
    private Fraction fraction;

    /**
     * A no-arg constructor that initializes totalCost, totalCalories, fraction,
     * and generate a random number to build a random pizza with random
     * ingredients and shape.
     */
    public Pizza() {
        fraction = new Fraction(1, 1);
        totalCost = new Money(0, 0);
        totalCalories =0;

        Random rand = new Random();
        //generate either 1 or 2
        int num = rand.nextInt(4);
        switch (num) {
            case 0:
                setShape(new Circle(1, 1, 16, Color.blue));
                addIngredient(new Pepperoni());
                addIngredient(new Marinara());
                addIngredient(new Pepper());
                addIngredient(new Mozzarella());
                break;

            case 1:
                setShape(new Square(1, 1, 29, Color.GRAY));
                addIngredient(new Sausage());
                addIngredient(new Goat());
                addIngredient(new Alfredo());
                addIngredient(new Olive());
                break;

            case 2:
                setShape(new Circle(1, 1, 10, Color.green));
                addIngredient(new Marinara());
                addIngredient(new Sausage());
                addIngredient(new Pepperoni());
                break;

            case 3:
                setShape(new Square(1, 1, 20,Color.orange));
                addIngredient(new Marinara());
                addIngredient(new Olive());
                addIngredient(new Pepper());
                addIngredient(new Goat());

        }
    }

    /**
     * A setRemaining method for setting the fraction size of the Pizza.
     * This will update the totalCost of the pizza depending on the fraction
     * that was set. Fraction must between 0 to 1(excluding 0, including 1).
     * If a fraction is equal to 0, it will throw an exception "0"
     * to notify you that the pizza Manager to remove the pizza from the list.
     *
     * @param fraction (Fraction)
     * @throws IllegalArgumentException (when fraction is = 0)
     * @throws PizzaException (error, null, neg value, etc..)
     */
    public void setRemaining(Fraction fraction) throws IllegalArgumentException{
        //setting remaining must be between 0 to 1
        if (fraction != null &&
                (fraction.getValue() > 0) &&
                fraction.getValue() <= 1) {
            this.fraction = fraction;

            //calculate the new price according to the remaining fraction
            //round the value to 2 decimal places
            double cost = Math.round(totalCost.getMoney() *
                            fraction.getValue() * 100) / 100.0;

            //Convert double to String
            String s = Double.toString(cost);

            //Read from the string to record the value for dol and cent
            int dol = Integer.parseInt(s.substring(0,s.indexOf(".")));
            int cent = Integer.parseInt(s.substring(s.indexOf(".") + 1,
                                                    s.length()));
            //update the new totalCost
            totalCost = new Money(dol,cent);


        }
        //needs to remove the pizza from the list
        else if (fraction != null &&
                fraction.getValue() == 0) {
            throw new IllegalArgumentException("0");
        } else {
            throw new PizzaException("fraction can't be null or neg");
        }
    }

    /**
     * A getter method that return the remaining of the Pizza left
     *
     * @return remaining fraction (Fraction)
     */
    public Fraction getRemaining() {
        return new Fraction(fraction);
    }

    /**
     * A Fraction getter method that returns a copied fraction of the class
     * that is completely independent of the original reference address
     *
     * @return fraction (Fraction)
     */
    public Fraction getFraction() {
        return new Fraction(fraction);
    }

    /**
     * A getCalories method that returns the totalCalories so far for the pizza
     *
     * @return totalCalories (int)
     */
    public int getCalories() {
        return totalCalories;
    }

    /**
     * A getter for totalCost that returns a copy of the current totalCost that
     * is independent from the original
     *
     * @return Money
     */
    public Money getCost() {
        return (Money) totalCost.clone();
    }

    /**
     * A getRemainingArea that returns the area of the pizza with respect to the
     * fraction of the pizza
     *
     * @return area (double)
     */
    public double getRemainingArea() {
        return Math.round(shape.getArea() * fraction.getValue() * 100) / 100.0;
    }

    /**
     * A set Shape method that set a new shape for the pizza. The input shape
     * will be cloned to generate a completely independent address from the
     * original
     *
     * @param s (Shape)
     */
    public void setShape(Shape s) {
        shape = (Shape) s.clone();
    }

    /**
     * A getter method for Shape object that return a clone copy of the current
     * Shape in the class.
     *
     * @return Shape
     */
    public Shape getShape() {
        return (Shape) shape.clone();
    }

    /**
     * An addIngredient method that take in an Ingredient object. When an
     * Ingredient is added, will add to the current calories and cost of the
     * pizza. Every Ingredient that was added will be saved in a list.
     *
     * @param a (Ingredient)
     * @throws PizzaException (null input)
     */
    public void addIngredient(Ingredient a) {
        if (a != null) {
            totalCalories += a.CALORIES;
            totalCost.add(a.COST);
            list.insert(a, list.size());

        }
        else {
            throw new PizzaException("Ingredient can't be null");
        }
    }

    /**
     * An eatSomePizza method that takes in a fraction object to subtract from
     * the current fraction and update a new fraction.
     * Calls the setRemaining() method to set the new fraction.
     *
     * @param amt (Fraction)
     * @throws PizzaException (error input, null, etc..)
     * @throws IllegalArgumentException in setRemaining method that we are using
     *                                  inside. (for fraction is equal to 0)
     *
     */
    public void eatSomePizza(Fraction amt) throws PizzaException {
        if (amt == null) {
            throw new PizzaException("fraction is null");
        } else if (amt.getValue() > this.fraction.getValue() ||
                amt.getValue() < 0) {

            throw new PizzaException("fraction can't be neg");
        } else {
            //subtracting fraction
            int denominator = (int) (fraction.DENOMINATOR * amt.DENOMINATOR);
            int numerator1 = (int) (fraction.NUMERATOR * amt.DENOMINATOR);
            int numerator2 = (int) (amt.NUMERATOR * fraction.DENOMINATOR);
            int newNumerator = numerator1 - numerator2;

            //will also check if fraction is 0 and throw an exception
            setRemaining(new Fraction(newNumerator, denominator));
            }
    }

    /**
     * A compareTo method that takes in an object and checks to make sure that
     * the object is type Pizza in ordered to compare. This will compare the
     * cost for the current pizza to another pizza.
     *
     * @param o (Object)
     * @return (int) 1 if current cost is greater than the other
     *              -1 if current cost is less than the other
     *               0 if the cost are equal
     * @throws IllegalArgumentException (un-comparable object)
     */
    @Override
    public int compareTo(Object o) throws IllegalArgumentException {
        if (o != null && this.getClass() == o.getClass()) {
            Pizza other = (Pizza) o;

            return this.totalCost.compareTo(other.totalCost);
        } else {
            throw new PizzaException("object can't be compared");
        }
    }

    /**
     * A method that compares the size of the pizza by comparing it's
     * remainingArea left to other Pizza remainingArea
     * The input object must be a type Pizza in ordered to compare.
     *
     * @param o (Object)
     * @return (int) 1 if current size is greater than other
     *              -1 if current size is less than other
     *               0 if both size are equal
     * @throws PizzaException (un-comparable object)
     */
    @Override
    public int compareToBySize(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Pizza that = (Pizza) o;
            if(this.getRemainingArea() > that.getRemainingArea()) {
                return 1;
            }
            else if(this.getRemainingArea() < that.getRemainingArea()) {
                return -1;
            }
            else {
                return 0;
            }
        } else {
            throw new PizzaException("object can't be compared");
        }
    }
    /**
     * A compare method that compares the totalCalories of the current Pizza to
     * the other Pizza. Input object must be a typed Pizza to compare.
     *
     * @param o (Object)
     * @return (int) 1 if current calories is greater than other
     *              -1 if current calories is less than other
     *               0 if both calories are equal
     * @throws PizzaException (un-comparable object)
     */
    @Override
    public int compareToByCalories(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Pizza that = (Pizza) o;
            if (this.totalCalories > that.totalCalories) {
                return 1;
            } else if (this.totalCalories < that.totalCalories) {
                return -1;
            } else {
                return 0;
            }
        } else {
            throw new PizzaException("object can't be compared");
        }
    }

    /**
     * A toString method that returns a String representation of the Pizza.
     *
     * @return String description
     */
    public String toString() {

        return "Pizza has a price:" + totalCost + " and calories:" +
                totalCalories + ", Fraction remaining:" + fraction +
                " and area left:" + getRemainingArea() + " and Shape:" +
                shape.toString();
    }
}
