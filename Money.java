/**
 * The Money class is to keep track of payment. Implements Comparable<Money> and
 * Cloneable interfaces.
 *
 * @author Rathtana Duong
 * @version 3/8/17
 */
public class Money implements Comparable <Money>, Cloneable {
    //private instance variables
    private int dollar;
    private int cent;

    /**
     * A class constructor that take in an int input
     * and initialize the dollar instance variable
     * if passed invariants
     *
     * @param dollar type int
     */
    public Money(int dollar) {
        //checking invariants in the setDollar method
        setDollar(dollar);

    }

    /**
     * An overload class constructor that takes in 2 values
     * of input. Both values are int type.
     * This method will initialize the dollar and cent instance
     * variables if passed enforced invariants
     *
     * @param dollar type int
     * @param cent type int
     */
    public Money(int dollar, int cent) {
        //setMoney method to check invariants
        setMoney(dollar, cent);
    }

    /**
     * A getter method for instance variable dollar.
     * This will return the instance variable dollar
     *
     * @return dollar type int
     */
    public int getDollar() {
        return dollar;
    }

    /**
     * A getter method that returns your total money.
     * Total Money is dollar + cent
     *
     * @return money (double)
     */
    public double getMoney() {

        return dollar + (cent / 100.0);
    }

    /**
     * A getter method for instance variable cent.
     * This will return the instance variable cent.
     *
     * @return cent type int
     */
    public int getCent() {
        return cent;
    }

    /**
     * A mutator method for instance variable dollar.
     * The argument value that is passed in must not be negative
     * and also int type
     *
     * @param dollar type int
     * @throws PizzaException  if input value is negative
     */
    public void setDollar(int dollar) {
        if(dollar >= 0) {
            this.dollar = dollar;
        }
        else {
            //throw exception for invalid input
            throw new PizzaException("negative dollar input");
        }
    }

    /**
     * A mutator method for instance variable cent
     * cent input must be between 0 and 99 (inclusive) type int
     *
     * @param cent type int
     * @throws PizzaException Invalid cent
     */
    public void setCent(int cent) {
        //cent must be between 0 and 99 (inclusive)
        if(cent >= 0 && cent <= 99) {
            this.cent = cent;
        }
        else {
            //throw exception for cent value out of range
            throw new PizzaException("Invalid cent input");
        }
    }

    /**
     * A mutator method for instance variable dollar and cent that
     * takes in 2 ints variable type.
     * dollar and cent will be initialized if they pass the enforced invariants
     *
     * @param dollar type int
     * @param cent type int
     */
    public void setMoney(int dollar, int cent) {
        //call the 2 set methods to initialize the variables
        setDollar(dollar);
        setCent(cent);
    }

    /**
     * An add method that add dollars to your initial balance.
     * Takes in an int type variable
     *
     * @param dollar type int
     * @throws PizzaException dollar can't be negative
     */
    public void add(int dollar)  {
        //dollar must be greater than 0
        if(dollar >= 0) {
            this.dollar += dollar;
        }
        else {
            throw new PizzaException("dollars can't be negative");
        }
    }

    /**
     * A private add method that add cent to your initial balance.
     * If the total cent exceeds 99 with the original cent,
     * it will update the dollar amount and set the correct cent values.
     *
     * @param cent type int
     * @throws PizzaException if input value is negative or exceed 99
     */
    private void addCent(int cent) throws IllegalArgumentException {
        //cent must be greater than 0 not exceed  99
        if(cent >= 0 && cent <= 99) {
            //when initial cent + input cent is greater than 99
            if(this.cent + cent  > 99 ) {
                //update the dollar amount
                this.dollar += ((this.cent + cent) / 99);
                //Get the remaining cent after updating the dollar amount
                this.cent = (this.cent + cent) % 99;
            }
            else {
                this.cent += cent;
            }
        }
        else {
            throw new PizzaException("Invalid cent input");
        }
    }

    /**
     * An add method for instance variables dollar and cent
     * that will add on to the initial balance of both int type variables
     *
     * @param dollar type int
     * @param cent type int
     */
    public void add(int dollar, int cent) {
        //call the 2 add methods to check invariants
        add(dollar);
        addCent(cent);

    }

    /**
     * An add method for adding other Money object
     * that contains instance variable dollar and cent
     *
     * throw an IllegalArgumentException when Money input is null
     *
     * @param other type Money
     * @throws PizzaException Money can't be null
     */
    public void add(Money other)  {
        //check to make sure Money is not null
        if(other != null) {
            //Passing values into the to add methods to check invariants
            add(other.dollar, other.cent);
        }
        else {
            throw new PizzaException("Money can't be null");
        }

    }

    /**
     * An equals method that compares between two Money object
     * Object to compare must be instance of Money and not null
     *
     * @param o type Object
     * @return true if the two objects is the same and false otherwise
     */
    public boolean equals(Object o) {
        //Check to make sure object is not null and is Money type
        if(o!= null && o instanceof Money) {
            //Casting object to Money
            Money other = (Money) o;
            //Comparing its attributes
            if(dollar == other.dollar && cent == other.cent) {
                return true;
            }
        }
        return false;
    }

    /**
     * Two String method that returns a string
     * representation of the Money object
     *
     * @return String representation of Money
     */
    public String toString() {
        return "$" + dollar +"." + cent;
    }

    /**
     * A compareTo method that compares the class's Money object to another
     * Money's object. This will compare the current Money's object amount to
     * anther Money object amount to determine which Money object have a higher
     * amount.
     *
     * @param o (Money) Comparable with type parameter <Money>
     * @return (int) 1 (if current amount is greater than the other)
     *              -1 (if current amount is less than the other)
     *               0 (if current amount is equal to the other)
     */
    @Override
    public int compareTo(Money o) {
        if (this.dollar > o.dollar) {
            return 1;
        } else if (this.dollar < o.dollar) {
            return -1;
        }
        //If the dollar amount is the same, compare the cent value
        else {
            if (this.cent > o.cent) {
                return 1;
            } else if (this.cent < o.cent) {
                return -1;
            }
        }
        //both objects are equal
        return 0;
    }

    /**
     * A clone method that invoke the super.clone() inside to check that
     * the object is cloneable. If the object is cloneable, copy the instance
     * variable of the object and generate an independent reference address to
     * to the new copy.
     *
     * @return Object (Use type cast (Money) to invoke this method)
     *         or null(if object is Cloneable)
     */
    @Override
    public Object clone()  {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
