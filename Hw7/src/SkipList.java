
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class SkipList<E extends Comparable<E>> implements Iterable<E>{

	
	private Entry<E> head;
	
	private static final int DEFAULT_LEVEL = 2;

	private int maxLevel;
	
	private int numberOfElement;
	
	final static Random rand = new Random();
	static final double LOG2 = Math.log(2.0);
	
	public SkipList() {
		head = new Entry<E>(DEFAULT_LEVEL,null);
		maxLevel = DEFAULT_LEVEL;
		numberOfElement = 0;
	}
	
	@SuppressWarnings("unchecked")
	private Entry<E>[] search(E e){
		Entry<E>[] prevs = new Entry[maxLevel];
		Entry<E> iter  = head;
		
		for(int i=iter.links.length-1; i>=0 ; --i) {
			
			while(iter.links[i] != null && iter.links[i].compareTo(new Entry<E>(0, e)) < 0)
				iter = iter.links[i];
			
			prevs[i] = iter;
		}
		return prevs;
	}
	
	public E find(E e) {
		
		Entry<E>[] prevs = search(e);
		if (prevs[0].links[0] != null && prevs[0].links[0].data.compareTo(e) == 0)
			return prevs[0].links[0].data;
		
		return null;
	}
	
	private Entry<E>[] getPrevs(E e) {
		return search(e);
	}
	
    public int logRandom() {
        int r = rand.nextInt(maxLevel);
        int k = (int) (Math.log(r + 1) / LOG2);
        
        if (k > maxLevel - 1) 
            k = maxLevel - 1;
        
        return maxLevel - k;
//      return rand.nextInt(maxLevel)+1;
    }
	
	public boolean insert(E e) {
		
		if(numberOfElement == 0) {
			numberOfElement++;
			addFirst(e);
			return true;
		}
		boolean addR = addInsert(e);
			
		if(addR)
			numberOfElement++;
		if(numberOfElement >= Math.pow(2, maxLevel) - 1)
			levelUp();
		
		return addR;
	}

	private boolean addFirst(E e) {
		
		Entry<E> newNode = new Entry<E>(logRandom(), e);
		
		for(int i=0; i<newNode.links.length; ++i) 
			head.links[i] = newNode;
		
		return true;
	}

	private boolean addInsert(E e) {
		
		Entry<E>[] prevs = getPrevs(e);
		
		if(prevs[0].links[0] != null && prevs[0].links[0].data.compareTo(e) == 0)
			return false;
		
		int randomLevel = logRandom();
		Entry<E> element = new Entry<E>(randomLevel, e);

		for(int i=0; i< randomLevel; ++i) { 
			element.links[i] = prevs[i].links[i];
			prevs[i].links[i] = element;
		}
		
		return true;
	}
	
	private void levelUp() {
		maxLevel += 1;
		
		Entry<E> newHead = new Entry<E>(head.links.length+1,null);
		for(int i=0; i< head.links.length ;++i)
			newHead.links[i] = head.links[i];
		
		head = newHead;
	}

	public E delete(E e) {
		
		Entry<E>[] prevs = getPrevs(e);
		
		if(prevs[0].links[0] != null && prevs[0].links[0].data.compareTo(e) == 0) {
			
			Entry<E> node = prevs[0].links[0];

			for(int i=0; i<node.links.length; ++i) 
				prevs[i].links[i] = prevs[i].links[i].links[i];
			
			return node.data;
		}
		
		return null;
	}
	
	private static class Entry<E extends Comparable<E>> implements Comparable<Entry<E>>{
		
		Entry<E>[] links;
		E data;
		
		@SuppressWarnings("unchecked")
		public Entry(int level,E data) {
			links = (Entry<E>[]) new Entry[level];
			this.data = data;
		}

		@Override
		public int compareTo(SkipList.Entry<E> o) {
			return this.data.compareTo(o.data);
		}
		
		@Override
		public String toString() {
			return "Data: " + data + " Level: " + links.length;
		}
	}
	
	
	private class Iter implements Iterator<E>{
		
		Entry<E> iter;
		E lastReturned;
		int index;
		
		public Iter() {
			iter = head;
			index = 0;
			lastReturned = null;
		}
		
		@Override
		public E remove() {
			if(lastReturned == null)
				throw new NoSuchElementException();
			
			E tmp = delete(lastReturned);
			lastReturned = null;
			return tmp;
		}	
		
		@Override
		public boolean hasNext() {
			return iter.links[0] != null;
		}

		@Override
		public E next() {
			lastReturned = iter.links[0].data;
			iter = iter.links[0];
			index++;
			return lastReturned;
		}
		
	}
	
	private class DesIter implements Iterator<E>{
		
		LinkedList<E> ll = new LinkedList<E>();
		E lastReturned;
		int index;
		
		public DesIter() {
			index = 0;
			Entry<E> iter = head;
			while(iter.links[0] != null) {
				
				ll.add(0, iter.links[0].data);
				iter = iter.links[0];
			}
		}
		
		@Override
		public E remove() {
			if(lastReturned == null)
				throw new NoSuchElementException();
			
			E tmp = delete(lastReturned);
			ll.remove(lastReturned);
			lastReturned = null;
			return tmp;
		}
		
		@Override
		public boolean hasNext() {
			return index < ll.size();
		}

		@Override
		public E next() {
			lastReturned = ll.get(index);
			index++;
			return lastReturned;
		}
		
	}

	public Iterator<E> descendingIterator() {
		return new DesIter();
	}

	public Iterator<E> iterator(){
		return new Iter();
	}
	
	@Override 
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		Entry<E> iter = head;
		sb.append(iter + "\n");
		
		for(int i=0; i<iter.links.length;++i)
			sb.append(i + " -> " + iter.links[i] + "\n");
		
		while(iter.links[0] != null) {
			iter = iter.links[0];
			sb.append(iter + "\n");
			for(int i=0; i<iter.links.length;++i)
				sb.append(i + " -> " + iter.links[i] + "\n");
		}
		
		return sb.toString();
	}
	
}
