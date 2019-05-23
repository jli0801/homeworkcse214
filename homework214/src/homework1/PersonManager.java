package homework1;
import java.util.Scanner;
public class PersonManager {

private static PersonDataManager manager; 
	
	public static void main (String [] args) throws IllegalArgumentException 
	{
		manager = new PersonDataManager();
		Scanner input = new Scanner(System.in);
		System.out.println("Starting Up... " + "\n" + "(I) - Import From File" + "\n" + "(A) – Add Person" 
	+ "\n" + "(R) – Remove Person"
	 + "\n" + "(G) – Get Info on Person" +"\n"+ "(P) – Print Table" + "\n" + "(S) – Save to File" + "\n"+
	 "(Q) – Quit"); 
	
		System.out.println("Please Select an Option: ");
		
		String chosenMenu = input.next();
		if(chosenMenu.equals("I"))
		{
				System.out.println("Please enter a location for CSV file. Format should be 'name.csv':");
				input.nextLine();
				PersonDataManager.buildFromFile();
				
				manager.sortArray(manager.getPeople());
			//	input.nextLine();
				manager.printTable();
			
		}
		else if (chosenMenu.equals("A"))
		{
			System.out.println("Please enter the name of the person: \r\n");
			String nameIn = input.nextLine();
			System.out.println("Please enter the gender (M or F): \r\n");
			String genderIn = input.nextLine();
			genderIn = genderIn.replaceAll("^\"|\"$", "");
			System.out.println("Please enter the age: \r\n");
			int ageIn = input.nextInt();
			System.out.println("Please enter the height (in inches): \r\n");
			int heightIn = input.nextInt();;
			System.out.println("Please enter the weight (in lbs): \r\n");
			int weightIn = input.nextInt();
			
			try {
				manager.addPerson(new Person(nameIn, genderIn, ageIn, heightIn, weightIn));
			} catch (PersonAlreadyExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (chosenMenu.equals("R"))
		{
			System.out.println("Please enter the name of the person: \r\n");
			String nameIn = input.nextLine();
			try
			{
				manager.removePerson(nameIn);
			}
			catch (PersonDoesNotExistsException e)
			{
				e.printStackTrace();
			}
		}
		else if (chosenMenu.equals("G"))
		{
			System.out.println("Please enter the name of the person: \r\n");
			String nameInfo = input.nextLine();
			try {
				manager.getPerson(nameInfo);
			} catch (PersonDoesNotExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (chosenMenu.equals("P"))
		{
			if(manager.getTotal() > 0)
			{
				manager.printTable();
			}
		}
		else if(chosenMenu.equals("S"))
		{
			//save to file
			System.out.println("Enter a new name for your updated csv file. Please add '.csv' in name. ");
			String newCSV = input.nextLine();
			try {
				manager.saveCSV(newCSV);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (chosenMenu.equals("Q"))
		{
			//quit
			
			System.out.println("Quitting program... Bye!");
			input.close();
			System.exit(0);
		}
		else
		{
			System.out.println("Command Invalid.");
		}
	}

}
