
public interface NavigableSetSkipListInterface<E extends Comparable<E>> {
	
	public boolean insert(E e);
	
	public E delete(E e);
	
	Iterator<E> descendingIterator();
}
