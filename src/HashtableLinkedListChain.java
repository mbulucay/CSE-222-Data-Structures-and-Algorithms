import java.util.LinkedList;

public class HashtableLinkedListChain<K,V> implements KWHashMap<K,V>{

	/** The table */
	private LinkedList<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys;
	/** The capacity */
	private static final int CAPACITY = 101;
	/** The maximum load factor */
	private static final double LOAD_THRESHOLD = 3.0;
	
	/**Default Constructor*/
	@SuppressWarnings("unchecked")
	public HashtableLinkedListChain() {
		table = new LinkedList[CAPACITY];
	}
	
	
	/** Contains key value pairs for a hash table. */
	private static class Entry<K, V> {
	/** The key */
		private final K key;
		/** The value */
		private V value;
		
		/** Creates a new key value pair.
		@param key The key
		@param value The value
		*/
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		/** Retrieves the key.
		@return The key
		*/
		public K getKey() {
			return key;
		}
		/** Retrieves the value.
		@return The value
		*/
		public V getValue() {
			return value;
		}
		/** Sets the value.
		@param val The new value
		@return The old value
		*/
		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}
	
		@Override
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}
	
	/** Method get for class HashtableChain.
	@param key The key being sought
	@return The value associated with this key if found;
	otherwise, null
	*/
	@Override
	public V get(Object key) {
		
		int index = key.hashCode() % table.length;
		
		if (index < 0)
			index += table.length;
		if (table[index] == null)
			return null; // key is not in the table.
		
		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.getKey().equals(key))
				return nextItem.getValue();
		}
		// assert: key is not in the table.
		return null;
	}
	
	
	/** Method put for class HashtableChain.
	@post This key value pair is inserted in the
	table and numKeys is incremented. If the key is already
	in the table, its value is changed to the argument
	value and numKeys is not changed.
	@param key The key of item being inserted
	@param value The value for this key
	@return The old value associated with this key if
	found; otherwise, null
	*/
	@Override
	public V put(K key, V value) {
	
		int index = key.hashCode() % table.length;
	
		if (index < 0)
			index += table.length;
		if (table[index] == null) 
			table[index] = new LinkedList<>();
		
		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			// If the search is successful, replace the old value.
			if (nextItem.getKey().equals(key)) {
				// Replace value for this key.
				V oldVal = nextItem.getValue();
				nextItem.setValue(value);
				return oldVal;
			}
		}
		// assert: key is not in the table, add new item.
		table[index].addLast(new Entry<>(key, value));
		numKeys++;
	
		if (numKeys > (LOAD_THRESHOLD * table.length))
			rehash();
	
		return null;
	}
	
	/**Rehash the hash table if the L is reach the defined limit*/
	private void rehash() {
		
		@SuppressWarnings("unchecked")
		LinkedList<Entry<K, V>>[] newTable = new LinkedList[table.length * 2];
			
		for(LinkedList<HashtableLinkedListChain.Entry<K, V>> ll : table) {
			if(ll != null) {
				for(Entry<K, V> e : ll) {
					int index = e.hashCode() % newTable.length;
					
					if(index < 0)	
						index += table.length;
					
					if(newTable[index] == null ) 
						newTable[index] = new LinkedList<>();
					
					newTable[index].addLast(e);
				}
			}
		}
		table = newTable;
	}
	
	/**Removing taking key in the hash map 
	 * @param Object key
	 * @return Value if we find the key in hash map
	 * other wise return null*/
	@Override
	public V remove(Object key) {
		
		int index = key.hashCode() % table.length;
		
		if(index < 0)
			index += table.length;
		
		if(table[index] == null)	return null;
			
		for(Entry<K, V> e:table[index]) {
			if(e.getKey().equals(key)) {
				table[index].remove(e);
				numKeys--;
				return e.getValue();
			}
		}
		return null;
	}
	
	/**If the map is empty return true
	 * other wise return false*/
	@Override
	public boolean isEmpty() {
		return numKeys == 0;
	}

	/**Returning adding number in hash map*/
	@Override
	public int size() {
		return numKeys;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();

		for(LinkedList<HashtableLinkedListChain.Entry<K, V>> ll : table) {
			if(ll != null) {
				strBuild.append("[");
				for(Entry<K, V> e : ll) {
					strBuild.append(e);
				}
				strBuild.append("]\n");
			}
		}
		return strBuild.toString();
	}

}
