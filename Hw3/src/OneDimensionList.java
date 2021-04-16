/**<h2>Array List and Linked List common method</h2>*/
public interface OneDimensionList <E> extends List<E>{

	public E get(int index);
	
	public E set(int index, E newValue);
	
	public void add(int index, E anEntry);
}
