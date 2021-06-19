
public interface NavigableSetAvlTreeInterface<E extends Comparable<E>> {
	public boolean insert(E e);
	
	 Iterator<E> iterator();
	
	 MyAvlTree<E> headSet(E e);
	
	 MyAvlTree<E> tailSet(E e);
}
