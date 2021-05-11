
public class MyInteger {
	private int value;
	
	public MyInteger() {value = 0;}

	public MyInteger(int value) {this.value = value;}
	public MyInteger(Integer value) {this.value = value;}
	
	public MyInteger(MyInteger key) {
		value = key.getValue();
	}

	public int getValue() {return value;}
	
	public void setValue(int value) {this.value = value;}
	
	@Override 
	public int hashCode() {
		return value % 10;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
	
	public boolean equals(MyInteger o) {

		if(o.getValue() == getValue())
			return true;
			
		return false;
	}
	
}
