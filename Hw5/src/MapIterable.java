
public interface MapIterable <K,V>{

	MapIterator<K,V> MapIterator();
	
	MapIterator<K,V> MapIterator(K key);
	
}
