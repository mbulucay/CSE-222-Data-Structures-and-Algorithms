
public class CoalescedHashMap <K,V> implements KWHashMap <K, V>{
	
	/**Capacity of hash map*/
	private final int CAPACITY = 10;
	/**Hash table*/
	private Node<K,V>[] table;
	/**Current adding number*/
	private int numsKey = 0;

	/**Default Constructor*/
	@SuppressWarnings("unchecked")
	public CoalescedHashMap() {
		table = new Node[CAPACITY];
	}
	
	/**Node of hash map*/
	private static class Node<K,V>{
		
		/**Pointing index by one before index*/
		private Integer prev;
		/**Key and Value of hash node*/
		private K key;
		private V value;
		/**Pointing next key same hash code*/
		private Integer next1;
		/**Pointing normally must be in location and point the index*/
		private Integer next2;
		
		public Node(K key,V value) {
			this.key = key;
			this.value = value;
			prev = next2 = next1 = null;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public Integer getNext1() {
			return next1;
		}
		
		public Integer getNext2() {
			return next2;
		}
		
		public Integer getPrev() {
			return prev;
		}
	
		private void setKey(K key) {
			this.key = key; 
		}

		public void setValue(V value) {
			this.value = value;
		}
		
		public void setNext1(Integer next) {
			this.next1 = next;
		}
		
		public void setNext2(Integer next) {
			this.next2 = next;
		}
	
		public void setPrev(Integer prev) {
			this.prev = prev;
		}
		
		/**Swapping key of nodes*/
		public void swap(Node<K,V> n) {
			
			K tmpKey = n.getKey();
			this.setKey(tmpKey);
			n.setKey(key);
		}
		
		/**Clear the node*/
		public void clear() {
			key = null;
			next1 = null;
			value = null;
			prev = null;
		}
		
		/**Return the hash code of node*/
		@Override
		public int hashCode() {
			return key.hashCode();
		}
	
	}
	
	/**Adding new element to the hash map
	 * According to the rules of hash code and open hash map*/
	@Override
	public V put(K key,V value) {
		//If the hash map is full return null
		if(numsKey == CAPACITY) {
			System.out.println("Table Full");
			return null;
		}
		
		//Getting index of key
		int index = key.hashCode() ;
		
		if(index < 0)
			index += table.length;
		
		//If simply location is free we add new node and return the value
		if(table[index] == null) { 
			table[index] = new Node<K,V>(key,value);
			numsKey ++;
			return value;
		}
			
		//If the location taken by normally by key like k=13 is index=3  13.hash = 3
		if(table[index].getKey().hashCode() == new Node<K, V>(key,value).hashCode())
			insertSameHashCode(key,value, index);
		else	//If the location taken not same hash like 24 in 5   but 24.hash = 4 in that case we use next2
			insertDifferentHashCode(key,value, index);

		numsKey ++;
		return value;
	}
	
	/**Inserting same hash in map and of the hash queue*/
	private void insertSameHashCode(K key,V value,int index) {
		
		int loc = index;
		for(int i=1,power=1; ;++i,power = i*i) {
			
			//calculate the next index
			loc = (index + power) % table.length;
			if(loc < 0)
				loc += table.length;
			//If we reach the end of hash queue and 
			//not find key in hash map insert the end of list
			if(table[loc] == null || table[loc].getKey() == null) {
				table[loc] = new Node<K,V>(key,value);
				findBeforeLocation(key,loc,power,i);
				return;
			}//If the key already in hash map change the value
			else if(table[loc].getKey().toString().equals(key.toString())) {
				table[loc].setValue(value);
				return;
			}
		}
	}
	
	/**If we want to insert a new element but the location is taken 
	 * another value which has different hash code 
	 * so that we need to add different location and 
	 * we assign the index of inserted to next2 value*/
	private void insertDifferentHashCode(K key,V value,int index) {
		
		if(table[index].getNext2() == null)
			addFirst(key, value, index);
		else 
			addLast(key, value, index);
	}
	
	/**Adding first for next2 value*/
	private void addFirst(K key, V value,int index) {
		
		//Finding new free position 
		int fromBottom = getNextEmptyFromBottom();
		//Setting next 2 of the normally add location
		table[index].setNext2(fromBottom);
		
		table[table[index].getNext2()] = new Node<K,V>(key,value);
	}
	
	/**Adding end of next2 */
	private void addLast(K key, V value,int index) {
		
		int newloc = table[index].getNext2();
		
		for(int i=1,power = 1; ;++i,power = i*i) {
			
			//calculate the next index
			int loc = (newloc + power) % table.length;
			
			// if the key not found and reach the last we insert the end of hash queue
			if(table[loc] == null) {
				table[loc] = new Node<K,V>(key,value);
				findBeforeLocation(key,loc,power,i);
				return;
			}//If the key already in map we chance the value of key
			else if(table[loc].getKey().toString().equals(key.toString())) {
				table[loc].setValue(value);
				return;
			}
		}
	}
	
