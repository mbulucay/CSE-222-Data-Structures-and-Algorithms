import java.util.Arrays;
import java.util.NoSuchElementException;
/**<h2>Array List Class</h2>*/
public class ArrayList<E> implements Iterable<E>,OneDimensionList<E>{

	private static final int INITIAL_CAPACITY = 10;
	/** The underlying data array */
	private E[] theData;
	/** The current size */
	private int size = 0;
	/** The current capacity */
	private int capacity = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}
	
	public int getSize() {
		return size;
	}
	
	/**Adding new element to ArrayList*/
	public boolean add(E anEntry) {
		if (size == capacity) 
			reallocate();
		
		theData[size++] = anEntry;
		return true;
	}
	
	/**Insert the getting element wanted position*/
	public void add(int index, E anEntry) {
		if (index < 0 || index > size) 
			throw new ArrayIndexOutOfBoundsException(index);
		
		if (size == capacity) 
			reallocate();
		
		// Shift data in elements from index to size minus 1
		for (int i = size; i > index; i--) 
			theData[i] = theData[i-1];
		// Insert the new item.
		theData[index++] = anEntry;
		size++;
	}
	
	/**Return the wanted index element*/
	public E get(int index) {
		if (index < 0 || index >= size) 
			throw new ArrayIndexOutOfBoundsException(index);

		return theData[index];
	}
	
	/**Replace the element where we get as parameter in index */
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) 
			throw new ArrayIndexOutOfBoundsException(index);
	
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	/**Remove the element index in Array List and if its need to shift the list*/
	public E remove(int index) {
		if (index < 0 || index >= size) 
			throw new ArrayIndexOutOfBoundsException(index);
		
		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) 
			theData[i - 1] = theData[i];
		
		size--;
		return returnValue;
	}
	
	/**Return the index of e where the same in ArrayList if not in arrayList return -1*/
	public int indexOf(E e) {
		for(int i=0; i<size; ++i) {
			if(get(i).equals(e))
				return i;
		}
		
		return -1;
	}
	
	/**Array Capacity increasing by size*2*/
	private void reallocate() {
		capacity = 2 * capacity;
		theData = Arrays.copyOf(theData, capacity);
	}

	
	private class Iter implements Iterator<E>{
		
		int index;
		int lastRet;
		Iter(){
			index = 0;
			lastRet = -1;
		}
		
		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public E next() {
			if(index >= size)
				throw new NoSuchElementException();
			lastRet++;
			return get(index++);
		}

		@Override
		public void remove() {
			 if (lastRet < 0)
	                throw new IllegalStateException();
			 
			 ArrayList.this.remove(lastRet);
		}

	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}
	
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		
		for(int i=0; i<size; ++i)
			sBuilder.append( i + " > " + theData[i] + "\n");
		
		return sBuilder.toString();
	}
	
}
