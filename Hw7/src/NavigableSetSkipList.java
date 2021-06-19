
public class NavigableSetSkipList <E extends Comparable<E>> implements NavigableSetSkipListInterface<E>{

	private SkipList<E>  skipList = null;
	
	public NavigableSetSkipList() {
		skipList = new SkipList<>();
	}
	
	@Override
	public boolean insert(E e) {
		return skipList.insert(e);
	}

	@Override
	public E delete(E e) {
		return skipList.delete(e);
	}

	/**Implemented in skiplist class*/
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> descendingIterator() {
		return skipList.descendingIterator();
	}
	
	@Override
	public String toString() {
		return skipList.toString();
	}

}
