package homework6;

public class Person {

	private int age;
	private double height, weight; 
	private String name, gender; 
	/**
	 * 
	 * @param nameU
	 * @param genU
	 * @param ageU
	 * @param heightU
	 * @param weightU
	 * Person constructor 
	 */
	public Person (String nameU, String genU, int ageU, double heightU, double weightU)
	{
		setName(nameU);
		setGender(genU);
		setAge(ageU);
		setHeight(heightU);
		setWeight(weightU);
	}
	/**
	 * 
	 * @return person's age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * 
	 * @param age
	 * @void set's persons age 
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * 
	 * @return user's height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * 
	 * @param height
	 * @void sets the user's height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * 
	 * @return User's Weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * 
	 * @param weight
	 * @void sets the User's Weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * 
	 * @return User's Name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 * @void set's user's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return user's gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 
	 * @param gender
	 * @void set's users gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 
	 * @return string of the user's height
	 */
	public String convertHeightToString()
	{
		//in inches 
		int inch;
		int feet;
		feet = (int)this.getHeight()/12; 
		inch = (int)this.getHeight() - feet*12 ;
		return String.valueOf(feet) + " feet, " + String.valueOf(inch) + " inch(es)";
	}
	/**
	 * @return format of the user in Tabular Format
	 */
	public String toString()
	{
		return "    "+ getName() + "    |    " + String.valueOf(getAge())+ "  |   " + getGender() + "  |       " + convertHeightToString() + "       |    " + String.valueOf(getWeight());
		
	}
	/**
	 * 
	 * @return formats user's information
	 */
	public String toStringDes()
	{
		String outputInfo = "";
		outputInfo = this.name + " is a " + this.age + " year(s) old";
		if(this.getGender().equalsIgnoreCase("M"))
		{
			 outputInfo += " male ";
		}
		else if(this.getGender().equalsIgnoreCase("F"))
		{
					 outputInfo += " female ";
		}
		outputInfo += ""+ this.convertHeightToString() + " and weighs " + this.getWeight() + " pounds.";
		return outputInfo;
	}
}
