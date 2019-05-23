package homework4;

public class Passenger {

	public Passenger(String name, String destinationPlace, double timeAirport, String classPass) {
		super();
		this.name = name;
		this.destinationPlace = destinationPlace;
		this.departingPlace = "NYC";
		this.timeAirport = timeAirport;
		this.classPass = classPass;
	}
	String name;
	String destinationPlace;
	String departingPlace;
	double timeAirport; //format : 0.5 minute(s)
	String classPass;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the destinationPlace
	 */
	public String getDestinationPlace() {
		return destinationPlace;
	}
	/**
	 * @param destinationPlace the destinationPlace to set
	 */
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	/**
	 * @return the departingPlace
	 */
	public String getDepartingPlace() {
		return departingPlace;
	}
	/**
	 * @param departingPlace the departingPlace to set
	 */
	public void setDepartingPlace(String departingPlace) {
		this.departingPlace = departingPlace;
	}
	/**
	 * @return the timeAirport
	 */
	public double getTimeAirport() {
		return timeAirport;
	}
	/**
	 * @param timeAirport the timeAirport to set
	 */
	public void setTimeAirport(int timeAirport) {
		this.timeAirport = timeAirport;
	}
	/**
	 * @return the classPass
	 */
	public String getClassPass() {
		return classPass;
	}
	/**
	 * @param classPass the classPass to set
	 */
	public void setClassPass(String classPass) {
		this.classPass = classPass;
	}
	
	public String toString()
	{
		return "[" + this.getName() + ", " + this.getClassPass() + ", " + Double.toString(this.getTimeAirport()) 
		+ " minute(s)]";
	}


}
