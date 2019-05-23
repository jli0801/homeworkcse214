package extracredit2;

public class SelectionSort {

	public Double[] sort(Double[] sortArr)
	{
	int i = 0;
	int j = 0;
	
	int minimum = 0;
	//the sorted array will consist of one element
		for (i = 0; i < sortArr.length-1; i++)  
		{  
			minimum = i;  //one element
		    for (j = i+1; j < sortArr.length; j++)  //unsorted array
		    {
		    	 if (sortArr[j] < sortArr[minimum])  
		    	 {
		    		 minimum = j; //finding the minimum linearly
		    	 }
		    }  
		    //SWAP minimum and i 
		    double temp = sortArr[minimum]; //gets the element before  
		    sortArr[minimum] = sortArr[i];  
		    sortArr[i] = temp; //switching 
		}  
		return sortArr;
	}
}
