/**<h2>Hybrid List Class</h2>*/
public class HybridList <E> implements HIterable<E>,TwoDimensionList<E>{
	
	private final int MAX_NUMBER = 10;
	
	private LinkedList<ArrayList<E>> datas;
	private int elementNumber;
	private int size;
	
	HybridList() {
		datas = null;
		size = 0;
		elementNumber = 0;
	}
	
	public int getSize() {
		return size;
	}
		
	public int getElementNumber() {
		return elementNumber;
	}
	
	public int getMaxNumber() {
		return MAX_NUMBER;
	}
	
	/**Adding element end of the list*/
	public boolean add(E e) {
		if(size == 0)
			addFirst(e);
		else
			addLast(e);
		elementNumber++;
		return true;
	}
	
	/**Adding the first element of HybridList create and LinkList and 
	 * create first element of LinkList it is ArrayList*/
	private void addFirst(E e) {
		datas = new LinkedList<>();
		datas.add(new ArrayList<>());
		datas.get(0).add(e);
		size++;
	}
	
	/**Adding new Element end of the Hybrid List*/
	private void addLast(E e) {
		
		Iterator<ArrayList<E>> listIter = datas.iterator();
		
		while(listIter.hasNext()) {
			ArrayList<E> tmp = listIter.next();
			if(tmp.getSize() < MAX_NUMBER) {
				tmp.add(e);
				return;
			}
		}
		
		datas.add(new ArrayList<>());
		datas.get(size).add(e);
		size++;
	}
	
	/**Return the index of wanted elemnt in Hybrid list
	 * If it not in List return -1*/
	public int indexOf(E e) {
		if(size == 0) return -1;
		HIterator<E> HIter = this.iterator();
		int counter = 0;
		
		while(HIter.hasNext()) {
			Iterator<E> AIter = HIter.next().iterator();
			while(AIter.hasNext()) {
				if(AIter.next().equals(e))
					return counter;
				counter++;
			}
		}
		
		return -1;
	}

	/**Remove index value in Hybrid List*/
	public E remove(int index) {
		if(index > elementNumber)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		
		HIterator<E> HIter = this.iterator();
		for(int i=0; i<index / MAX_NUMBER; ++i) 
			HIter.next();		//To pass ArrayList (index / MAX_NUMBER) time 
		
		Iterator<E> AIter = HIter.next().iterator();
		int nth = index - ((index / MAX_NUMBER) * 10);	// (index / MAX_NUMBER) 67/10 = 6 -> 67-(6*10) = 7
		for(int i=0;i<nth; ++i) 						// we want 7 small step
			AIter.next();		//To pass element using integer specification
				
		E tmp =	AIter.next();
		AIter.remove();
		return tmp;
	}
	
	/**Returning the wanted arrayList as node*/
	public ArrayList<E> get(int index){
		return datas.get(index);
	}

	/**Iterator for Hybrid List*/
	private class HIter implements HIterator<E>{
		
		Iterator<ArrayList<E>> arrIt;
		int index;
		
		HIter() {
			arrIt =  datas.iterator();
			index = 0;
		}
		
		public boolean hasNext() {
			return arrIt.hasNext();
		}

		public ArrayList<E> next() {
			ArrayList<E> tmp = arrIt.next();
			return tmp;
		}
		
		public Iterator<E> inIterator(){
			return datas.get(index).iterator();
		}

		public void remove() {
			datas.remove(datas.get(--index));
		}
		
	}
	
	@Override
	public HIterator<E> iterator() {
		return new HIter();
	}
	
	public String toString() {
		
		StringBuilder sBuilder = new StringBuilder();
		int counter = 0;
		if(size == 0)
			return "Empty";
		
		Iterator<ArrayList<E>> iter = datas.iterator();
		
		while(iter.hasNext()) {
			
			Iterator<E> iter2 = iter.next().iterator();
			while(iter2.hasNext())  
				sBuilder.append(Integer.toString(counter++) + " > " + iter2.next() + "\n");
		}

		return sBuilder.toString();
	}

}
