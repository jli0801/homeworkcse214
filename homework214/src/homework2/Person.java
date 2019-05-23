package homework2;

public class Person {


	String name;
	int ticketNo;
	Person nextPerson; //person link
	Person prevPerson; //person link

	public Person(String n, int tN) {
		// TODO Auto-generated constructor stub
		name = n;
		ticketNo = tN;
		nextPerson = null;
		prevPerson = null;
		/*, Person nP, Person pP*/
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Person getNextPerson() {
		return nextPerson;
	}

	public void setNextPerson(Person nextPerson) {
		this.nextPerson = nextPerson;
	}

	public Person getPrevPerson() {
		return prevPerson;
	}

	public void setPrevPerson(Person prevPerson) {
		this.prevPerson = prevPerson;
	}

}
