/**
 * CSS 162, Pizza Manager Project
 * 
 * This interface can do everything the Comparable interface can and more
 * 
 * @author Rathtana Duong
 * @version 3/8/17
 */
public interface PizzaComparable extends Comparable {  
                                        //Example of interface inheritance

	/**
	 * This method is for comparaing the pizza by the price
	 *
	 * @param o (Object)
	 * @return (int)
	 */
	@Override
	public int compareTo(Object o);          //a.k.a compareToByPrice

	/**
	 * Compare by the area size of the Pizza
	 *
	 * @param o Object
	 * @return int
	 */
	public int compareToBySize(Object o);    //a.k.a. compareToByAreaLeft

	/**
	 * Compare by the calories of the Pizza
	 *
	 * @param o Object
	 * @return int
	 */
	public int compareToByCalories(Object o);
	
}
