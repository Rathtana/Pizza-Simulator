/**
 * A custom PizzaException class the inherit from the RuntimeException.
 *
 * @ Version Rathtana Duong
 * @ Version 3/8/17
 */
public class PizzaException extends RuntimeException {

    /**
     * No-args constructor for PizzaException super class
     * Calling it's super class when the constructor is called
     */
    public PizzaException() {
        super();
    }
    /**
     * Constructs a new runtime exception with the specified detail message.
     *
     * @param   message   the detail message. The detail message is passed to
     *                    the super class for implementation
     */
    public PizzaException(String message) {
        super(message);
    }
}


