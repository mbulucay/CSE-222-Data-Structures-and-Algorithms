/**<h2>Array List and Linked List and  Hybrid List common method</h2>*/
public interface List <E>{
	
	/**<p>Returning size of list</p>*/
	public int getSize();
	
	/**<p>Adding end of list</p>*/
	public boolean add(E anEntry);
	
	/**<p>Removing element in index</p>*/
	public E remove(int index);
	
	/**<p>Returning index of getting parameter</p>*/
	public int indexOf(E e);
}
