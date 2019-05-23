package homework3;

public class BooksStack {

	int size; 
	final int CAPACITY = 1000;
	public Book[] books; 

	/**
	 * @return the books
	 */
	public Book[] getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Book[] books) {
		this.books = books;
	}

	//public BooksStack bookS;
	public BooksStack()
	{
		books = new Book[CAPACITY];
		size = -1;//empty 
	}
	
	/**
	 * @param pushes new book into stack of books
	 * @throws BookAlreadyExistsException if already there 
	 */
	public void push(Book newBook) throws BookAlreadyExistsException //add the books
	{
		boolean alreadyIn = false;
		//compare book and if same
		int i = 0;
		while(i <= this.getSize())
		{
			if(books[i].compare(newBook))
			{
				alreadyIn = true;
				throw new BookAlreadyExistsException("Book is in there already!");
			}
			i++;
		}
		
		if (this.getSize() >= -1 && !alreadyIn)
		{
			//add book on top
			this.setSize(this.getSize()+1);
			books[this.getSize()] = newBook;
		}
		
	}
	/**
	 * @param gets the first book on top stack of books and removes it
	 * @throws EmptyStackException if its empty
	 * @returns first book on top
	 */
	public Book pop() throws EmptyStackException //needs to move one up
	{
		if(this.getSize() == -1)
		{
			throw new EmptyStackException("The stack is empty! Nothing is here.");
		}
		else
		{
			Book first = books[this.getSize()]; //top and store
			//move everything one up
			this.setSize(this.getSize()-1);//delete the top one 
		//	books[this.size] = null;
			return first;
		}
	}
	/**
	 * @param gets the first book on top stack of books
	 * @throws EmptyStackException if its empty
	 * @returns first book on top
	 */
	public Book peek() throws EmptyStackException
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException("The stack is empty! Nothing is here.");
		}
		else
		{
			return books[size];
		}
	}
	/**
	 * @returns boolean if its empty or not
	 */
	public boolean isEmpty() 
	{
		if(this.size == -1)
		{
			return true;
		}
		return false;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @param sorts by name
	 */
	public void sortName()
	{
		 int marker;
		 int i;
		 int temp = 0;
	     marker = 0;
	     i = 1;
	     while (marker < this.getSize() - 1) 
	     {
            if (i == this.getSize()) 
            {
                marker++;
                i = marker;
            }

            if (books[marker].getName().compareTo(books[i].getName()) > 0) 
            {
                books[temp] = books[marker];
                books[marker] = books[i];
                books[i] = books[temp];
            }

            i++;
	     }
	}
	/**
	 * @param sorts by author
	 */
	public void sortAuthor()
	{
		 int marker;
		 int i;
		 int temp = 0;
	     marker = 0;
	     i = 1;
	     while (marker < this.getSize() - 1) 
	     {
            if (i == this.getSize()) 
            {
                marker++;
                i = marker;
            }

            if (books[marker].getAuthor().compareTo(books[i].getAuthor()) > 0) 
            {
                books[temp] = books[marker];
                books[marker] = books[i];
                books[i] = books[temp];
            }

            i++;
	     }
	}
	/**
	 * @param sorts by isbn
	 */
	public void sortISBN()
	{
		 int marker;
		 int i;
		 int temp = 0;
	     marker = 0;
	     i = 1;
	     while (marker < this.getSize() - 1) 
	     {
            if (i == this.getSize()) 
            {
                marker++;
                i = marker;
            }

            if (books[marker].getISBN() > books[i].getISBN())  //compare the ISBNs 
            {
                books[temp] = books[marker]; //we're swapping temp and marker 
                books[marker] = books[i];
                books[i] = books[temp];
            }

            i++;
	     }

	}
	/**
	 * @param sorts by year
	 */
	public void sortYear()
	{
		 int marker;
		 int i;
		 int temp = 0;
	     marker = 0;
	     i = 1;
	     while (marker < this.getSize() - 1) 
	     {
            if (i == this.getSize()) 
            {
                marker++;
                i = marker;
            }

            if (books[marker].getYear() > books[i].getYear()) 
            {
                books[temp] = books[marker];
                books[marker] = books[i];
                books[i] = books[temp];
            }

            i++;
	     }

	}
	/**
	 * @param sorts by condition
	 */
	public void sortCondition()
	{
		//put new first 
		//.compareToIgnoreCase(x.get(j)) > 0
		 int marker;
		 int i;
		 int temp = 0;
	     marker = 0;
	     i = 1;
	     while (marker < this.getSize() - 1) 
	     {
            if (i == this.getSize()) 
            {
                marker++;
                i = marker;
            }

            if (books[marker].getCondition().name().compareTo(books[i].getCondition().name()) > 0) 
            {
                books[temp] = books[marker];
                books[marker] = books[i];
                books[i] = books[temp];
            }

            i++;
	     }
		
	}
	/**
	 * @param sorts by genre
	 */
	public void sortGenre()
	{
		//sort by alphabet i guess just group genres together
		 int marker;
		 int i;
		 int temp = 0;
	     marker = 0;
	     i = 1;
	     while (marker < this.getSize() - 1) 
	     {
            if (i == this.getSize()) 
            {
                marker++;
                i = marker;
            }

            if (books[marker].getGenre().compareTo(books[i].getGenre()) > 0) 
            {
                books[temp] = books[marker];
                books[marker] = books[i];
                books[i] = books[temp];
            }

            i++;
	     }
	}

}
