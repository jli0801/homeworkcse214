package extracredit2;

public class InsertionSort {
	public Double[] sort(Double[] sortArr)
	{
		for (int i = 1; i < sortArr.length; ++i) //regular for loop
		{ 
			Double inS = sortArr[i]; //the first element
			int j = i - 1; //
	
			while (sortArr[j] > inS && j >= 0) 
			{ 
				sortArr[i] = sortArr[j]; 
			    j--;
			} 
		sortArr[j + 1] = inS; 
		} 
		return sortArr;
	}
}
