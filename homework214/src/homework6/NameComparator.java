package homework6;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

	
	@Override
	/**
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		Person p1 = (Person)o1;  
		Person p2 = (Person)o2;  
		  
		return p1.getName().compareTo(p2.getName());  
	}

}
