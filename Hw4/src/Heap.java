/**Heap Data  Structure Class*/
public class Heap<E extends Comparable<E>> implements Comparable<Heap<E>>,Iterable<E>{

	private final int CAPACITY;
	private int index;
	
	private E[] heapData;
	private int[] counter;
	
	/**Default constructor default capacity = 2000*/
	@SuppressWarnings("unchecked")
	Heap(){
		CAPACITY = 2000;
		heapData = (E[]) new Comparable[CAPACITY];
		counter = new int[CAPACITY];
		index = 0;
	}
	
	/**Setting constructor as getting wanted capacity*/
	@SuppressWarnings("unchecked")
	Heap(int cap){
		CAPACITY = cap;
		heapData = (E[]) new Comparable[CAPACITY];
		counter = new int[CAPACITY];
		index = 0;
	}
	
	/**Return the number of element in the list*/
	public int getSize() {
		return index;
	}
	
	/**Return the object in heap using index*/
	public E get(int index) {
		if(index >= CAPACITY)
			throw new IndexOutOfBoundsException();
		
		return heapData[index];
	}
	
	/**Finding nth max in the heap*/
	public E findNthMax(int nth){

		Heap<E> h = new Heap<>(CAPACITY);
		for(int i=0; i<index; ++i)
			h.insert(heapData[i]);
		
		//Remove the nth time to find nth max element
		for(int i=0; i<nth; ++i)
			h.remove();
		
		return h.remove();
	}
	
	/**Return the index of data in list*/
	public int indexOf(E data) {
		//Return the first same object index
		for(int i=0; i<index; ++i)
			if(heapData[i].equals(data))
				return i;
		return -1;
	}
	
	/**Removing the element which getting as parameter 
	 * if in the list remove it 
	 * return new occurrence otherwise return minus 1*/
	public int removeData(E _data) {
		
		int index = indexOf(_data);
		if(index != -1) {
			int rest = counter[index];
			removeNthIndex(index);
			return rest == 1 ? 0 : counter[index];
		}
		return -1;
	}
	
	/**Remove the nth of max value according to the heap rule*/
	public E removeNthMax(int nth) {
		E data = findNthMax(nth);
		int idx = indexOf(data);
		return removeNthIndex(idx);
	}
	
	/**Remove the nth of array according to the heap rule*/
	public E removeNthIndex(int idx) {
		
		if(idx >= index || idx < 0)
			return null;
		
		if(counter[idx] > 1) {
			counter[idx]--;
			return heapData[idx];
		}
		
		E data = heapData[idx];
		if(idx == index-1) {
			heapData[idx] = null;
			counter[idx] = 0;
			index--;
			return data;
		}
		
		heapData[idx] = heapData[index-1];
		heapData[index-1] = null;
		counter[idx] = counter[index - 1];
		counter[index - 1] = 0;
		
		moveToUpward(idx);
		moveToDownward(idx);
		index--;
		return data;
	}
	
	/**Setting nth of array according to upward is necessary*/
	private void moveToUpward(int idx) {
		
		int child = idx,
			parent = (idx - 1) / 2;
		
		while(child > 0 && heapData[child].compareTo(heapData[parent]) > 0) {
			
			swap(child,parent);
			child = parent;
			parent = (child - 1) / 2;
		}

	}
	
	/**Setting nth of array according to downward is necessary*/
	private void moveToDownward(int idx) {
		
		int parent = idx,
			lChild = parent * 2 + 1,
			rChild = parent * 2 + 2;
		
		while(true) {
			
			if(lChild >= index-2)
				break;
			
			int maxChild = heapData[lChild].compareTo(heapData[rChild]) > 0 
					? lChild : rChild;
			
			if(heapData[maxChild].compareTo(heapData[parent]) > 0) 
				swap(maxChild,parent);
			else
				break;
			
			parent = maxChild;
			lChild = parent * 2 + 1;
			rChild = parent * 2 + 2;
			
		}
	}
	
	/**Returning true if heap is empty otherwise false*/
	public boolean isEmpty() {
		return index == 0;
	}
	
	/**Returning true if heap is full otherwise false*/
	public boolean isFull() {
		return index == CAPACITY;
	}
	
	/**Swapping in heap queue getting two index as we need to change*/
	private void swap(int index1,int index2) {
		E tmp = heapData[index1];
		heapData[index1] = heapData[index2];
		heapData[index2] = tmp;
		
		int ctmp = counter[index1];
		counter[index1] = counter[index2];
		counter[index2] = ctmp;
	}
	
	/**Merge with another getting heap*/
	public void merge(Heap<E> obj) {
		
		for(int i=0; i<obj.getSize();++i)
			this.insert(obj.get(i));
	}
	
	/**Wrapper Method
	 * Searching element in heap 
	 * if heap has the element return true otherwise false */
	public boolean search(E data) {
		return search(0, data);
	}
	/**Searching element in heap 
	 * if heap has the element return true otherwise false */
	private boolean search(int location,E data) {
		
		if(location >= index || heapData[location].compareTo(data) < 0)
			return false;
		
		if(heapData[location].equals(data))
			return true;
		
		int lChild = location * 2 + 1,
			rChild = location * 2 + 2;

		return search(lChild,data) || search(rChild,data);
	}
	
