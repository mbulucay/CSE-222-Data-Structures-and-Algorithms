import java.util.Map;

public interface MapIterator <K,V>{

	Map.Entry<K,V> next();
	
	Map.Entry<K,V> prev();
	
	boolean hasNext();
	
	boolean hasPrev();
	

}
