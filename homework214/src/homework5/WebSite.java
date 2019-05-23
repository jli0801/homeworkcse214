package homework5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//represents each TREE FOR EACH WEBSITE 
public class WebSite {
//contains homepage, prints all links
	WebPage homePage; //ROOT
	
	int height; 
	int size; 
	int cursor = 0; //at THE ROOT CURRENTLY can only go to the departments and use it
	//as in index 
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	
	//so for the homepage then the home page is amazon
	//and under it is departments
	
	//for departments the homepage is still amazon
	//so for TEXFILE 1 there will be four trees that means there are 4 websites and the home page is 
	
	WebPage[] departmentsOnly = new WebPage[500];
	//so it could be like at 0 - amazon
	//1,2,3,4 are departments 
	//inbetween 1 and 2 are like 20 spaces and to put them there 
	//for the number you could do: 11%(departmentNumber*10) = 1
	//1+departmentNumber
	
	//this class represents each tree 
	/**
	 * 
	 * @param homeSite
	 */
	public WebSite(String homeSite) {
		// TODO Auto-generated constructor stub
		homePage.setName(homeSite);
	}
	public WebSite()
	{
		
	}
	/**
	 * 
	 * @param cursor
	 * @param name
	 * @throws SiteAlreadyExistsException
	 */
	public void addDepartment(WebPage cursor, String name) throws SiteAlreadyExistsException
	{
		//make another webpage for website 
		//add it to the end 
		WebPage department = new WebPage(name, this.getHomePage());
		
		if(cursor.findCursor(department) == -1)
		{
			cursor.getRoot().links[homePage.getLinksLen()] = department; //end 
		}
		else
		{
			throw new SiteAlreadyExistsException ("Site is already in there.");
		}
	
	}
	/**
	 * @return the homePage
	 */
	public WebPage getHomePage() {
		return homePage;
	}
	/**
	 * @param homePage the homePage to set
	 */
	public void setHomePage(WebPage homePage) {
		this.homePage = homePage;
	}
	/**
	 * 
	 * @param cursor
	 * @throws SiteNotFoundException
	 * removes department
	 */
	public void removeDepartment(WebPage cursor) throws SiteNotFoundException
	{
		//remove everything under the department 
		cursor.getLinks()[cursor.getRoot().findCursor(cursor)] = null;
		cursor.setLinks(new WebPage[10]);
		
	}
	/**
	 * 
	 * @return boolean if empty
	 */
	public boolean isEmpty()
	{
		return (this.homePage.getLinksLen() == 0);
	}
	/**
	 * 
	 * @param node
	 * @param append
	 * @returns printed tree recursively
	 */
	public void printFormat(WebPage node, String append) //append would be " "
	{
		//print head first
		
		//base case 
		System.out.println(append + node.getName()); // root 
		
		WebPage[] links = node.getLinks();
		for(int i = 0; i < links.length; i++)
		{
			printFormat(links[i], append+append); //recursive 
		}
	}
	/**
	 * 
	 * @param location
	 * @return WebSite
	 * @throws IllegalArgumentException
	 */
	public WebSite buildTree(String location) throws IllegalArgumentException
	{
		//return a version of itself 
		//WebPage[] wholeSite = new WebPage[500]; //ALL CHILDREN
		
		WebSite mainSite = new WebSite();
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

			
			Scanner input = new Scanner(file);
			int i = 0;
			
			input.nextLine();
			while (input.hasNextLine()) 
			{
				String line = input.nextLine();
				String[] hold = line.split("\\s+");  //if you split by space and \n 
				//.split(" "); 
				
				//then n = 0; n is the number and n+1 is the string
				
				for (int k = 0; k < hold.length; k++) 
				{
					hold[k] = hold[k].trim(); 
				}
				
				
				mainSite.homePage  = new WebPage(hold[0], null); //root
				//.substring(2,hold[0].length())
				//, Integer.parseInt(hold[hold.length].substring(0,1))
				int n = 0;
				while(n < hold.length -1)
				{
					String indexNumber = hold[n].replaceAll("[^0-9]", ""); //just use hold[1]
					//replaceAll("[^0-9]", "");
					String name = hold[n+1]; //should be okay 
					
					if(indexNumber.length() < 3 ) //1,2 should be the child
					{
						//means its a department 
						mainSite.homePage.links[Integer.parseInt(indexNumber)] = new WebPage(name, mainSite.getHomePage());
					}
					else
					{
						//child 
						mainSite.homePage.links[Integer.parseInt(indexNumber.substring(1, 2))].links[Integer.parseInt(indexNumber.substring(2))] 
								= new WebPage(name, mainSite.homePage.links[Integer.parseInt(indexNumber.substring(1,2))] );
						
						//Integer.parseInt(indexNumber.substring(0,3))
					}
					
					n += 2;
				}
				
				//hold[0].substring(1, hold[0].length()-1)
				//wholeSite[0] = new WebPage(name, indexNumber)
			//	wholeSite[i] = new WebPage(name,indexNumber);
				
			}
			input.close();
			//WebSite websiteHome = this.formatTree(wholeSite);
			//instead of that use:
			return mainSite;		
		} 
		catch (IOException ex) {
			throw new IllegalArgumentException("Please make sure the file is valid! Try again.");
		}
	}
	
	
	
}