	/**Wrapper method
	 * Returning occurrence of getting data*/
	public int find(E data) {
		
		return find(0, data);
	}
	/**Returning occurrence of getting data*/
	private int find(Integer location,E data) {

		if(location >= index || heapData[location].compareTo(data) < 0)
			return 0;
		
		if(heapData[location].equals(data))
			return counter[location];
		
		Integer lChild = location * 2 + 1,
				rChild = location * 2 + 2;

		return find(lChild,data) + find(rChild,data);
	}
	
	/**Removing the root of heap and return it*/
	public E remove() {
		
		if(isEmpty())
			return null;
		
		if(counter[0] > 1) {
			counter[0]--;
		}
		else if(counter[0] == 1) {
			
			E tmp = heapData[0];
			heapData[0] = heapData[index-1];
			heapData[index-1] = null;
			counter[0] = counter[index-1];
			counter[index-1] = 0;
			
			int parent = 0;
			int maxChild;
			
			while(true) {
				int lChild = 2 * parent + 1,
					rChild = 2 * parent + 2;
				
				if(lChild >= index-2)	break;
				
				maxChild = heapData[lChild].compareTo(heapData[rChild]) >= 0 
						   ? lChild : rChild;
				if(heapData[parent].compareTo(heapData[maxChild]) < 0)
					swap(parent,maxChild);
				else
					break;
				parent = maxChild;
			} 
			
			index--;
			return tmp;
		}
		return null;
	}
	
	/**Adding new element to heap*/
	public int insert(E data) {
		
		int isExist = indexOf(data);
		if(isExist >= 0) {
			counter[isExist]++;
			return counter[isExist];
		}
		
		if(index == CAPACITY)
			return -1;
		
		heapData[index] = data;
		counter[index]++;
		int parent = (index-1) / 2 ,
			child = index;
		
		while( child != 0 && heapData[child].compareTo(heapData[parent]) > 0) {
			
			swap(child,parent);
			child = parent;
			parent = (child - 1) / 2;
		}
		return counter[index++];
	}
	
	/**Setting element specific location*/
	public E set(int pos,E data) {
		if(pos >= index)
			return null;
		
		E tmp = heapData[pos];
		heapData[pos] = data;

		int parent = pos,
			lChild = parent * 2 + 1,
			rChild = parent * 2 + 2;
		
		while(true) {

			if(lChild >= index-2)
				break;
			
			int maxChild = heapData[lChild].compareTo(heapData[rChild]) > 0 
				? lChild : rChild;
			if(heapData[maxChild].compareTo(heapData[parent]) > 0)
				swap(maxChild,parent);
			else
				break;
			
			parent = maxChild;
			lChild = parent * 2 + 1;
			rChild = parent * 2 + 2;
		}
		
		int child = parent;
			parent = (child - 1) / 2;
		
		while(child > 0 && heapData[parent].compareTo(heapData[child]) < 0) {
			swap(child,parent);
			child = parent;
			parent = (child - 1) / 2;
		}
		
		return tmp;
	}
	
	/**Return the most occurrence element in heap*/
	public E mod(int max) {

		for(int i=0; i<index; ++i)
			if(max == counter[i])
				return heapData[i];

		return null;
	}

	/**Return the most occurrence number*/
	public int maxModNumber() {
		
		int max = counter[0];
		for(int i=0; i<index ; ++i) {
			if(counter[i] > max)
				max = counter[i];
		}
		return max;
	}
	
	/**Iterator class for heap*/
	private class Itr implements Iterator<E>{

		int currentIndex;
		
		public Itr() {
			currentIndex = 0;
		}
		
		/**Returning the next element in heap*/
		@Override
		public E next() {
			currentIndex++;
			return heapData[currentIndex - 1];
		}

		/**If end of the heap return false otherwise true*/
		@Override
		public boolean hasNext() {
			return currentIndex < index;
		}

		/**Removing the last returned element*/
		@Override
		public E remove() {
			if(currentIndex < 0)
				throw new IndexOutOfBoundsException();
			E tmp = heapData[currentIndex - 1];
			removeData(tmp);
			return tmp;
		}
		/**Setting the last return element with new element*/
		@Override
		public E set(E data) {
			return Heap.this.set(currentIndex-1,data);
		}
	}
	
	/**Returning new iterator*/
	@Override
	public Iterator<E> itreator() {
		return new Itr();
	}
	
	/**Printing heap as we want*/
	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append("[");
		for(int i=0; i<index; ++i) {
			strBuild.append("(" + heapData[i] + "," + counter[i] + ")");
			if(i != index - 1)	strBuild.append(",");
		}
		strBuild.append("]");
		return strBuild.toString();
	}

	/**Comparing to heap object*/
	@Override
	public int compareTo(Heap<E> o) {
		
		
		if(this.get(0).compareTo(o.get(0)) > 0)
			return 1;
		else if(this.get(0).compareTo(o.get(0)) < 0)
			return -1;
			
		return 0;
	}
}
