package homework6;

import java.io.Serializable;
import java.util.Scanner;

public class PersonManager implements Serializable {

	/**
	 * 
	 * @param args
	 * Main Methods
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonDataManager manager = new PersonDataManager();
		
		System.out.println("Starting Up... " + "\n" + "(I) - Import From File" + "\n" + "(A) - Add Person" 
				+ "\n" + "(R) -  Remove Person"
				 + "\n" + "(G) -  Get Info on Person" +"\n"+ "(P) -  Print Table" + "\n" + "(S) -  Sort" + "\n"+
				 "(Q) - Quit"); 
					System.out.println("Please Select an Option: ");
					
					boolean workP = false;
					Scanner input = new Scanner(System.in);
					String chosenMenu = input.nextLine();
					
					do
					{
						
						if (workP) {
							input = new Scanner(System.in);
							System.out.println("Starting Up... " + "\n" + "(I) - Import From File" + "\n" + "(A) -  Add Person" 
									+ "\n" + "(R) - Remove Person"
									 + "\n" + "(G) - Get Info on Person" +"\n"+ "(P) -  Print Table" + "\n" + "(S) - Sort" + "\n"+
									 "(Q) - Quit"); 
							System.out.println("Please Select an Option: ");
							chosenMenu = input.next();
						}
						
						if(chosenMenu.equalsIgnoreCase("I"))
						{
								System.out.println("Please enter a location for CSV file. Format should be 'name.csv':");
								String locationI = input.next();
								PersonDataHashMap <String, Person> personMap = new PersonDataHashMap<String, Person>(1000, 0.75);
								//1000 shouldn't matter b/c it'll get overridden afterwards 
								personMap = manager.buildFromFile(locationI);
								manager.sortByName();
								try {
									manager.printTable();
								} catch (PersonDoesNotExistsException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
						}
						if(chosenMenu.equalsIgnoreCase("A"))
						{
							System.out.println("Please enter the name of the person: \r");
							
							String nameIn = input.next();
						//	input.nextLine();
							System.out.println("Please enter the gender (M or F): \r");
							String genderIn = input.next();
							genderIn = genderIn.replaceAll("^\"|\"$", "");
							System.out.println("Please enter the age: \r\n");
							int ageIn = input.nextInt();
							System.out.println("Please enter the height (in inches): \r");
							double heightIn = input.nextDouble();;
							System.out.println("Please enter the weight (in lbs): \r");
							double weightIn = input.nextDouble();
							
							try {
								manager.addPerson(new Person(nameIn, genderIn, ageIn, heightIn, weightIn));
							} catch (PersonAlreadyExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								manager.printTable();
							} catch (PersonDoesNotExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(chosenMenu.equalsIgnoreCase("R"))
						{
							System.out.println("Who would you like to remove?");
							String name = input.next();
							try
							{
								manager.removePerson(name);
							}
							catch (PersonDoesNotExistsException e)
							{
								e.printStackTrace();
							}
							try {
								manager.printTable();
							} catch (PersonDoesNotExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(chosenMenu.equalsIgnoreCase("G"))
						{
							System.out.println("Who would you like to know more about?");
							String name = input.next();
							//search in Person Data Manager
							try
							{
								manager.getPerson(name);
							}
							catch (PersonDoesNotExistsException e)
							{
								e.printStackTrace();
							}
						}
						if(chosenMenu.equalsIgnoreCase("P"))
						{
							//could throw nothing 
							try {
								manager.printTable();
							} catch (PersonDoesNotExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(chosenMenu.equalsIgnoreCase("S"))
						{
						
							System.out.println("How would you like to sort by? " + "\n  "+ "(N) - Name" + "\n  " + "(W) - Weight"
									  + "\n  " + "(H)- Height");
							String menuChoice = input.next();
							
							if(menuChoice.equalsIgnoreCase("N"))
							{
							manager.sortByName();
							}
							if(menuChoice.equalsIgnoreCase("W"))
							{
							manager.sortByWeight();
							}
							if(menuChoice.equalsIgnoreCase("H"))
							{
							manager.sortByHeight();
							}
							try {
								manager.printTable();
							} catch (PersonDoesNotExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						workP = true;
					}
					while (!(chosenMenu.equalsIgnoreCase("Q")));
					
					if(chosenMenu.equalsIgnoreCase("Q"))
					{
						System.out.println("Quitting program... Bye!");
						input.close();
						System.exit(0);
					}
					input.close();
	}

}
