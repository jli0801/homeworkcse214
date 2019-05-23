package homework4;
import java.util.Scanner;

public class Simulator {


		//what we're gonna do is while (numberMin <= 30)
		//simulate some people coming and going and when its numberMin = 20
		//then a new flight arrives (generate random place and increase the numberArrived)
		//add the two ints to get the total number of airplanes 
	/**
	 * 
	 * @param args
	 * @void runs the simulation of the program
	 */
	public static void main(String[] args) {
		
		String[] names = {"Amanda", "Alice", "Alan", "Adam", 
				"Brian", "Brandon", "Bob", "Beth",
				"Cathy", "Clarence", "Clarie", "Cole",
				"Dorothy", "Dan", "Darren", "Dahlia",
				"Eren", "Emily", "Evelyn", "Erik",
				"Fred", "Florence", "Fatima", "Faith",
				"Gabby", "George", "Gloria", "Gibby",
				"Hope", "Harrison", "Harry", "Hermione",
				"Imogene", "Ingrid", "Ian", "Ivan",
				"Jessica", "Jack", "James", "John",
				"Katy", "Katelyn", "Kelly", "Kelvin",
				"Liam", "Lia", "Lawerence", "Laurie",
				"Melissa", "Melvin", "Melanie", "Michelle",
				"Natalie", "Nathaniel", "Nicole", "Noel",
				"Owen", "Oliver", "Opal", "Ollie",
				"Penelope", "Peter", "Pam", "Patrick",
				"Quinn", "Quigley", "Quinston", "Quincy",
				"Rachel", "Raymond", "Ray", "Riley",
				"Sam", "Shan", "Selena", "Stanley",
				"Timothy", "Tod", "Tom", "Teressa",
				"Ulises", "Umar", "Ulysses", "Uriel",
				"Vivian", "Vicki", "Victor", "Vernon", 
				"Wen", "Wendy", "Wendall", "Will",
				"Xavier", "Xavi", "Xander", "Xerxes",
				"Yasmin", "Yvonne", "Yuki", "Yoshi",
				"Zack", "Zara", "Zoe", "Zelda"};
		
		String[] destination = {"England", "France", "Italy", "Africa", "Spain", 
				"Russia", "China", "South Korea", "Japan", "Thailand"};
		
		String[] classes = {"First", "Business Class", "Premium Economy Class", "Economy"};
		//10 to 14 are for user inputs
		//10 locations 0 to 15 length = 14
		
		Airplane[] airplaneTakingOff = new Airplane[20];
		Airplane[] airplaneArriving = new Airplane[20];
		PassengerQueue[] boarding = new PassengerQueue[20];
		
		double prob = 0.0;
		
		Scanner input = new Scanner(System.in);
		boolean menu = false; 
		boolean firstSetup = false;
		
		int numFlights = 0; //Number of flights waiting to take off
		int numArrived = 0; //Number of flights that landed
		//104 names - > length is 103 
		double numberMin = 0.0;
	 	
		boolean simulateDone = false;
		int airplanes = 0;
		int arrivingAirplane;
		int numberOfTimesAsked = 0;
		
		int simulate = 0;
		
		while(!menu)
		{
			if(!firstSetup)
			{
				System.out.println("Welcome to JFK Airport!" + "\n"); 
				System.out.println("Please enter the number of airplanes, taking off: ");
				airplanes = input.nextInt();
				
				System.out.println("Would you like to not set a destination (N) or input your own (Y)?");
				String userDes = input.next();
				
				if(userDes.equalsIgnoreCase("Y"))
				{
					int tempAirplanes = airplanes;
					while(tempAirplanes > 0)
					{
					System.out.println("Enter destination for flight#: " + Integer.toString(tempAirplanes));
					String flight0 = input.next();
					airplaneTakingOff[airplanes] = new Airplane(flight0, numberMin); //add airplane in there
					//make a Passenger Queue array
					boarding[airplanes] = new PassengerQueue(flight0);
					
					
					tempAirplanes--;
					}
					firstSetup = true; //only do this once in the beginning
				}
				else
				{
					numberOfTimesAsked++;
					
					while((numberOfTimesAsked < 5) && (userDes.equalsIgnoreCase("N")))
					{
						System.out.println("Would you like to not set a destination (N) or input your own (Y)?");
						userDes = input.next();
						numberOfTimesAsked++;
					}
					//ask
					if(numberOfTimesAsked >= 5)
					{
						System.out.println("Good bye!");
						input.close();
						System.exit(0);
					}
					
				}
				
				
			}
			else
			{
				
					System.out.println("Would you like to not set a destination (N) or input your own (Y)?");
					String userDes = input.next();
					
					if(userDes.equalsIgnoreCase("Y"))
					{
						int tempA = (int) (Math.random()*2 + airplanes); // don't go over the airplaces 
						while(tempA > airplanes)
						{
						System.out.println("Enter destination for flight#: " + Integer.toString(tempA));
						String flight0 = input.next();
						airplaneTakingOff[tempA] = new Airplane(flight0, numberMin); //add airplane in there 
						//make a Passenger Queue array
						boarding[airplanes] = new PassengerQueue(flight0);
						
						
						tempA--;
						}
					}
					else
					{
						numberOfTimesAsked++;
						
						while((numberOfTimesAsked < 5) && (userDes.equalsIgnoreCase("N")))
						{
							System.out.println("Would you like to not set a destination (N) or input your own (Y)?");
							userDes = input.next();
							numberOfTimesAsked++;
						}
						//ask
						if(numberOfTimesAsked >= 5)
						{
							System.out.println("Good bye!");
							input.close();
							System.exit(0);
						}
						//we're supposed to ask five times 
					}
					
					System.out.println("Enter arrival probability: ");
					prob = input.nextDouble();
					System.out.println("Enter duration of simulation: ");
					simulate = input.nextInt();
					
					menu = true;
					numberMin++;
					simulateDone = true;
				}
		}
		
		//ask for the menu again when a new flight comes 
		while(simulateDone)
		{
		if(numberMin < simulate-5)
		{
			while(numberMin%simulate <  simulate-5) //this is for adding people to passenger queue
			{
				while(airplanes > 0)
				{
					double randomSim = Math.random(); // 0 to 1
					int randomAirplane = (int)Math.random()*(airplanes-1);
					int randomName = (int)Math.random()*names.length;
					int randomClass = (int)Math.random()*classes.length;
					if(randomSim > 0.5)
					{
						boarding[randomAirplane].enqueue(new Passenger(names[randomName], boarding[randomAirplane].getDestination(),
								numberMin, classes[randomClass]));
					}
						//no one comes in 
				}
			}
		}
		
		while((numberMin%simulate ==  simulate-5)) //5 min left
		{
			for(int k = 0; k < airplanes; k++) //board everyone on and transfer
			{
				airplaneTakingOff[k].boardPlane(boarding[k]);
				boarding[k].dequeue();
			}
		}
		double randomNumProb = Math.random();
		while ((numberMin%20.0 == 0) && numberMin >= 20.0 && randomNumProb > prob)
		{
			int randomSim = (int)Math.random()*2;
			numArrived = randomSim;
			int randomDes = (int)Math.random()*destination.length;
			System.out.println("A new flight has arrived. Currently refeuling.");
			System.out.println("There are now " + Integer.toString(numFlights) + "planes departing.");
			System.out.println("There are now " + Integer.toString(numArrived) + "planes refeuling.");
			System.out.println("There are now " + Integer.toString(numArrived + numFlights) + "planes in total.");
			
			
			
			menu = false; 
		}
		
		while((numberMin%simulate == 0) && numberMin >= simulate)
		{
			System.out.println("Flight is taking off."); //remove the planes after 
			
			for(int j = 0; j < airplanes; j++)
			{
				System.out.println("Flight# " + Integer.toString(airplanes+1) + airplaneTakingOff[j].toString());
			}
		}
		
		System.out.println("Minute(s): " + Double.toString(numberMin));
		for(int j = 0; j < airplanes; j++)
		{
			System.out.println("Flight# " + Integer.toString(airplanes+1) + airplaneTakingOff[j].toString());
			for(int k = 0; k < airplaneTakingOff[airplanes].getCapacity(); k++)
			{
				System.out.println(airplaneTakingOff[k].toString()); //print the people
			}
		}
		
		numberMin++;
		
		}
		
	}

}
