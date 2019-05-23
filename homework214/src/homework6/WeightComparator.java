package homework6;

import java.util.Comparator;

public class WeightComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		
			Person p1 = (Person)o1;  
			Person p2 = (Person)o2;  
			  
			if(p1.getWeight() == p2.getWeight())  
			{
				return 0;  
			}
			else if(p1.getWeight() > p2.getWeight())  
			{
				return 1;  
			}
			else  
			{
				return -1;  
			}
	}

}
