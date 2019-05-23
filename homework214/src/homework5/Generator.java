package homework5;

import java.util.Scanner;

public class Generator {
	
	/**
	 * 
	 * @param args
	 * main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//use a cusor to see where you are and the cursor can be the index number 
		//so if they're at homepage (0) and they want the next department cursor *= 10;
		//the subdepartment can be; cursor ++;
		//head department is 
		WebSite siteMan = new WebSite();
		WebPage cursor = siteMan.getHomePage(); 
		
		System.out.println("Starting Up... " + "\n" + "(I) - Import From File" + "\n" + "(A) – Add Department" 
				+ "\n" + "(R) – Remove Department"
				+ "\n" + "(C) – Current Department"
				 + "\n" + "(G) – Go to Sub-Department" +"\n"+ "(H) – Head Department" + "\n"+
				"(P) – Print Format" + "\n" + "(E) – Empty Tree" + "\n" +
				 "(Q) – Quit"); 
					System.out.println("Please Select an Option: ");
					
					boolean workP = false;
					Scanner input = new Scanner(System.in);
					String chosenMenu = input.nextLine();
					
					do
					{
						if (workP) 
						{
							input = new Scanner(System.in);
								System.out.println("Starting Up... " + "\n" + "(I) - Import .txt File" + "\n" + "(A) – Add Department" 
									+ "\n" + "(R) – Remove Department"
									+ "\n" + "(C) – Current Department"
									 + "\n" + "(G) – Go to Sub-Department" +"\n"+ "(H) – Head Department" + "\n"+
									"(P) – Print Format" + "\n" + "(E) – Empty Tree" + "\n" +
									 "(Q) – Quit"); 
							System.out.println("Please Select an Option: ");
							chosenMenu = input.next();
						}
						
						if(chosenMenu.equalsIgnoreCase("I"))
						{
								System.out.println("Please enter a location for text file. Format should be 'name.txt':");
								String locationI = input.next();
							
								siteMan = siteMan.buildTree(locationI);
								System.out.println("Sucessfully built.");
								
						}
						if(chosenMenu.equalsIgnoreCase("A"))
						{
							System.out.println("Please state what you're adding.");
							try {
								siteMan.addDepartment(cursor, input.next());
							} catch (SiteAlreadyExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(chosenMenu.equalsIgnoreCase("R"))
						{
							System.out.println("You are removing the current department you are at: " + cursor.getName()); 
							try {
								siteMan.removeDepartment(cursor);
							} catch (SiteNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}
						if(chosenMenu.equalsIgnoreCase("C"))
						{
							System.out.println("You are currently at: " + cursor.getName());
						}
						if(chosenMenu.equalsIgnoreCase("G"))
						{
							if(cursor.getLinks().length < 0)
							{
								System.out.println("There are no more Sub Departments.");
							}
							else
							{
							System.out.print("You have the following options: ");
							//for loop the links and use the input as the index 
							//start at 0 
								for(int i = 0; i < cursor.getLinks().length; i++)
								{
									System.out.println("(" + Integer.toString(i) + ")-" +
											cursor.links[i].getName());
								}
							}
							
							int chosenSubDepart = input.nextInt(); //0 to however many nums
							
							cursor = cursor.links[chosenSubDepart]; 
							
						}
						if(chosenMenu.equalsIgnoreCase("H"))
						{
							//Head Department 
							//search from the root's head
							//start from head and look at their links and see if their links has the current department 
							cursor = cursor.getRoot();
							System.out.println("The home page is: " + cursor.getName());
							System.out.println("You are at: " + cursor.getName());
							
						}
						if(chosenMenu.equalsIgnoreCase("P"))
						{
							if(siteMan != null || (siteMan.isEmpty()))
							{
								System.out.println("There's no tree." + "\n");
							}
							else
							{
								try {
									throw new SiteNotFoundException();
								} catch (SiteNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						if(chosenMenu.equalsIgnoreCase("E"))
						{
							//empty the tree 
							siteMan = new WebSite();
							System.out.println("The Tree is now empty.");
							
							siteMan.printFormat(siteMan.homePage, " ");
						}
						workP = true;
					}
					while(!(chosenMenu.equalsIgnoreCase("Q")));
					if(chosenMenu.equalsIgnoreCase("Q"))
					{
						System.out.println("Quitting program... Bye!");
						
						input.close();
						System.exit(0);
					}
					input.close();
						
	}

}
