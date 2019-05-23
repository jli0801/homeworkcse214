package homework4;

public class PassengerQueue {

	String destination;

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	Passenger[] queueP; //ordered by class and time  
	
	int firstClass = -1;
	int businessClass = -1;
	int preEcoClass = -1;
	int ecoClass = -1;
	int front;
	int back;

	
	
	int cursor = -1;
	int currentLineSize;

	//Passener Queue has an array of Passengers that are lining up 
	/**
	 * 
	 * @param airline
	 * @void sets up the qualities of a passenger queue
	 */
	public PassengerQueue(String airline) {
		// TODO Auto-generated constructor stu
		destination = airline;
		front = -1;
		back = -1;
		firstClass = -1;
		businessClass = -1;
		preEcoClass = -1;
		ecoClass = -1;
		currentLineSize = -1;
		Passenger[] queueP = new Passenger[Airplane.getCapacity()];

	}
	
	
	public void enqueue(Passenger p) //new passenger will join the line
	{
		//this is organized by time only, organize by class then within class organize by time 
		
		if ((back+1)%Airplane.getCapacity() == front)
		{
			System.out.println("Full Queue.");
		}
		/*
		if (front == -1) 
		{ // isEmpty()
			//change this to include classes. 
			
			//front is always 0 or -1 
			front = 0; 
			back = 0;
		}
		else 
		{*/
			//TREAT EACH CLASS AS ANOTHER QUEUE 
			if(p.getClassPass().equalsIgnoreCase("First Class") && firstClass < 5)
			{
				firstClass++;
				
				//FIRST FIVE 0 TO 4
				queueP[firstClass] = p;
				
			}
			else if (p.getClassPass().equalsIgnoreCase("Business Class") && businessClass < 5)
			{
				businessClass++;
				
				//NEXT FIVE 5 TO 9
				int temp = businessClass+5;
				queueP[temp] = p;
			}
			else if (p.getClassPass().equalsIgnoreCase("Premium Economy Class") && preEcoClass < 10)
			{
				preEcoClass++;
				//NEXT TEN 10 TO 19
				int tempP = preEcoClass+10;
				queueP[tempP] = p;
			}
			else
			{
				//economy class
				if(ecoClass < 15)
				{
					//NEXT FIFTEEN 20 TO 34
					ecoClass++;
					int tempPE = ecoClass + 15;
					queueP[tempPE] = p;
				}
			}
			currentLineSize++;
			back++;
		}
		
		
	
	/**
	 * 
	 * @return one passenger at a time, starting from first class to last 
	 * needs to be used in a loop and checked for nulls 
	 * if it returns a null then keep it
	 * in real life situations, there will be empty seats
	 */
	public Passenger dequeue() //must be used in a for loop and checked for nulls. 
	{
		
		cursor++; // at -1 then currently at 0 
		Passenger placeHolder = queueP[cursor];
		queueP[cursor] = null; //get rid of that person 
		return placeHolder; //could be null
		//get rid of that person
		
	}
	/**
	 * 
	 * @return the first passenger on the line
	 */
	public Passenger peek() //return the first element of the queue without removing it
	{
		if(isEmpty())
		{
			
			System.out.println("No one is on line currently.");
			return null;
		}
		else
		{
			return queueP[0]; //return the first person on line 
		}
	}
	/**
	 * 
	 * @return the size of the line or the number of passengers
	 */
	public int size()
	{
		//returns number of passengers

		return currentLineSize;

	}
	/**
	 * 
	 * @return whether the queue is empty of not. 
	 */
	public boolean isEmpty()
	{
		//is it empty or not
		//go through the whole array or not lol
		if(this.size() > -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
