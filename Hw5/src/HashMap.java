import java.util.Map;
import java.util.NoSuchElementException;

public class HashMap<K,V> extends java.util.HashMap<K, V> implements MapIterable<K,V>{
	
	private static final long serialVersionUID = 1L;
	
	/**Default Constructor*/
	public HashMap() {}

	/**Hash map node*/
	@SuppressWarnings("hiding")
	class Node<K,V> implements Map.Entry<K,V>{
		private K key;
		private V value;
		
		public Node(K _key,V _value) {
			key = _key;
			value = _value;
		}
		
		@Override
		public K getKey() {
			return key;
		}
		@Override
		public V getValue() {
			return value;
		}
		@Override
		public V setValue(V value) {
			V tmp = this.value;
			this.value = value;
			return tmp;
		}
		
		@Override
		public String toString() {
			return getKey() + " = " + getValue();
		}
	}
	
	private class Iterator implements MapIterator<K, V>{
		
		/**Entries table*/
		private Node<K,V>[] entries;
		/**Position of iterator location*/
		private int current;
		/**Starting position of iterator*/
		private int start;
		/**Number of elemnt in hash table*/
		private int size;
		
		/**Default Iterator Constructor*/
		@SuppressWarnings({ "unchecked" })
		public Iterator() {
			start = current = 0;
			size = entrySet().toArray().length;
			entries = new Node[size];
			int i=0;
			for(Map.Entry<K, V> entry : entrySet()) {
			     entries[i++] = new Node<K,V>(entry.getKey(),entry.getValue());
			}
		}

		/**Key Constructor*/
		@SuppressWarnings("unchecked")
		public Iterator(K key) {
			start = current = 0;
			size = entrySet().toArray().length;
			entries = new Node[size];
			int i=0;
		
			for(Map.Entry<K, V> entry : entrySet()) {
				Node<K, V> n = new Node<K,V>(entry.getKey(),entry.getValue());
				if(n.getKey().equals(key))
					start = i;
				
				entries[i++] = n;
			}
			
			if(start != 0) 
				shiftArray();
		}
		
		/**Shifting array according to the taken parameter key*/
		@SuppressWarnings("unchecked")
		private void shiftArray() {
			Node<K,V>[] tmp = new Node[size];
			for(int k=0; k<size; ++k) {
				tmp[k] = entries[start % size];
				start++;
			}
			entries = tmp;
		}
		
		/**Return the next entry in hash map*/
		@Override
		public Map.Entry<K,V> next() {
			if(!hasNext() )
				throw new NoSuchElementException();

			return entries[current++];
		}
		
		/**Return the previous entry in hash map*/
		@Override
		public Map.Entry<K,V> prev() {
			if(!hasPrev())
				throw new NoSuchElementException();

			return entries[--current];
		}
		
		/**Checking the is there an element to return as next*/
		@Override
		public boolean hasNext() {
			
			return  current < size;
		}

		/**Checking the is there an element to return as previous*/
		@Override
		public boolean hasPrev() {
			return current > 0;
		}
		
	}

	/**No parameter default iterator creator*/
	@Override
	public MapIterator<K, V> MapIterator() {
		return new Iterator();
	}
	
	/**Key parameter iterator creator*/
	@Override
	public MapIterator<K, V> MapIterator(K key) {
		
		return new Iterator(key);
	}
	
}


