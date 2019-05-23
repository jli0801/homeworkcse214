package homework1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class PersonDataManager {

	private Person[] people; 
	public Person[] getPeople() {
		return people;
	}
	private static int total;
	public static int getTotal() {
		return total;
	}
	public PersonDataManager()
	{
		people = new Person[0];
		total = 0;
	}
	
	//public static PersonDataManager buildFromFile (String location) throws IllegalArgumentException
	public static PersonDataManager buildFromFile () throws IllegalArgumentException
	 {
		 PersonDataManager pdm = new PersonDataManager();
		 String name = "";
		 String gender = "";
		 int age = 0;
		 int height = 0; 
		 int weight = 0; 
		 int counter = 0; 
		// File csv = new File(location);
		 
		 try {
					Scanner scanner = new Scanner(new File("homework214/biostats.csv"));
					scanner.useDelimiter(",");
					scanner.nextLine();
				        while (scanner.hasNext() && counter <= 5)
				        {
				        	total++;
				        	//second statement in IF is redundant and i know. just as a precaution
				        	if(counter%5 == 1 && (scanner.next().getClass().equals(name.getClass())))
				        	{
				        		name = scanner.next();
				        		counter++;
				        	}
				        	else if (counter%5 == 2 && (scanner.next().getClass().equals(name.getClass())))
				        	{
				        		gender = scanner.next();
				        		counter++;
				        	}
				        	else if (counter%5 == 3)
				        	{
				        		age = scanner.nextInt();
				        		counter++;
				        	}
				        	else if (counter%5 == 4)
				        	{
				        		height = scanner.nextInt();
				        		counter++;
				        	}
				        	else
				        	{
				        		weight = scanner.nextInt(); 
				        		counter = 0; //next row 
				        	}
				        	pdm.addPerson(new Person(name, gender, age, height, weight));
				        }
			        	
			        //Do not forget to close the scanner 
			        scanner.close();
			      
			} 
		 	catch (PersonAlreadyExistsException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
	        //Set the delimiter used in file
		 	pdm.ensureCapacity(total/5);
			return pdm; //idk what this is
	 }
	
	 public void addPerson (Person newPerson) throws PersonAlreadyExistsException 
	 {
		 for( int i = 0; i < people.length; i++)
		 {
			 if(people[i].getName() == newPerson.getName())
			 {
				 throw new PersonAlreadyExistsException("Person Already Exists. Sorry!");
			 }
			 else
			 {
				 if (total == people.length) 
				 {
						ensureCapacity(total * 2 + 1);
				 }
				 int index = total;
				 people[people.length] = newPerson; 
				 sortArray(people);
				 trimToSize();
			 }
		 }
		//search for person w/ same name 
		//if none, then add person in spot alphabetical order 
		 //if yes, then throw 
		 
		 
		 
	 }
	 public void getPerson (String name) throws PersonDoesNotExistsException
	 {
		String outputInfo = "";
		 for(int i =0 ; i < people.length; i++)
		 {
			 if(people[i].getName() == name)
			 {
				 outputInfo = name + " is a " + String.valueOf(people[i].getAge()) + " year old";
				 if(people[i].getGender() == "M")
				 {
					 outputInfo += " male ";
				 }
				 if(people[i].getGender() == "F")
				{
							 outputInfo += " female ";
				}
				outputInfo += people[i].convertHeightToString() + " and weighs " + 
				String.valueOf(people[i].getWeight()) + " pounds.";
				System.out.println(outputInfo);
				break;
			 }
		 }
		 throw new PersonDoesNotExistsException("Person Does Not Exist. How about you add them? ");
	 }
	 
	 public void removePerson (String name) throws PersonDoesNotExistsException
	 {
		 int indexName = indexOf(name);
			
			if (indexName == -1) {
				throw new PersonDoesNotExistsException("Cannot remove. Person does not exist.");
			} else {
				// Shifts each value to the left and trims the array people by one
				arrayCopy(people, indexName + 1, people, indexName, people.length - 1);
				total--;
				trimToSize();
				sortArray(people);
			}
		
	 }
	 
	 public void printTable()
	 {
		System.out.println("    "+ "Name" + "    |    " + "Age" + "    |     " + "Gender" + "    |    " + "Height" + "    |    " + "Weight");
		for(int i = 0 ; i < people.length; i++)
		{
			if(people[i].getName() != "" || people[i] != null)
			{
			System.out.println(people[i].toString());
			}
		}
	 }
	 
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
		      for(int i = 0; i <people.length; i++)
		      {
		    	  sb.append(people[i].getName());
			      sb.append(',');
			      sb.append("\""+people[i].getGender() + "\"");
			      sb.append(',');
			      sb.append(String.valueOf(people[i].getAge()));
			      sb.append(',');
			      sb.append(people[i].convertHeightToString());
			      sb.append(',');
			      sb.append(String.valueOf(people[i].getWeight()));
			      sb.append('\n');
		      }
		      writer.write(sb.toString());
		    } catch (Exception e) {
		    	throw new IllegalArgumentException("Invalid Form for File. File Cannot be Created.");
		    }
		 System.out.println("File Name: " + newLocation + " was created sucessfully. ");
	 }
	 
	 //helper methods: 
	 public void sortArray(Person[] peopleArr)
	 {
		 boolean sortSwap = false;
		 Person temp;
		 do 
		 {
			 sortSwap = false;
			 //prevent from going array out of bounds 
		     for(int i=0 ; i<people.length-1 ; i++)
		     {
		    	 //compare names 
		         if(people[i].getName().compareTo(people[i+1].getName())>0)
		         {
		             temp = people[i+1];
		             people[i+1] = people[i];
		             people[i] = temp;
		             sortSwap = true;
		         }
		     }
		 }
		 while((sortSwap));
	 }
	 
	 public int indexOf(String name) 
	 {
			for (int i = 0; i < total; i++) 
			{
				if (people[i].getName() == name) 
				{
					return i; //returns index of same name 
				}
			}
			
			return -1;
		}
		
		
		public void ensureCapacity(int minCapacity) 
		{
			
			if (people == null) 
			{
				people = new Person[minCapacity];
			} else if (people.length < minCapacity) 
			{
				Person[] biggerArray;
				biggerArray = new Person[minCapacity];
				arrayCopy(people, 0, biggerArray, 0, total);
				people = biggerArray;
			}
		}
		
		public void ensureCapacity(Person[] p, int minCapacity) 
		{
			if (p.length < minCapacity) 
			{
				Person[] biggerArray;
				biggerArray = new Person[minCapacity];
				arrayCopy(p, 0, biggerArray, 0, total);
				p = biggerArray;
			}
		}
		
		
		public void arrayCopy(Person[] arr, int arrPos, Person[] dest, int desPos, int length) 
		{
			for (int i = desPos; i < length; i++, arrPos++) 
			{
				dest[i] = arr[arrPos];
			}
		}
		
	
		public void trimToSize() 
		{
			Person[] trimmedArray;
			if (people.length != total) 
			{
					trimmedArray = new Person[total];  
					arrayCopy(people, 0, trimmedArray, 0, total);
					people = trimmedArray;
			}
		}

}
