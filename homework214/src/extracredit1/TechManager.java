package extracredit1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Scanner;
/*
 * reads inputs from a scanner and creates them into a Tech object to be put into a HashMap. 
 * In addition to that, you should print the data from the array as a table. 

 */

public class TechManager {

	private ArrayList<Tech> inventory;
	private TechHashMap <Long, Tech> techMap;
	/**
	 * 
	 * @return the array list of Tech 
	 */
	public ArrayList<Tech> getInventory()
	{
		return inventory;
	}
	public static int total;
	/**
	 * 
	 * @return the total number of inventory
	 */
	public static int getTotal()
	{
		return total;
	}
	/**
	 * constructor for Tech Manager
	 */
	public TechManager() {
		// TODO Auto-generated constructor stub
		inventory = new ArrayList<Tech>();
		total = 0;
	}
	/**
	 * 
	 * @param location
	 * @return a TechHashMap
	 * @throws IllegalArgumentException
	 */
	public static TechHashMap buildFromFile (String location) throws IllegalArgumentException
	{
	try {
		File file = new File(location);
		TechManager tm = new TechManager();
		// read number of lines in file
		int length = 0;
		BufferedReader r = new BufferedReader(new FileReader(file));
		while (r.readLine() != null) 
		{
			length++;
		}
		r.close();
		TechHashMap <Long, Tech> techMap = new TechHashMap<Long, Tech>(length, 0.75);
		// make Person objects by reading info from csv file
		Scanner input = new Scanner(file);
		int i = 0;
		//Tech[] newTech = new Tech[length-1];
		ArrayList<Tech> newTech = new ArrayList<Tech>(); //keep this to print later as a table since it worked 
		
		input.nextLine();
		while (input.hasNextLine()) 
		{
			String line = input.nextLine();
			String[] hold = line.split(","); //trim by comma
			
			for (int k = 0; k < hold.length; k++) 
			{
				hold[k] = hold[k].trim(); //get rid of spaces
			}
			
			//(long idNum, String brandT, String typeT, String locationT, boolean useT) {
			//Brand,Type ,Location,Usage,ID - FILE
			
			if(hold[4].substring(1, hold[4].length()-1).compareToIgnoreCase("In Use") == 0)
			{
				newTech.add(new Tech(Long.parseLong(hold[0]), hold[1].substring(1, hold[1].length()-1), 
						hold[2].substring(1, hold[2].length()-1), hold[3].substring(1, hold[3].length()-1),
						true));
			}
			else if (hold[4].substring(1, hold[4].length()-1).compareToIgnoreCase("Not In Use") == 0)
			{
				newTech.add(new Tech(Long.parseLong(hold[0]), hold[1].substring(1, hold[1].length()-1), 
						hold[2].substring(1, hold[2].length()-1), hold[3].substring(1, hold[3].length()-1),
						false));
			}
			techMap.put(newTech.get(i).getId(),newTech.get(i));
			i++;
		}
		input.close();
		
		
		
		for(int k = 0; k < newTech.size(); k++)
		{
			tm.inventory.add(newTech.get(k));
		}
		tm.total = tm.inventory.size();
		
		return techMap;		
		} 
		catch (IOException ex) {
			throw new IllegalArgumentException("Please make sure the file is valid! Try again.");
		}
	 }
	/***
	 * 
	 * @param tech2
	 * @param arrPos
	 * @param trimmedArray
	 * @param desPos
	 * @param length
	 */
	public void arrayCopy(ArrayList<Tech> tech2, int arrPos, ArrayList<Tech> trimmedArray, int desPos, int length) 
	{
		for (int i = desPos; i < length; i++, arrPos++) 
		{
			trimmedArray.set(i, tech2.get(arrPos));
		}
	}
	/***
	 * 
	 * @param newTech
	 * @throws AlreadyExistsException
	 */
	public void addTech (Tech newTech) throws AlreadyExistsException
	{
		if(techMap.containsKey(newTech.getId()))
		{
			//if it contains the key then true
			throw new AlreadyExistsException("Another product exists with the same ID.");
		}
		else 
		{
			//add into the array list and the map
			inventory.add(newTech);
			techMap.put(newTech.getId(), newTech);
		}
	}
	/***
	 * 
	 * @param oldID
	 * @throws DoesNotExistsException
	 */
	public void removeTech (long oldID) throws DoesNotExistsException
	{
		if(techMap.containsKey(oldID))
		{
			//if it contains the key then true
			for(int i = 0 ; i < inventory.size(); i++) 
			{ 
				if(inventory.get(i).getId() == oldID)
				{
					inventory.remove(i);
				}
			}
			techMap.remove(oldID);
		}
		else
		{
			throw new DoesNotExistsException("Product was not found.");
		}
	
	}
	/***
	 * 
	 * @param idNum
	 * @return a 0 if it was not found and a 1 if it was found
	 */
	public int searchProduct (long idNum) 
	 {
		int exists = 0;
		for (Entry<Long, Tech> tech : techMap.entrySet())	 
		 {
		  Long keyT = (Long)tech.getKey(); 
		  if(keyT == idNum)
		  {
			  exists = 1;
		  }
		 }
		 return exists;
	 }
	/***
	 * 
	 * @param idNumber
	 * @throws DoesNotExistsException
	 */
	public void getTech (long idNumber) throws DoesNotExistsException
	 {
		// personMap.forEach((k, v) -> System.out.println(k
		 String output = "";
		 for (Entry<Long, Tech> tech : techMap.entrySet())	 
		 {
			  Long keyT = (Long)tech.getKey(); 
			  if(keyT == idNumber)
			  {
				  System.out.println(tech.toString());
			  }
			  else
			  {
				  throw new DoesNotExistsException("Product was not found.");
			  }
		 }
	 }
	/***
	 * 
	 * @throws DoesNotExistsException
	 */
	public void printTable() throws DoesNotExistsException 
	 {
		System.out.println("    "+ "Brand" + "    |    " + "Type" + "   |   " + "Location" + "    |    " + "Usage" + "    |     " + "ID");
		if(techMap == null)
		{
			throw new DoesNotExistsException("Product was not found.");
		}
		else
		{
			for (Entry<Long, Tech> tech : techMap.entrySet())	 
			 {
			
				if(tech.getValue() != null && tech.getKey() > 0)
				{
					System.out.println(tech.getValue().toTable());
				}
			}
		}
	 }
	/***
	 * 
	 * @param newLocation
	 * @throws IllegalArgumentException
	 */
	 public void saveCSV(String newLocation) throws IllegalArgumentException
	 {
		
		 try (PrintWriter writer = new PrintWriter(new File(newLocation))) {

		      StringBuilder sb = new StringBuilder();
		      //first row 
		      sb.append("Brand");
		      sb.append(',');
		      sb.append("Type");
		      sb.append(",");
		      sb.append("Location");
		      sb.append(",");
		      sb.append("Usage");
		      sb.append(",");
		      sb.append("ID");
		      sb.append('\n');

		      //after row ends
		      for (Entry<Long, Tech> tech : techMap.entrySet())	 
				 {
				
		    	  sb.append(tech.getValue().getBrand());
			      sb.append(',');
			      sb.append(tech.getValue().getType());
			      sb.append(',');
			      sb.append(tech.getValue().getLocation());
			      sb.append(',');
			      sb.append(tech.getValue().usage());
			      sb.append(',');
			      sb.append(tech.getKey());
			      sb.append('\n');
		      }
		      writer.write(sb.toString());
		    } catch (Exception e) {
		    	throw new IllegalArgumentException("Invalid Form for File. File Cannot be Created.");
		    }
		 System.out.println("File Name: " + newLocation + " was created sucessfully. ");
	 }
	 /**
	  * Sorts By Brand
	  */
	 public void sortByBrand()
	 {
		 Collections.sort(inventory, new BrandComparator());
	 }
	 /**
	  * Sorts By ID
	  */
	 public void sortByID()
	 {
		 Collections.sort(inventory, new IdComparator());
	 }
	 /**
	  * Sorts By Location
	  */
	 public void sortByLocation()
	 {
		 Collections.sort(inventory, new LocationComparator());
	 }
	 /**
	  * Sorts By type
	  */
	 public void sortByType()
	 {
		 Collections.sort(inventory, new TypeComparator());
	 }
	 /**
	  * Sorts By Use
	  */
	 public void sortByUse()
	 {
		 Collections.sort(inventory, new UseComparator());
	 }
}
