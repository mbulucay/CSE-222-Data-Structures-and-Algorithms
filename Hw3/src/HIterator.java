
public interface HIterator <E>{

	public boolean hasNext();

	public ArrayList<E> next();

	public void remove();
	
	public Iterator<E> inIterator();
}
