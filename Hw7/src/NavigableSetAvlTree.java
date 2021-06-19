
public class NavigableSetAvlTree<E extends Comparable<E>> implements NavigableSetAvlTreeInterface<E> {

	private MyAvlTree<E> avlTree = null;
	
	public NavigableSetAvlTree() {
		avlTree = new MyAvlTree<>();
	}
	
	public void inOrder() {
		avlTree.inOrder();
	}
	
	@Override
	public boolean insert(E e) {
		return avlTree.insert(e);
	}

	@Override
	public Iterator<E> iterator() {
		return (Iterator<E>) avlTree.iterator();
	}
	
	/**Implemented in avl tree class*/
	@Override
	public MyAvlTree<E> headSet(E e) {
		return avlTree.headSet(e);
	}
	
	/**Implemented in avl tree class*/
	@Override
	public MyAvlTree<E> tailSet(E e) {
		return avlTree.tailSet(e);
	}
}
