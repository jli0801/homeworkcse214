package homework3;
import java.util.Scanner;
public class LibraryManager {

	BooksStack stackingBooks;
	BooksStack tempBooks;
	
	public static void main(String[] args) throws EmptyStackException, BookAlreadyExistsException {
		LibraryManager libMan = new LibraryManager();
		libMan.setStackingBooks(new BooksStack());
		libMan.setTempBooks(new BooksStack());
		
				System.out.println("Starting Up... " + "\n" + "(A) - Add Book" + "\n" +"(R) - Remove" + "\n"+ "(G) – See Book (Top)" 
				+ "\n" + "(P) – Print Books"
				+ "\n" + "(S) – Sort Books By" +"\n" +
				"(Q) – Quit"); 
				
					System.out.println("Please Select an Option: ");
					
					boolean workP = false;
					Scanner input = new Scanner(System.in);
					String chosenMenu = input.next();
					
					do
					{
						
						if (workP) 
							{
									System.out.println("Menu:" + "\n" + "(A) - Add Book" + "\n" + "(G) – See Book (Top)" 
									+"\n"+ "(R) - Remove" 
									+ "\n" + "(P) – Print Books"
									+ "\n" + "(S) – Sort Books By" +"\n" +
									"(Q) – Quit"); 
									
									System.out.println("Please Select an Option: ");
									chosenMenu = input.next();
									workP = false;
							}
						if(chosenMenu.equalsIgnoreCase("A"))
						{
							System.out.println("Title: ");
							String titleIn = input.next();
							
							System.out.println("Author: ");
							String authorIn = input.next();
							
							System.out.println("Genre: ");
							String genreIn = input.next();
							
							System.out.println("Year: ");
							int yearIn = input.nextInt();
							
							System.out.println("ISBN: ");
							long isbnIn = input.nextLong();
							
							System.out.println("Condition: ");
							//if they say new or old you have to cast it to a condition
							String conIn = input.next(); 
							
							if(conIn.equalsIgnoreCase("new"))
							{
								libMan.stackingBooks.push(new Book(isbnIn, yearIn, titleIn,authorIn,genreIn, Condition.NEW));
								System.out.println("Added!");
							}
							else if(conIn.equalsIgnoreCase("old"))
							{
								
								libMan.stackingBooks.push(new Book(isbnIn, yearIn, titleIn,authorIn,genreIn, Condition.OLD));
								System.out.println("Added!");
							}
						//	libMan.printTable();
						}
						else if (chosenMenu.equalsIgnoreCase("R"))
						{
							System.out.println("Please enter title of book to remove it or enter (T) to remove the top.");
							String titleRemove = input.next();
							boolean removed = false;
							if(titleRemove.compareToIgnoreCase("T") == 0)
							{
								libMan.stackingBooks.pop();
								System.out.println("Removed the book on top.");
							}
							else
							{
								int storeSize = libMan.stackingBooks.getSize();
								int storeTemp = storeSize;
								//search for the first book in stack w/ that name 
								for(int i = 0; i <= storeSize; i++)
								{
									
										if(libMan.stackingBooks.peek().getName().equalsIgnoreCase(titleRemove))
										{
											libMan.stackingBooks.pop();
											removed = true;
											System.out.println("Yes removed"); 
										}
										else
										{
											libMan.tempBooks.push(libMan.stackingBooks.pop());
										}
								}
								for(int j = 0; j <= storeTemp; j++)
								//now push temp back into stackingBooks
								{
									libMan.stackingBooks.push(libMan.tempBooks.pop());
								}
								
								if(removed)
								{
									System.out.print("Removed Sucessfully!");
								}
								else
								{
									System.out.println("Unable to remove.");
								}
							}
							
						}
						else if (chosenMenu.equalsIgnoreCase("G"))
						{
							libMan.stackingBooks.peek().toString();
							
						//	libMan.printTable();
						}
						else if (chosenMenu.equalsIgnoreCase("P"))
						{
						//	System.out.println("yes");
						//	System.out.println(libMan.stackingBooks.peek().toString()); //works 
							//libMan.printTable();
								if(libMan.stackingBooks.getSize() == -1)
								{
									throw new EmptyStackException("There are no books here.");
								}
								else
								{
									System.out.println("  " + "ISBN" + "  |  " + "Year" + "  |  " + "Name" +
									"   |  " + "Author" + "   |   " + "Genre" + "   |   " + "Condition" +
									"   |");
								//	System.out.println(Integer.toString(libMan.stackingBooks.getSize()));
									int storeSize = libMan.stackingBooks.getSize();
									
									int storeSizeTemp = libMan.tempBooks.getSize();
									for(int i = 0; i <= storeSize; i++)
									{
											System.out.println(libMan.stackingBooks.peek().toString()); //but that the first only so 
											libMan.tempBooks.push(libMan.stackingBooks.pop()); //push into temp and now we can move on 
											//we need to store it and put it somewhere 
									
									}
									//our main stack is empty now 
									for(int j = 0; j <= storeSizeTemp; j++)
									{		
										libMan.stackingBooks.push(libMan.tempBooks.peek());
										libMan.tempBooks.pop(); //just pop the book out 
									}
								}
						}
						else if(chosenMenu.equalsIgnoreCase("S"))
						{
							System.out.println("How would you like to sort it? " + "\n"
						+ "(N) - Name " +  "\n" + "(A) - Author" +  "\n" + "(G) - Genre"
						+  "\n" + "(Y) - Year" + "\n" + "(C) - Condition" +  "\n" + "(I) - ISBN");
							String chosenMenuSort = input.next();
							if(chosenMenuSort.equalsIgnoreCase("A"))
							{
								libMan.stackingBooks.sortAuthor();
							}
							else if(chosenMenuSort.equalsIgnoreCase("N"))
							{
								libMan.stackingBooks.sortName();
							}
							else if(chosenMenuSort.equalsIgnoreCase("G"))
							{
								libMan.stackingBooks.sortGenre();
							}
							else if(chosenMenuSort.equalsIgnoreCase("Y"))
							{
								libMan.stackingBooks.sortYear();
							}
							else if(chosenMenuSort.equalsIgnoreCase("C"))
							{
								libMan.stackingBooks.sortCondition();
							}
							else if(chosenMenuSort.equalsIgnoreCase("I"))
							{
								libMan.stackingBooks.sortISBN();
							}
							else
							{
								System.out.println("Not a valid option.");
							}
							
							//after sorting print
						//	libMan.printTable();
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
	
	/**
	 * @return the stackingBooks
	 */
	public BooksStack getStackingBooks() {
		return stackingBooks;
	}

	/**
	 * @param stackingBooks the stackingBooks to set
	 */
	public void setStackingBooks(BooksStack stackingBooks) {
		this.stackingBooks = stackingBooks;
	}

	/**
	 * @return the tempBooks
	 */
	public BooksStack getTempBooks() {
		return tempBooks;
	}

	/**
	 * @param tempBooks the tempBooks to set
	 */
	public void setTempBooks(BooksStack tempBooks) {
		this.tempBooks = tempBooks;
	}
	/**
	 * @param prints table
	 */
	public void printTable() throws EmptyStackException, BookAlreadyExistsException
	{
		
		if(stackingBooks.getSize() == -1)
		{
			throw new EmptyStackException("There are no books here.");
		}
		else
		{
			System.out.println("  " + "ISBN" + "  |  " + "Year" + "  |  " + "Name" +
			"   |  " + "Author" + "   |   " + "Genre" + "   |   " + "Condition" +
			"   |");
		//	System.out.println(Integer.toString(libMan.stackingBooks.getSize()));
			int storeSize = stackingBooks.getSize();
			
			int storeSizeTemp = tempBooks.getSize();
			for(int i = 0; i <= storeSize; i++)
			{
					System.out.println(stackingBooks.peek().toString()); //but that the first only so 
					tempBooks.push(stackingBooks.pop()); //push into temp and now we can move on 
					//we need to store it and put it somewhere 
			
			}
			//our main stack is empty now 
			for(int j = 0; j <= storeSizeTemp; j++)
			{		
				stackingBooks.push(tempBooks.peek());
				tempBooks.pop(); //just pop the book out 
			}
		}
	}
	/**
	 * @param removes by title
	 */
	public boolean remove(String title) throws EmptyStackException, BookAlreadyExistsException
	{
		boolean removed = false;
		int storeSize = stackingBooks.getSize();
		int storeTemp = tempBooks.getSize();
		//search for the first book in stack w/ that name 
		for(int i = 0; i <= storeSize; i++)
		{
			
				if(!(stackingBooks.peek().getName().equalsIgnoreCase(title)))
				{
					tempBooks.push(stackingBooks.pop()); //push into temp
					//if it's never found then it'll be false
					//only turns true if they found the book 
				}
				else
				{
					//found the book 
					stackingBooks.pop();
					removed = true;
					//this code will remove all instances of the title.
				}
		}
		for(int j = 0; j <= storeTemp; j++)
		//now push temp back into stackingBooks
		{
				stackingBooks.push(tempBooks.peek());
				tempBooks.pop(); //just pop the book out 
			
		}
		return removed;
	}

}
