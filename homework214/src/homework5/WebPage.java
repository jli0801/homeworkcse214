package homework5;


//represents each node 
public class WebPage {
	String name; 
	WebPage[] links; //use mod ten to put into array 
	WebPage root;
	/**
	 * @return the root
	 */
	public WebPage getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot(WebPage root) {
		this.root = root;
	}
	/**
	 * @param links the links to set
	 */
	public void setLinks(WebPage[] links) {
		this.links = links;
	}
	/**
	 * @return the links
	 */
	public WebPage[] getLinks() {
		return links;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return int of all used Links
	 */
	public int getLinksLen()
	{
		int n = 0;
		for(int i = 0 ; i < links.length; i++)
		{
			if(links[i] != null)
			{
				n++;
			}
		}
		return n;
	}
	
	
	/**
	 * 
	 * @param name
	 * @param home
	 * Constructor
	 */
	public WebPage(String name, WebPage home) {
		// TODO Auto-generated constructor stub
		setName(name);
		setRoot(home);
		links = new WebPage[10]; 
		//could make it larger or smaller 
	}
	/**
	 * 
	 * @param target
	 * @return index of found cursor and -1 if not found 
	 */
	public int findCursor(WebPage target)
	{
		WebPage[] linkTemp = this.getLinks();
		int targetFound = -1;
		for(int i = 0; i < linkTemp.length; i++)
		{
			if(linkTemp[i].getName().compareToIgnoreCase(target.getName()) == 0)
			{
				//found it!!
				targetFound = i;
			}
		}
		return targetFound;
	}
	
	/**
	 * 
	 * @return String of all links spaced out 
	 */
	public String returnallLinks()
	{
		String linkString = " ";
		for (int i =0; i < links.length; i ++)
		{
			linkString += links[i].getName() + " \n";
		}
		return linkString; 
	}

}