	/**Finding before index adding same hash value in the hash table*/
	private void findBeforeLocation(K key,int loc,int power,int i) {
		
		for(int j = 1; ;j++) {
			
			//calculate the reverse of location
			int beforeLoc = loc - power + ((i-j) * (i-j)) ;
			
			while(beforeLoc < 0) {
				beforeLoc += table.length ;
				if(beforeLoc > 0) break;
			}
			
			//We are checking hash code and setting next and prev
			if(table[beforeLoc].getKey().hashCode() == new Node<K, V>(key,null).hashCode()) {
				table[loc].setPrev(beforeLoc);
				table[beforeLoc].setNext1((loc));
				break;
			}
		}
	}
	
	
	/**Finding free location in hash map*/
	private int getNextEmptyFromBottom() {
		for(int i=CAPACITY-1; i>=0; --i) {
			if(table[i] == null)
				return i;
		}
		return -1;
	}
	
	
	/**Removing taking key in the hash map 
	 * @param Object key
	 * @return Value if we find the key in hash map
	 * other wise return null*/
	@Override
	@SuppressWarnings("unchecked")
	public V remove(Object key){
		
		K number = (K) key;
		int index = number.hashCode();
		
		if(index < 0)
			index += table.length;
			
		if(table[index] == null)
			return null;
		
		if(table[index].getKey().hashCode() != number.hashCode()) {
			if(table[index].getNext2() == null)
				return null;
			index = table[index].getNext2();
		}
			
		V tmp = nextDeletion((K) key,index);

		if(tmp != null) 
			numsKey--;
		
		return tmp;
	}
	
	
	/**Shifting table when we delete the according to index of 
	 * taking key in hash map*/
	private void shiftTable(int index) {
		
		//Stop the recursive function 
		if(table[index].getNext1() == null) {
			if(table[index].getPrev() != null )
				table[table[index].getPrev()].setNext1(null);
			table[index].clear();
			return;
		}

		//Arrange next index and current index
		int current = index;
		index = table[index].getNext1();
		
		//we look the next of next to check last element remove
		if(table[table[current].getNext1()] == null)
			table[current].setNext1(null);
		
		//swapping current and index of table
		table[current].swap(table[index]);
		
		//Setting next index when we removed
		if(table[index].getNext1() == null)
			table[current].setNext1(null);
		else
			table[current].setNext1(index);
		
		shiftTable(index);
	}
	
	/**Finding the key location in hash map
	 * using next1 index*/
	private V nextDeletion(K key,int index) {
		//If we find delete and shift map
		if(table[index].getKey().toString().equals(key.toString())) {
			V value = table[index].getValue();
			shiftTable(index);
			return value;
		}
		//if we dont find stop recursive
		if(table[index].getNext1() == null) 
			return null;
		
		index = table[index].getNext1();
		return nextDeletion(key,index);
	}

	
	/**Returning value of getting key in hash map
	 * Wrapper method*/
	@Override
	@SuppressWarnings("unchecked")
	public V get(Object key) {
		
		K nkey = (K) key;
		int index = nkey.hashCode();		//location of nkey in hash map
		
		if(table[index] == null)			
			return null;
		
		//If location is taken by another key we are looking for next2 value
		if(table[index].getKey().hashCode() != nkey.hashCode() && table[index].getNext2() != null)
			index = table[index].getNext2();
		
		return get(nkey, index);
	}
	
	/**Return value of key in hash map*/
	private V get(K key, int index) {
		
		if(table[index].getKey().toString().equals(key.toString())) 	//if we find the key return the value
			return table[index].getValue();
		
		if(table[index].getNext1() == null)				//if we dont find the key return null
			return null;
		
		index = table[index].getNext1();				//setting next 
		
		return get(key,index);
	}
	
	/**If the map is empty return true
	 * other wise return false*/
	@Override
	public boolean isEmpty() {
		return numsKey == 0;
	}
	
	/**Returning adding number in hash map*/
	@Override
	public int size() {
		return numsKey;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		
		strBuild.append("\t" + "Prev()" + "\t" + "Key()" + "\t" + "Next1()" + "\t"+ "Next2()" + "\n");
		
		for(int i=0; i<CAPACITY; ++i) {
			
			if(table[i] == null)
				strBuild.append(i +"\t" + null + "\t" + null + "\t" + null + "\t" + null + "\n");
			else
				strBuild.append(i +"\t" + table[i].getPrev() + "\t" + table[i].getKey() + "\t" + table[i].getNext1()+"\t"+ table[i].getNext2() + "\n");
		}
		
		return strBuild.toString();
	}

}


