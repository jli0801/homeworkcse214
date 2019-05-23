package extracredit1;

public class Tech {
	long id; //acts as the key; should be around 9 digits long 
	String brand;
	String type;
	String location;
	boolean use;
	//0 means not in use and 1 means in use 
	/***
	 * 
	 * @param idNum
	 * @param brandT
	 * @param typeT
	 * @param locationT
	 * @param useT
	 * @return a new Tech object
	 */
	public Tech(long idNum, String brandT, String typeT, String locationT, boolean useT) {
		// TODO Auto-generated constructor stub
		setId(idNum);
		setBrand(brandT);
		setType(typeT);
		setLocation(locationT);
		setUse(useT);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the use
	 */
	public boolean getUse() {
		return use;
	}

	/**
	 * @param use the use to set
	 */
	public void setUse(boolean use) {
		this.use = use;
	}
	
	/***
	 * 
	 * @return the usage in the String
	 */
	public String usage()
	{
		if (getUse()) //true 
		{
			return "In Use";
		}
		else
		{
			return "Not In Use";
		}
	}
	/***
	 * @return the string and uses the values of the object
	 */
	public String toString()
	{
		return "The " + type + " from " + brand + "is currently " + usage() + " at this location: " + location + " with this ID Number: " + Long.toString(getId()) + ".";
	}
	/***
	 * 
	 * @return the string in tabular format
	 */
	public String toTable()
	{
		return "    " + brand + "    |    " + type + "    |    "+ location + "    |    " + usage() + "    |    " + Long.toString(getId());
	}
}
