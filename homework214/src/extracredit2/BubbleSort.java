package extracredit2;

public class BubbleSort {

	public Double[] sort(Double[] sortArr)
	{
	    for(int i = 0; i < sortArr.length - 1; i++)
	    {
			for (int j = sortArr.length - 1; j > i; j--) //needs a another for loop that is one ahead of i 
			{
			    //swap
				if(sortArr[j] < sortArr[j - 1])
				{
				    double temp = sortArr[j - 1]; //gets the element before  
				    sortArr[j - 1] = sortArr[j];  
				    sortArr[j] = temp; //switching 
			    }
			}    
		}
		return sortArr;
	}
}
