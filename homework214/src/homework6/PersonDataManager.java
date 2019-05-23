package homework6;
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

public class PersonDataManager {

	//ArrayList<String>
	private ArrayList<Person> people; 
	private PersonDataHashMap <String, Person> personMap; //<String, Person> add on other side
	
	/**
	 * 
	 * @return array list of people
	 */
	public ArrayList<Person> getPeople() {
		return people;
	}
	
	/**
	 * @void constructor
	 */
	public PersonDataManager()
	{
		people = new ArrayList<Person>();
	}
	/**
	 * 
	 * @param location
	 * @return PersonDataHashMap
	 * @throws IllegalArgumentException
	 */
	public static PersonDataHashMap buildFromFile (String location) throws IllegalArgumentException
	//public static PersonDataManager buildFromFile () throws IllegalArgumentException
	 {
		try {
			File file = new File(location);

			// read number of lines in file
			int length = 0;
			BufferedReader r = new BufferedReader(new FileReader(file));
			while (r.readLine() != null) 
			{
				length++;
			}
			r.close();

			// make Person objects by reading info from csv file
			Scanner input = new Scanner(file);
			int i = 0;
			ArrayList<Person> newPeople = new ArrayList<Person>(); //keep this to print later as a table since it worked 
			PersonDataHashMap <String, Person> personMap = new PersonDataHashMap<String, Person>(length, 0.75);
			
			input.nextLine();
			while (input.hasNextLine()) 
			{
				String line = input.nextLine();
				String[] hold = line.split(",");
				
				for (int k = 0; k < hold.length; k++) 
				{
					hold[k] = hold[k].trim();
				}
				//key is the name of person
				//PERSON object is the value
				
				newPeople.set(i, new Person(hold[0].substring(0, hold[0].length()-1), hold[1].substring(0, hold[1].length()-1), 
						Integer.parseInt(hold[2]), Double.parseDouble(hold[3]),
						Double.parseDouble(hold[4])) );
				personMap.put(hold[0].substring(1, hold[0].length()-1), newPeople.get(i)); //change array to array list
				
				//insert new cell
				
				i++;
			}
			input.close();
			
			
			return personMap;		
		} 
		catch (IOException ex) {
			throw new IllegalArgumentException("Please make sure the file is valid! Try again.");
		}
	 }
	/**
	 * 
	 * @param newPerson
	 * @throws PersonAlreadyExistsException
	 * @void adds person onto hashmap and array list
	 */
	 public void addPerson (Person newPerson) throws PersonAlreadyExistsException 
	 {
			
			boolean personPlaced = false;
			
			for(int i = 0 ; i < people.size(); i++) 
			{ 
				
				if(people.get(i) != null && newPerson.getName().equalsIgnoreCase(people.get(i).getName()) &&
						newPerson.getAge() == people.get(i).getAge() && 
						newPerson.getHeight() == people.get(i).getHeight() && 
						newPerson.getWeight() == people.get(i).getWeight()&&
						newPerson.getGender().equalsIgnoreCase(people.get(i).getGender())) 
				{
					throw new PersonAlreadyExistsException("This person already exists! Please try again.");
				}
			}
			people.add(newPerson);
			
			if(searchPerson(newPerson) == -1)
			{
			personMap.put(newPerson.getName(), newPerson);
			}
			else
			{
				throw new PersonAlreadyExistsException("This person already exists! Please try again.");
			}
			
			
	 }
	 /**
	  * 
	  * @param name
	  * @throws PersonDoesNotExistsException
	  * @void Prints the person's information
	  */
	 public void getPerson (String name) throws PersonDoesNotExistsException
	 {
		// personMap.forEach((k, v) -> System.out.println(k
		 String output = "";
		 for (Entry<String, Person> person : personMap.entrySet())	 
		 {
			  String keyP = (String)person.getKey(); 
			  if(keyP.equalsIgnoreCase(name))
			  {
				  System.out.println(person.getValue().toStringDes());
			  }
			  else
			  {
				  throw new PersonDoesNotExistsException();
			  }
		 }
		
	 }
	 /**
	  * 
	  * @param name
	  * @return 0 if the person doesn't exist 1 if the person does exist
	  * Compares by name/key
	  */
	 public int searchName (String name) 
	 {
		int personExists = 0;
		
		 for (Entry<String, Person> person : personMap.entrySet())	 
		 {
			  String keyP = (String)person.getKey(); 
			  if(keyP.equalsIgnoreCase(name))
			  {
				  personExists = 1;
			  }
		 }
		 return personExists;
		
	 }
	 /**
	  * 
	  * @param personIn
	  * @return 0 if the person doesn't exist 1 if the person does exist
	  * Compares by Person Object
	  */
	 public int searchPerson (Person personIn) 
	 {
		int personExists = 0;
		 
		 for (Entry<String, Person> person : personMap.entrySet())	 
		 {
			  String keyP = (String)person.getKey(); 
			  if(keyP.equals(personIn))
			  {
				  personExists = 1;
			  }
		 }
		 return personExists;
		
	 }
	 /**
	  * 
	  * @param name
	  * @throws PersonDoesNotExistsException
	  * @void Removes the person by name 
	  */
	 public void removePerson (String name) throws PersonDoesNotExistsException
	 {
		
			
			if (searchName(name) == 0) 
			{
				throw new PersonDoesNotExistsException("Person does not exist.");
			} 
			else 
			{
				personMap.remove(name);
			}
			for(int i = 0 ; i < people.size(); i++) 
			{ 
				if(people.get(i).getName().equalsIgnoreCase(name))
				{
					people.remove(i);
				}
			}
		
	 }
	 /**
	  * @throws PersonDoesNotExistsException 
	 * @void Prints in Tabular format
	  */
	 public void printTable() throws PersonDoesNotExistsException 
	 {
		System.out.println("    "+ "Name" + "    |    " + "Age" + " |   " + "Gender" + "  |      " + "Height" + "            |      " + "Weight");
		boolean nullTable = false;
		if(personMap == null)
		{
			throw new PersonDoesNotExistsException();
		}
		else
		{
			for (Entry<String, Person> person : personMap.entrySet())	 
			 {
			
				if(person.getValue() != null && person.getKey() != "")
				{
					System.out.println(person.getValue().toString());
				}
				if(person.getValue() == null)
				{
					nullTable = true;
				}
			}
		}
		
	 }
	 /**
	  * 
	  * @param newLocation
	  * @throws IllegalArgumentException
	  * @void saves data in CSV file
	  */
	 public void saveCSV(String newLocation) throws IllegalArgumentException
	 {
		
		 try (PrintWriter writer = new PrintWriter(new File(newLocation))) {

		      StringBuilder sb = new StringBuilder();
		      //first row 
		      sb.append("Name");
		      sb.append(',');
		      sb.append("Sex");
		      sb.append(",");
		      sb.append("Age");
		      sb.append(",");
		      sb.append("Height (inches)");
		      sb.append(",");
		      sb.append("Weight (lbs)");
		      sb.append('\n');

		      //after row ends
		      for (Entry<String, Person> person : personMap.entrySet())	 
				 {
		    	  sb.append(person.getKey());
			      sb.append(',');
			      sb.append("\""+person.getValue().getGender() + "\"");
			      sb.append(',');
			      sb.append(String.valueOf(person.getValue().getAge()));
			      sb.append(',');
			      sb.append(person.getValue().convertHeightToString());
			      sb.append(',');
			      sb.append(String.valueOf(person.getValue().getWeight()));
			      sb.append('\n');
		      }
		      writer.write(sb.toString());
		    } catch (Exception e) {
		    	throw new IllegalArgumentException("Invalid Form for File. File Cannot be Created.");
		    }
		 System.out.println("File Name: " + newLocation + " was created sucessfully. ");
	 }
	 
	
		/**
		 * 
		 * @param people2
		 * @param arrPos
		 * @param trimmedArray
		 * @param desPos
		 * @param length
		 * @void Copies array list to another one
		 */
		public void arrayCopy(ArrayList<Person> people2, int arrPos, ArrayList<Person> trimmedArray, int desPos, int length) 
		{
			for (int i = desPos; i < length; i++, arrPos++) 
			{
				trimmedArray.set(i, people2.get(arrPos));
			}
		}
		/**
		 * @void Sorts by Name
		 */
		public void sortByName() {
			// TODO Auto-generated method stub
		Collections.sort(people, new NameComparator());
		}
		/**
		 * @void Sorts By Weight
		 */
		public void sortByWeight() {
			// TODO Auto-generated method stub
		Collections.sort(people, new WeightComparator());
		}
		/**
		 * @void Sorts by Height
		 */
		public void sortByHeight() {
			// TODO Auto-generated method stub
		Collections.sort(people, new HeightComparator());
		}
	}
