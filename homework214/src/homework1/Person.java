package homework1;

public class Person {

	private int age;
	private double height, weight; 
	private String name, gender; 
	
	public Person (String nameU, String genU, int ageU, double heightU, double weightU)
	{
		setName(nameU);
		setGender(genU);
		setAge(ageU);
		setHeight(heightU);
		setWeight(weightU);
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String convertHeightToString()
	{
		//in inches 
		double inch;
		double feet;
		feet = this.getWeight()%12; 
		inch = this.getWeight() - feet*12;
		return String.valueOf(feet) + " feet, " + String.valueOf(inch) + " inch(es)";
		
	}
	public String toString()
	{
		return "    "+ getName() + "    |    " + String.valueOf(getAge())+ "    |     " + getGender() + "    |    " + convertHeightToString() + "    |    " + String.valueOf(getWeight());
		
	}

}
