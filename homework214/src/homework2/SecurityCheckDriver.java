package homework2;

import java.util.List;
import java.util.Scanner;
public class SecurityCheckDriver {
	public static void statementPrint()
	{
		System.out.print("Security Check: " + "\n" + "Enter A to add, R to remove"
				+ ", P to print all, PR to print in "
				+ "reverse order, Q to quit. " + "\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A add ask for name, " " , number
		//R remove number
		//P print 
		//PR print in reverse order 
		//Q is quit
		SecurityCheck security = new SecurityCheck();
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		
		statementPrint();
		System.out.print("Please select an option. ");
		userInput = input.nextLine();
		
		switch (userInput)
		{
		case "A":
			//create a list of people then add 
			//number of people then people
			int numPeople;
			numPeople = input.nextInt();
			
			List<Person> tempP = null;
			
			while(!(numPeople == 0))
			{
				String nameP = "";
				int numberP = 0;
				boolean nameDone = false;
				
					//in the same line so parse 
					for(int i = 0; i < input.nextLine().length(); i++)
					{
						if((input.nextLine().substring(i, i+1).compareTo(" ")) == 0)
						{
							nameDone = true;
							if(nameDone)
							{
								numberP = Integer.valueOf(input.nextLine().substring(i+1, i+2));
							}
							//so theres a space and i is the index so everything before i is name
							//everything after i is the number 
						}
						else
						{
							nameP += input.nextLine().substring(0,i);
							nameDone = false;
						}
					}					
					tempP.add(new Person(nameP, numberP));
					numPeople--;
			}
			security.addPerson(tempP);
			break;
		case "R":
			//first number is how many people and the next numbers are ticket numbers 
			int peopleNum = input.nextInt();
			System.out.println("Enter 'N' to remove by name or enter 'T' to remove by Ticket Number.");
			String userChoose = input.next();
			//switch case 
			List<Person> tempR = null;
			switch(userChoose)
			{
				case "N":
					while(!(peopleNum == 0))
					{
						//by name
						
						String name = input.next();
						tempR.add(new Person(name,-1));
						peopleNum--;
					}
					try {
						security.removePerson(tempR);
					} catch (PersonNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "T":
					while(!(peopleNum == 0))
					{
						//by name
						int ticketNum = input.nextInt();
						tempR.add(new Person("", ticketNum));
						peopleNum--;
					}
					try {
						security.removePerson(tempR);
					} catch (PersonNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("Not a valid choice.");
					break;
			}
			break;
		case "P":
			security.printSecurityCheck();
			break;
		case "PR":
			security.printSecurityCheckBackwards();
			break;
		case "Q":
			System.out.println("Quitting program... Bye!");
			input.close();
			System.exit(0);
			break;
		default: 
			System.out.println("Invalid choice.");
			statementPrint();
			break;
		}
		
	}


}
