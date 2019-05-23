package homework4;

public class Airplane {
	
	public Airplane(String destinationCity, double timeToTakeoff) {
		super();
		this.destinationCity = destinationCity;
		this.departureCity = "NYC";
		this.timeToTakeoff = timeToTakeoff;
		Passenger[] peoplePlane = new Passenger[capacity];

	}
	
	// 5 first class, 5 business,  10 premium economy, 15 economy
	String destinationCity;
	String departureCity;
	final static int capacity = 35;
	int firstClass = 5;
	int businessClass = 5;
	int preEcoClass = 10;
	int ecoClass = 15;
	Passenger[] peoplePlane;
	
	double timeToTakeoff; //if less than 5 then its boarding is closed and its ready to go 
	int numberPassenger;
	
	public void boardPlane(PassengerQueue queue)
	{
		for(int i = 0; i < Airplane.getCapacity(); i++)
		{
			
			if(queue.peek() != null) //account for it before we get rid of it 
			{
				numberPassenger++;
			}
			else
			{
				peoplePlane[i] = queue.dequeue();
			}
			//some will be null but its a real life situation
			//keep the nulls as empty seats
		}
	}
	
	/**
	 * @return the numberPassenger
	 */
	public int getNumberPassenger() {
		return numberPassenger;
	}
	/**
	 * @param numberPassenger the numberPassenger to set
	 */
	public void setNumberPassenger(int numberPassenger) {
		this.numberPassenger = numberPassenger;
	}
	/**
	 * @return the destinationCity
	 */
	public String getDestinationCity() {
		return destinationCity;
	}
	/**
	 * @param destinationCity the destinationCity to set
	 */
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	/**
	 * @return the departureCity
	 */
	public String getDepartureCity() {
		return departureCity;
	}
	/**
	 * @param departureCity the departureCity to set
	 */
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	/**
	 * @return the timeToTakeoff
	 */
	public double getTimeToTakeoff() {
		return timeToTakeoff;
	}
	/**
	 * @param timeToTakeoff the timeToTakeoff to set
	 */
	public void setTimeToTakeoff(int timeToTakeoff) {
		this.timeToTakeoff = timeToTakeoff;
	}
	/**
	 * @return the capacity
	 */
	public static int getCapacity() {
		return capacity;
	}
	public int unload(int dest)
	{
		//unloads all passengers when they reach destination
			peoplePlane = new Passenger[capacity];
			return getNumberPassenger();
		
	}
	
	public String toString()
	{
		return " is going to " + this.getDestinationCity() + " with " + Integer.toString(numberPassenger);
	}
	
}
