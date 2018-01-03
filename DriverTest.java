import java.awt.*;

/**
 * This is a driver class that test all of the methods in all the other classes
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class DriverTest {
    /**
     * The Start of the program that begins the Testing.
     *
     * @param args (String[])
     */
    public static void main(String[] args) {
        /**
         * Uncomment to test the ingredient classes from top to bottom
         */
        //ingredientTest();
        //ingredientSubclass();
        //vegetableSubclass();
        //theBottomMostSubclasses();

        /**
         * Uncomment to Test other Classes
         */
        //arrayList();
        //circle();
        //square();
        //fraction();
        //money();
        //pizza();
    }

    /**
     * Testing the Ingredient Class
     */
    public static void ingredientTest() {
        Ingredient i = new Ingredient("Abc", new Money(1, 22), 22);
        Ingredient j = new Ingredient("Abc", new Money(1, 22), 22);
        Ingredient k = new Ingredient("Abc", new Money(2, 22), 22);
        Ingredient l = new Ingredient("Abc", new Money(1, 10), 22);

        //Testing 2 string methods
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);

        //Testing the compareTo method to compare the COST
        System.out.println(i.compareTo(j));
        System.out.println(i.compareTo(k));
        System.out.println(i.compareTo(l));

        //Testing the equal method
        System.out.println(i.equals(j));
        System.out.println(i.equals(k));

    }

    /**
     * Only Testing the Base subclass because the other 2 subclass besides
     * the vegetable are identical!
     */
    public static void ingredientSubclass() {
        //Object for Base
        Base a = new Base("ABC", new Money(5, 22), 30);
        Base b = new Base("ABC", new Money(5, 22), 30);
        Base c = new Base("ABC", new Money(10, 22), 30);
        Base d = new Base("ABC", new Money(1, 22), 30);

        //Testing the toString method
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        //Testing compareTo method that compare the cost
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(a.compareTo(d));

        //Testing equals method
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

    }

    /**
     * Testing the Vegetable class
     */
    public static void vegetableSubclass() {
        //Object for Vegetable
        Vegetable a = new Vegetable("ABC", new Money(1, 22), 30);
        Vegetable b = new Vegetable("ABC", new Money(5, 22), 30);
        Vegetable c = new Vegetable("ABC", new Money(10, 22), 30);
        //Calling the overload constructor
        Vegetable d = new Vegetable("ABC", new Money(1, 22), 30, Color.green);

        //Testing the toString method
        System.out.println(a);
        System.out.println(d);

        //Setting color for object a
        a.setColor(Color.green);

        //Getter method for Color
        System.out.println(a.getColor());

        //Checking the equals method
        System.out.println(a.equals(d));
        System.out.println(a.equals(c));

    }

    /**
     * Testing the bottom most subclasses for Ingredient
     */
    public static void theBottomMostSubclasses() {
        //Testing out every objects in the bottom most hierarchy
        Mozzarella m = new Mozzarella();
        Goat g = new Goat();
        Pepperoni p = new Pepperoni();
        Sausage s = new Sausage();
        Marinara mar = new Marinara();
        Alfredo f = new Alfredo();
        Pepper pep = new Pepper();
        Olive o = new Olive();

        //2 special cases for the 2 Vegetable
        Pepper pepper = new Pepper(Color.green);
        Olive olive = new Olive(Color.BLACK);


        //Printing out the object to make sure they are correct
        System.out.println(m);
        System.out.println(g);
        System.out.println(p);
        System.out.println(s);
        System.out.println(mar);
        System.out.println(f);
        System.out.println(pep);
        System.out.println(o);

        //Printing out the 2 Vegetable given it's color
        System.out.println(pepper);
        System.out.println(olive);
    }

    /**
     * Testing the ArrayList class
     */
    public static void arrayList() {
        //Creating 3 objects of ArrayList typed for comparison
        ArrayList <Integer> a = new ArrayList<>();
        ArrayList <Integer> b = new ArrayList<>();
        ArrayList <Integer> c = new ArrayList<>();

        //Insert values for object a
        a.insert(1, 0);
        a.insert(2,0);
        a.insert(3, 2);
        a.insert(4,3);


        System.out.println(a.indexOff(4));

        //Insert values for object b
        b.insert(1, 0);
        b.insert(2,0);

        //Insert values for object c
        c.insert(4, 0);
        c.insert(2,1);


        //Calling toString to check that the object has been added using the push method
        System.out.println("Object \"a\" contains: ");
        System.out.println(a.toString());

        //Testing the swap method
        a.swap(0 ,3);

        System.out.println("Swap index 0 and 3");
        System.out.println(a);

        System.out.println();

        System.out.println("Object \"b\" contains: ");
        System.out.println(b);
        System.out.println("Object \"c\" contains: " );
        System.out.println(c);

        //Comparing if object a is equal to object b
        //Should return true in this case since they both are equal
        System.out.println("Object a = b: " + a.equals(b));

        //Comparing if object a is equal to c
        //Should return false in this case
        System.out.println("Object a = c: " + a.equals(c));

        //Calling toString for object a to confirm that the object shifted to make room
        System.out.println("Object \"a\" ArrayList contains: ");
        System.out.println(a);

        //getting the size of object a. Should return 2
        System.out.println("Object \"a\" ArrayList size: " + a.size());

        //calling the indexOff method. should return -1 since object c doesn't exist
        System.out.println("Index of object 1: " + a.indexOff(1));

        //calling the indexOff method. Should return the correct index (1 in this case) of where the object exist
        System.out.println("Index of object B: " + a.indexOff(2));

        System.out.println();

        //Removing all the object until is is empty
        while(!a.isEmpty()) {
            //Notice how the object shifted as you remove an object from the list
            System.out.println("Object \"a\" ArrayList contains: ");
            System.out.println(a.toString());
            System.out.println("Removing value at index 0: " + a.remove(0));
        }
        //getting the new updated size. Should be 0 since all the object has been removed
        System.out.println("Object \"a\" ArrayList size: " + a.size());

        //Should return true now since all of the objects has been removed.
        System.out.println("Object a is Empty now: " + a.isEmpty());


    }

    /**
     * Testing the circle class
     */
    public static void circle() {
        Circle c = new Circle(1,1,10,Color.green);

        //Testing toString for circle object
        System.out.println(c);

        //Getting the radius of the clircle
        System.out.println(c.getRadius());

        //setting radius for circle
        c.setRadius(1);

        //getting the area of the circle
        System.out.println(c.getArea());

        //testing the clone method
        Circle e = (Circle) c.clone();

        //check to see if the clone method returns a deep copy
        System.out.println(e == c);

    }

    /**
     * Testing the Square Class
     */
    public static void square() {
        Square s = new Square(1,1,10,Color.green);

        //check toString method
        System.out.println(s);

        //getting the area
        System.out.println(s.getArea());

        //Cloning method
        Square a = (Square) s.clone();

        //checking to see if clone returns a deep copy
        System.out.println(s == a);
    }

    /**
     * Testing the fraction class
     */
    public static void fraction() {
        Fraction f = new Fraction(6,3);
        Fraction a = new Fraction(1,1);

        //checking toString to see that it perform gcd
        System.out.println(f);

        //getValue of the fraction
        System.out.println(f.getValue());

        //calling the copy constructor
        Fraction e = new Fraction(f);

        //checking to see that it returns a deep copy
        System.out.println(e == f);

        //Checking the equals method
        System.out.println(f.equals(a));
        System.out.println(f.equals(e));

        //checking the compareTo method
        System.out.println(f.compareTo(a));
        System.out.println(f.compareTo(e));
        System.out.println(f.compareTo(new Fraction(10,1)));

    }

    /**
     * Testing the money class
     */
    public static void money() {
        //Construct some money
        Money money1 = new Money(10);

        //Creating object with the overload constructor
        Money money3 = new Money(5, 99);

        System.out.println("Money test starts here!");

        /**
         * Testing all of the methods that throw an exception in the Bill Class
         */
        //Testing and Catching exception for input out of range
        //using setMoney to test because it calls both the set dollar and
        //set cent to test invariants
        try {
            money3.setMoney(-2, 100);
        } catch (IllegalArgumentException e) {
            System.out.println(".");
        }

        //Testing and Catching exception for add method
        try {
            money3.add(-4);
        } catch (IllegalArgumentException e) {
            System.out.println(".");
        }

        //testing and catching excpetion for addMoney method
        //Adding null to see if the method throw an exception
        try {
            money3.add(null);
        } catch (IllegalArgumentException e) {
            System.out.println(".");
        }

        //Testing the Clone method
        Money money2 = (Money) money1.clone();

        System.out.println("money2 clone money1.");
        System.out.print("money2 == money1: ");
        //comparing reference
        System.out.println(money1 == money2);

        //invoking the compareTo method
        System.out.println("money1.compareTo(money3): " + money1.compareTo(money3));

        //Continue testing the methods normally with correct input
        System.out.println("Money 3 is: " + money3.toString());
        System.out.println("getMoney() for money3: " + money3.getMoney());
        System.out.println();

        //Calling the toString to check that the copy constructor behave properly
        System.out.println("money1 and money2 should be both $10.0");
        System.out.println(money1.toString());
        System.out.println(money2.toString());

        //Comparing money1 to money2 should return true in
        //this case since they are the same
        System.out.println("money1 is equal to money2: "
                + money1.equals(money2));

        System.out.println();
        System.out.println("Setting money1 to $30.50");
        //calling the setMoney method to set new values
        money1.setMoney(30, 50);
        System.out.println(money1.toString());

        //Adding dollar, cent, and adding other money object
        System.out.println();
        System.out.println("Adding $1.60 to to 30.50");
        money1.add(1, 60);
        System.out.println(money1.toString());
        System.out.println("Adding 5 dollar");
        money1.add(5);
        System.out.println(money1.toString());
        System.out.println("Getting current dollar value: "
                + money1.getDollar());
        System.out.println("Getting current cent value: " + money1.getCent());
        System.out.println("Adding money2 that contains $10");
        money1.add(money2);
        System.out.println(money1.toString());
        System.out.println("-------------------------------------------------");
        System.out.println();

    }

    /**
     * Testing the Pizza Class
     */
    public static void pizza() {
        //Construct pizza object calling setShape and initialize all of the
        //instance variables
        Pizza p = new Pizza();

        //toString method
        System.out.println(p);

        //getting the fraction
        System.out.println(p.getFraction());

        //getting the Cost
        System.out.println(p.getCost());

        //getting the Calories
        System.out.println(p.getCalories());

        //getting the remaining area
        System.out.println(p.getRemainingArea());

        //getting the shape
        System.out.println(p.getShape());

        //setRemaining Method, cost, and area should change accordingly
        p.setRemaining(new Fraction(1, 2));

        System.out.println(p);

        //getting the remaining
        System.out.println(p.getRemaining());

        //adding an ingredient, cost and, calories should change
        p.addIngredient(new Pepperoni());

        System.out.println(p);

        //eatSomePizza method that changing the fraction remaining, reamingArea,
        // Cost, Money
        p.eatSomePizza(new Fraction(1,5));

        System.out.println(p);

        //creating another random pizza
        Pizza a = new Pizza();

        System.out.println(a);

        //comparing the COST
        System.out.println(p.compareTo(a));

        //comparing the Size of the Pizza
        System.out.println(p.compareToBySize(a));

        //comparing by Calories
        System.out.println(p.compareToByCalories(a));



    }
}
