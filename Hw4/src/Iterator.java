/**Iterator Interface*/
public interface Iterator <E>{

	/**Return next element of structure*/
	public E next();
	
	/**Check for the there is a element to return */
	public boolean hasNext();
	
	/**Removing the last returned element in structure*/
	public E remove();
	
	/**Setting the last returned element in structure*/
	public E set(E data);
	
}
