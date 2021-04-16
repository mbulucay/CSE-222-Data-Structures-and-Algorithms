import java.util.NoSuchElementException;
/**<h2>Single Linked List Class</h2>*/
public class LinkedList<E> implements Iterable<E>,OneDimensionList<E>{
	
	/** Reference to list head. */
	private Node<E> head = null;
	/** The number of items in the list */
	private int size = 0;
	
	public int getSize() {
		return size;
	}
	
	/** Add an item to the front of the list.
	*/
	private void addFirst(E item) {
		head = new Node<>(item, head);
	}
	
	/** Add a node after a given node
	*/
	private void addAfter(Node<E> node, E item) {
		node.next = new Node<>(item, node.next);
	}
	
	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if (temp != null) {
			node.next = temp.next;
			size--;
			return temp.data;
		} 
		return null;
	}
	
	/** Remove the first node from the list
	*/
	private E removeFirst() {
		Node<E> temp = head;
		if (head != null) 
			head = head.next;
		// Return data at old head or null if list is empty
		if (temp != null) {
			size--;
			return temp.data;
		}
		return null;
	}
	
	/** Remove the first occurrence of element item.
	*/
	public E remove(E item) {
		if(head.getData().equals(item)) 
			return removeFirst();

		return removeAfter(getNode(indexOf(item)-1));
	}
	
	/** Remove the first occurrence of element item.
	*/
	public E remove(int index) {
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(Integer.toString(index));
			
		if(index == 0)
			return removeFirst();
		
		return removeAfter(getNode(index-1));
	}
	
	/** Find the node at a specified position
	*/
	private Node<E> getNode(int index) {
		Node<E> node = head;
		for (int i = 0; i < index && node != null; i++) 
			node = node.next;
		
		return node;
	}
	
	/** Get the data at index
	*/
	public E get(int index) {
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(Integer.toString(index));
		
		Node<E> node = getNode(index);
		return node.data;
	}
	
	 /** Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.*/
	public int indexOf(E data) {
		Iterator<E> it = this.iterator();
		for(int i=0; it.hasNext() ; ++i)
			if(it.next().equals(data))
				return i;
		
		return -1;
	}
	
	/** Store a reference to anEntry in the element at position index.
	*/
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) 
			throw new IndexOutOfBoundsException(Integer.toString(index));
	
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}

	/** Insert the specified item at index
	*/
	public void add(int index, E item) {
		if (index < 0 || index > size) 
			throw new IndexOutOfBoundsException(Integer.toString(index));
		
		if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
		size++;
	}
	
	/** Append item to the end of the list
	*/
	public boolean add(E item) {
		add(size, item);
		return true;
	}
	
	/** A Node is the building block for a single linked list. */
	private static class Node<E> {
		/** The reference to the data. */
		private E data;
		/** The reference to the next node. */
		private Node<E> next;
		// Constructors
		/** Creates a new node with a null next field.*/
		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}
		/** Creates a new node that references another node.
		*/
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	
		private E getData() {
			return data;
		}
	}
	
	private class Itr implements Iterator<E>{

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        Itr(){
        	next = head;
        	lastReturned = null;
        	nextIndex = 0;
        }
        
		@Override
		public boolean hasNext() {
			return nextIndex < size;
		}

		@Override
		public E next() {
			 if (!hasNext())
	                throw new NoSuchElementException();
			
			 lastReturned = next;
	         next = next.next;
	         nextIndex++;
	         return lastReturned.data;
		}

		@Override
		public void remove() {
			if (lastReturned == null)
                throw new IllegalStateException();
			
			Node<E> lastNext = lastReturned.next;
			
			removeAfter(getNode(nextIndex-2));
		     if (next == lastReturned)
	               next = lastNext;
	         else
	               nextIndex--;
		     lastReturned = null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		
		Node<E> iter = head;
		
		while(iter != null) {
			sBuilder.append(iter.getData().toString() + "\n");
			iter = iter.next;
		}
		
		
		return sBuilder.toString();
	}
	
}
