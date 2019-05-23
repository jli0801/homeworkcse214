package homework2;

public class Line {

	Person head;
	Person tail;
	Person cursor;
	public Line() {
		// TODO Auto-generated constructor stub
		head = null;
		tail = null;
		cursor = null; 
	}
	
	public Person getHead() {
		return head;
	}


	public Person getTail() {
		return tail;
	}

	public Person getCursor() {
		return cursor;
	}

	public void setHead(Person head) {
		this.head = head;
	}

	public void setTail(Person tail) {
		this.tail = tail;
	}

	public void setCursor(Person cursor) {
		this.cursor = cursor;
	}

	public void addPerson(String name, int ticketNo)
	{
		//add to the back 
		if(head == null && cursor == null)
		{
			head = new Person (name, ticketNo);
			cursor = head;
			tail = head;
		}
		else
		{
			//just add to the tail b/c not sorted
			while(!(cursor.getNextPerson() == tail))
			{
				cursor = cursor.getNextPerson(); //traverse 
			}
			//after while cursor should be before tail 
			Person newPerson = new Person (name, ticketNo);
			newPerson.setPrevPerson(cursor);
			newPerson.setNextPerson(null);
			tail = newPerson;
		}
	}
	//can have multiple names 
	public void removePerson (String name) throws PersonNotFoundException
	{
		//cases: front, back, none exsistent, any other place 
		boolean found = listSearchName(name);
		if(found)
		{
			//remove
			cursor.getPrevPerson().setNextPerson(cursor.getNextPerson());
			cursor.setPrevPerson(null);
			cursor.setNextPerson(null);
			resetCursor();
		}
		else
		{
			throw new PersonNotFoundException("Person Not Found.");
		}
	}
	//ask for confirmation for this one b/c can have multiple names 

	public void removePerson (int ticketNo) throws PersonNotFoundException
	{
		//cases: front, back, none exsistent, any other place 
		boolean found = listSearchNumber(ticketNo);
		if(found)
		{
			cursor.getPrevPerson().setNextPerson(cursor.getNextPerson());
			cursor.setPrevPerson(null);
			cursor.setNextPerson(null);
			resetCursor();
		}
		else
		{
			throw new PersonNotFoundException("Person Not Found.");
		}
	}
	
	public void resetCursor ()
	{
		cursor = head;
	}
	
	public boolean isEmpty()
	{
		return (cursor == null);
	}
	public int listLength()
	{
		//Person headNode = head;
		cursor = head;
		int answer = 0;
		while (cursor != null) 
		{
			answer++;
			cursor = cursor.getNextPerson();
		}
		
		return answer;
	}
	public boolean listSearchName(String name) 
	{
		Person headNode = head;
		while (headNode != null) {
		if (name == headNode.getName()) 
		{
			cursor = headNode;
			return true;
		}
		headNode = headNode.getNextPerson();
		}
		return false;
	}
	
	public boolean listSearchNumber(int number) 
	{
		Person headNode = head;
		while (headNode != null) {
		if (number == headNode.getTicketNo()) 
		{
			cursor = headNode;
			return true;
		}
		headNode = headNode.getNextPerson();
		}
		return false;
	}
	//maybe have one with both? would make more sense. 

}
