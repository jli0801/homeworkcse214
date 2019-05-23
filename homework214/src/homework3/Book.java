package homework3;

enum Condition {
  OLD,
  NEW
}
public class Book {

	long ISBN;
	int year;
	String name;
	String author;
	String genre;
	Condition condition;
	public Book (long isbn, int yearU, String title, String authorU, String genreU, Condition conditionUser){
		setISBN(isbn);
		setYear(yearU);
		setName(title);
		setAuthor(authorU);
		setGenre(genreU);
		
		this.condition = conditionUser;
	}
	/**
	 * @return the iSBN
	 */
	public long getISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(long iSBN) {
		this.ISBN = iSBN;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
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
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the condition
	 */
	public Condition getCondition() {
		return condition;
	}
	/**
	 * @return an int.
	 * 1 for New and 0 for Old
	 * @param sorts by name
	 */
	public int compareCondition(Condition con)
	{
		if(con.name().compareTo("NEW") == 1)
		{
			return 1;
		}
		else
		{
			//OLD 
			return 0;
		}
	}
	
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(Condition conditionU) {
		this.condition = conditionU;
	}
	//Level myVar = Level.MEDIUM;
	//ISBN;
	//int year;
	//String name;
	//String author;
	//String genre;
	//Condition condition;
	/**
	 * @return characteristics of book in tabular form
	 */
	public String toString()
	{
		return "  " + Long.toString(getISBN()) + "  |  " + Integer.toString(getYear()) + "  |  " + getName() +
				"   |  " + getAuthor() + "   |   " + getGenre() + "   |   " + getCondition() +
				"   |";
	}
	/**
	 * @return boolean if the two are the same
	 * @param a book to compare to this book
	 */
	public boolean compare(Book comparedTo)
	{
		if(this.getAuthor().equalsIgnoreCase(comparedTo.getAuthor()) && 
				this.getName().equalsIgnoreCase(comparedTo.getName()) &&
				this.getGenre().equalsIgnoreCase(comparedTo.getGenre()) &&
				(this.getISBN() == comparedTo.getISBN()) && (this.getYear() == comparedTo.getYear())
				&& (this.getCondition() == comparedTo.getCondition()))
				{
			return true;
				}
		else
		{
			return false;
		}
	}
	
}
