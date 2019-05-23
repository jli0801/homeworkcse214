package extracredit1;

import java.util.HashMap;

public class TechHashMap<K,V> extends HashMap<K, V> {
	private Entry<K,V>[] tech;
	//k is the ID
	//v is the Tech value 
	private int capacity;
	/**
	 * 
	 * @param id
	 * @param d
	 */
	public TechHashMap(long id, double d)
	{
		//double is the load value 
	}
	/***
	 * 
	 * @return the capacity
	 */
	public int getCapacity()
	{
		return capacity;
	}
	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
}
