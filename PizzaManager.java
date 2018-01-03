import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 * This is the PizzaManager class that allow the user to interact with the
 * Pizza Vending machine Menu.
 *
 * @author Rathtan Duong
 * @version 3/8/17
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
    private ArrayList <Pizza> pizzaList = new ArrayList<>();
    
    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        
        Scanner foo = new Scanner(System.in);
        
        while(true) {
            displayAllPizzas();
            displayInstructions();
            
            
            selection = foo.next().charAt(0);
            
            //According to the user input
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                                addRandomPizza();
                                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                                for(int i =0; i < 100; i++) {
                                    addRandomPizza();
                                }
                                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                                eatSomePizza(foo);
                                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                                sortByPrice();
                                  break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                                 sortBySize();
                                 break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                                  sortByCalories();
                                  break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                                Scanner input = new Scanner(System.in);
                                int cals = input.nextInt();

                                int index = binarySearchByCalories(cals);
                                if(index == -1) {
                                    System.out.println("~~~~~~~~~  No Pizza for the input calories  ~~~~~~~~~~~~");
                                }
                                else {
                                    System.out.println("~~~~~~~~~  Pizza found in index:" + index + "  ~~~~~~~~~~~");
                                }
                                System.out.println();
                                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                                System.exit(0);
                                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * A method that takes in a scanner input and ask for a String
     * in a fraction a/b format. It will take the fraction from the user input
     * and subtract the amount from the remaining pizza at that a specific
     * index. If the remaining becomes a value of 0, it will remove the pizza
     * from the list.
     *
     * @param keys (Scanner)
     */
    private void eatSomePizza(Scanner keys) {
        String fraction = keys.next();
        System.out.println("At which index?");
        int index = keys.nextInt();

        //getting the pizza in the provided index
        Pizza p = (Pizza) pizzaList.get(index);

        String[] myValue = fraction.split("/");

        int numerator = Integer.parseInt(myValue[0]);
        int denominator = Integer.parseInt(myValue[1]);

        //Catching 0 value and remove and pizza from the list
        try {
            p.eatSomePizza(new Fraction(numerator, denominator));
        }
        catch (IllegalArgumentException e) {
            pizzaList.remove(index);
            System.out.println("Pizza at index " + index + " is out!");
            System.out.println();
        }
    }

    /**
     * Add a single random pizza to your pizza list
     */
    private void addRandomPizza() {
        pizzaList.insert(new Pizza(), pizzaList.size());
    }

    /**
     * Display all the pizza that is in your pizza list
     */
    private void displayAllPizzas() {
        System.out.println(pizzaList.toString());
    }

    /**
     * A method that sort the pizza in the list by its price, from cheapest to
     * the most expensive.
     * Uses selection sort to sort the price.
     */
    private void sortByPrice() {
        for(int i = 0; i < pizzaList.size() -1; i++) {
            Pizza minPrice = (Pizza) pizzaList.get(i);

            int indexOfMin = i;

            for(int j = i +1; j < pizzaList.size(); j++) {
                Pizza pizzaToCompare = (Pizza) pizzaList.get(j);

                if(minPrice.compareTo(pizzaToCompare) > 0) {
                    minPrice = pizzaToCompare;
                    indexOfMin = j;
                }
            }
            //swapping the value in the index
            pizzaList.swap(i,indexOfMin);
        }
    }

    /**
     * Sort the pizzaList by its Size (Fraction) from smallest to largest.
     * Uses Selection sort to accomplish this task.
     */
    private void sortBySize() {
        for(int i = 0; i < pizzaList.size()-1; i++) {
            Pizza minSize= (Pizza) pizzaList.get(i);

            int indexOfMin = i;

            for(int j = i + 1; j < pizzaList.size(); j++) {
                Pizza sizeToCompare = (Pizza) pizzaList.get(j);

                if(minSize.compareToBySize(sizeToCompare) > 0) {
                    minSize = sizeToCompare;
                    indexOfMin = j;
                }
            }
            pizzaList.swap(i, indexOfMin);
        }
    }

    /**
     * Sort the pizzaList by its calories from smallest to greater Calories.
     * Uses section sort to accomplish this task.
     */
    private void sortByCalories() {

        //outer loop to shift to next element after you move the min in front
        for (int i = 0; i < pizzaList.size()-1; i++) {
            Pizza minCalories = (Pizza) pizzaList.get(i);


            int indexOfMin = i;

            //go through the list to find the min from a starting point
            for (int j = i + 1; j < pizzaList.size(); j++) {
                //compare with the next index
                Pizza calToCompare = (Pizza) pizzaList.get(j);

                if (minCalories.compareToByCalories(calToCompare) > 0) {
                    minCalories = calToCompare;
                    indexOfMin = j;
                }
            }
                //swap the min to the front
                pizzaList.swap(i, indexOfMin);

        }
    }

    /**
     * A binarySeach method that compares the input value of Calories to the
     * calories in the pizzaList. It will sort the list and compares to the
     * middle value shift right of left when cutting the list in half to compare
     * to the new middle value depending if the middle value is greater or
     * less than the target value.
     *
     * @param cals (int)
     * @return indexFound (int) or -1 if the list doesn't contain that value
     */
    private int binarySearchByCalories(int cals) {
        //sort the list
        sortByCalories();
        //call the recursiveBinaraySearch to do the implementation
        return recursiveBinarySearch(0, pizzaList.size()-1, cals);
    }

    /**
     * A helper method that perform a recursive Binaray Search and returns
     * if the target to find matches in the list.
     *
     * @param start (int) starts at index 0
     * @param last (int) starts at the Last index
     * @param cals (int) the calories value to look for
     * @return indexFound (int) or -1 if nothing was found
     */
    private int recursiveBinarySearch(int start, int last, int cals) {
        int indexFound = 0;

        if (start > last) {
            return -1;
        }
        else {
            int mid = (start + last) / 2;
            Pizza midPizza = (Pizza) pizzaList.get(mid);


            if(midPizza.getCalories() == cals) {
                indexFound = mid;
            }
            else if(midPizza.getCalories() > cals) {
                indexFound = recursiveBinarySearch(start,mid-1,cals);
            }
            else if(midPizza.getCalories() < cals) {
                indexFound =  recursiveBinarySearch(mid +1, last, cals);
            }
        }
        return indexFound;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    /**
     * Output the instruction to the screen that guide user to the purchasing
     * process.
     */
    private void displayInstructions() {
        System.out.println(instructions);
    }

    /**
     * This is the start of the program that allow that use to interact with
     * the functionality of the PizzaManager.
     * Testing the PizzaManager begins with the Start menu.
     * Select different menu to see that all the test works
     *
     * @param args (String[])
     */
    public static void main(String[] args) {
        //Start menu is the testing the Pizza Manager class
        new PizzaManager().start();
    }
}
