package extracredit1;

import java.util.Comparator;

public class TypeComparator implements Comparator<Tech> {

	/**
	 * @returns int to see if equivalent 
	 * @param o1 is a Tech object and o2 is the comparing one
	 */
	@Override
	public int compare(Tech o1, Tech o2) {
		Tech t1 = (Tech)o1;
		Tech t2 = (Tech)o2;
		
		return t1.getType().compareToIgnoreCase(t2.getType());
	}
}
