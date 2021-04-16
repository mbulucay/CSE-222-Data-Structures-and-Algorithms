/**<h2>Iterator nested class interface</h2>*/
public interface Iterator <E>{

	/** Returns true if the next method returns a value
	 * */
	boolean hasNext();
	
	/** Returns the next element. If there are no more elements, 
	 * throws the NoSuchElementException
	 * */
	E next();
	
	/** Removes the last element returned by the next method
	 * */
	void remove();
	
}
