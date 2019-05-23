package extracredit1;

import java.io.Serializable;
import java.util.Scanner;

//Main Class
public class InventoryManager implements Serializable {

	private static TechManager manager;
	/***
	 * 
	 * @param args
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		manager = new TechManager();
		Scanner input = new Scanner(System.in);
		System.out.println("Starting Up... " + "\n" + "(I) - Import From File" + "\n" + "(A) – Add Tech" 
				+ "\n" + "(R) – Remove Tech"
				 + "\n" + "(G) – Get Info on Tech" +"\n"+ "(P) – Print Table" + "\n" + "(C) – Save to File" + "\n"+
				 "(S) - Sort Tech"+ "\n" +"(Q) – Quit"); 
				
					System.out.println("Please Select an Option: ");
					boolean workP = false;
					String chosenMenu = input.nextLine();
					
					do
					{
						
						if (workP) {
							input = new Scanner(System.in);
							System.out.println("Starting Up... " + "\n" + "(I) - Import From File" + "\n" + "(A) – Add Tech" 
									+ "\n" + "(R) – Remove Tech"
									 + "\n" + "(G) – Get Info on Tech" +"\n"+ "(P) – Print Table" + "\n" + "(C) – Save to File" + "\n"+
									 "(S) - Sort Tech"+ "\n" +"(Q) – Quit"); 
							System.out.println("Please Select an Option: ");
							chosenMenu = input.next();
						}
						
						if(chosenMenu.equalsIgnoreCase("I"))
						{
								System.out.println("Please enter a location for CSV file. Format should be 'name.csv':");
								String locationI = input.next();
								TechHashMap <Long, Tech> techMap = new TechHashMap<Long, Tech>(1000, 0.75);
								//1000 shouldn't matter b/c it'll get overridden afterwards 
								techMap = manager.buildFromFile(locationI);
								manager.sortByBrand();
								try {
									manager.printTable();
								} catch (DoesNotExistsException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}		
						}
						else if (chosenMenu.equalsIgnoreCase("A"))
						{
							System.out.println("Please enter the brand: \r");
							String brandIn = input.next();
							System.out.println("Please enter the type: \r");
							String typeIn = input.next();
							System.out.println("Please enter the location: \r");
							String locationIn = input.next();
							System.out.println("Please enter the usage condition (In Use or Not In Use): \r");
							String useIn = input.next();
							System.out.println("Please enter the ID Number: \r");
							long idIn = input.nextLong();
							
							boolean useBool = false;
							if(useIn.contains("in use"))
							{
								if(useIn.contains("not"))
								{
									useBool = false;
								}
								else
								{
									useBool = true;
								}
							}
							else
							{
								System.out.println("Not a valid format. Please enter 'In Use' or 'Not In Use'.");
							}
							
							try {
								manager.addTech(new Tech(idIn, brandIn, typeIn, locationIn, useBool));
							} catch (AlreadyExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								manager.printTable();
							} catch (DoesNotExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if (chosenMenu.equalsIgnoreCase("R"))
						{
							System.out.println("Please enter the ID Number: \r\n");
							long idIn = input.nextLong();
							try
							{
								manager.removeTech(idIn);
							}
							catch (DoesNotExistsException e)
							{
								e.printStackTrace();
							}
						}
						else if (chosenMenu.equalsIgnoreCase("G"))
						{
							System.out.println("Please enter the ID Number: \r\n");
							long idIn = input.nextLong();
							try {
								manager.getTech(idIn);
							} catch (DoesNotExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if (chosenMenu.equalsIgnoreCase("P"))
						{
							if(manager.getTotal() > 0)
							{
								try {
									manager.printTable();
								} catch (DoesNotExistsException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						else if(chosenMenu.equalsIgnoreCase("C"))
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
						else if (chosenMenu.equalsIgnoreCase("S"))
						{
							/*
							 * (B) – Brand
								o (T) – Type
								o (L) – Location
								o (U) – Use
								o (I) – ID Number 
							 */
							System.out.println("How would you like to sort by? " + "\n  "+ "(B) - Brand" + "\n  " + "(T) - Type"
									  + "\n  " + "(L)- Location" + "\n  " + "(U) - Use" + "\n   " + "(I) - ID Number");
							String menuChoice = input.next();
							
							if(menuChoice.equalsIgnoreCase("B"))
							{
							manager.sortByBrand();
							}
							else if(menuChoice.equalsIgnoreCase("T"))
							{
							manager.sortByType();
							}
							else if(menuChoice.equalsIgnoreCase("L"))
							{
							manager.sortByLocation();
							}
							else if(menuChoice.equalsIgnoreCase("U"))
							{
							manager.sortByUse();
							}
							else if(menuChoice.equalsIgnoreCase("I"))
							{
							manager.sortByID();
							}
							try {
								manager.printTable();
							} catch (DoesNotExistsException e) {
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
