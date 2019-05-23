package homework6;

import java.util.HashMap;

public class PersonDataHashMap<K, V> extends HashMap<K, V> {
	private Entry<K,V>[] people;
	//k is the name
	//v is the person value 
	
	private int capacity;
/**
 * 
 * @param length
 * @param d
 */
	public PersonDataHashMap(int length, double d) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
