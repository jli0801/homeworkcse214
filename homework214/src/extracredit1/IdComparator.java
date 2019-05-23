package extracredit1;

import java.util.Comparator;

public class IdComparator implements Comparator<Tech> {

	/**
	 * @returns int to see if equivalent 
	 * @param o1 is a Tech object and o2 is the comparing one
	 */
	@Override
	public int compare(Tech o1, Tech o2) {
		// TODO Auto-generated method stub
		Tech p1 = (Tech)o1;  
		Tech p2 = (Tech)o2;  
		  
		if(p1.getId() ==p2.getId())  
		{
			return 0;  
		}
		else if(p1.getId() > p2.getId())  
		{
			return 1;  
		}
		else  
		{
			return -1;  
		}
	}

}
