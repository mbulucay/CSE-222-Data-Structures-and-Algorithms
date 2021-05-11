
public interface KWHashMap <K, V>{
	
	/**Getting key value from hash map*/
	public V get(Object key);
	
	/**If hash map is empty return true
	 * other wise false*/
	public boolean isEmpty();
	
	/**Putting new element the hash map
	 * if already in map just change the value
	 * if it is not in map adding new element as new node*/
	public V put(K key, V value);
	
	/**Removing key from hash map 
	 * and return the value
	 * if it is not in map return null*/
	public V remove(Object key);
	
	/**Return the added key in map*/
	public int size();
}
