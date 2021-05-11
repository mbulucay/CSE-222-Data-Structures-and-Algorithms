import java.util.TreeSet;

public class HashtableTreeSetChain<K extends Comparable<K>,V> implements KWHashMap<K,V>{

	/** The table */
	private TreeSet<Entry<K, V>>[] table;
	/** The number of keys */
	private int numKeys = 0;
	/** The capacity */
	private static final int CAPACITY = 11;
	/** The maximum load factor */
	private static final double LOAD_THRESHOLD = 4.0;
	
	/**Default Constructor*/
	@SuppressWarnings("unchecked")
	public HashtableTreeSetChain() {
		table = new TreeSet[CAPACITY];
	}
	
	/** Contains key value pairs for a hash table. */
	private static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>>{
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
		
		public boolean equals(Entry<K,V> e) {
			if(getKey().equals(e.getKey()))
				return true;
			return false;
		}
	
		@Override
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
		@Override
		public int compareTo(HashtableTreeSetChain.Entry<K, V> o) {
			return key.compareTo(o.getKey());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		
		K nkey = (K) key;
		
		int index = nkey.hashCode() % table.length;		//arrange index
		if(index < 0)
			index += table.length;
		
		if(table[index] == null)	return null;
		
		//Comparing tree element one by one
		for(Entry<K, V> e : table[index]) {
			if(e.equals(new Entry<K,V>(nkey, null))) 
				return e.getValue();
		}
		return null;
	}
	
	/** Method put for class HashtableTreeChain.
	 * The map if already in map we change the value
	 * if it is not in the map adding new element the map
	 * according to the hash location*/
	@Override
	public V put(K key, V value) {
		
		K nkey = (K) key;
		int index = nkey.hashCode() % table.length;
		
		if(index < 0)	
			index += table.length;
		
		if(table[index] == null)			//If the location is free assign it new Tree Set
			table[index] = new TreeSet<>();
		
		for(Entry<K, V> e: table[index]) {
			if(e.getKey().equals(nkey)) {		//Compare If already exist in the tree
				V oldVal = e.getValue();
				e.setValue(value);
				return oldVal;
			}
		}
		
		table[index].add(new Entry<>(key, value));		//Add as new entry
		numKeys++;
		
		if (numKeys > (LOAD_THRESHOLD * table.length))	//Checking the load Factor
			rehash();
		
		return value;
	}
	
	/**Rehash the hash table if the L is reach the defined limit*/
	private void rehash() {
		@SuppressWarnings("unchecked")
		TreeSet<Entry<K, V>>[] newTreeSet = new TreeSet[table.length * 2];
		
		for(TreeSet<Entry<K, V>> trs : table) {
			if(trs != null) {
				for(Entry<K, V> e : trs) {
					int index = e.getKey().hashCode() % newTreeSet.length;
					
					if(index < 0)	
						index += table.length;
					
					if(newTreeSet[index] == null)
						newTreeSet[index] = new TreeSet<>();
					
					newTreeSet[index].add(e);
				}
			}
			
		}
		table = newTreeSet;
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
		
		for(Entry<K, V> e :table[index]) {		//Compare the tree element to find removing element
			if(e.getKey().equals(key)) {
				table[index].remove(e);
				numKeys--;
				return e.getValue();		//If we find it returning removed key value
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
		
		for(TreeSet<Entry<K, V>> treeSet : table) {
			if(treeSet != null) {
				strBuild.append("[");
				for(Entry<K, V> e : treeSet) 
					strBuild.append(e);
				
				strBuild.append("]\n");
			}
		}
		return strBuild.toString();
	}

	
}
