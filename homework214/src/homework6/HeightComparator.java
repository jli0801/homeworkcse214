package homework6;

import java.util.Comparator;

public class HeightComparator implements Comparator<Person> {

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Person arg0, Person arg1) 
	{
		// TODO Auto-generated method stub
		Person p1 = (Person)arg0;  
		Person p2 = (Person)arg1;  
		  
		if(p1.getHeight() ==p2.getHeight())  
		{
			return 0;  
		}
		else if(p1.getHeight() > p2.getHeight())  
		{
			return 1;  
		}
		else  
		{
			return -1;  
		}
	} 
	
}
