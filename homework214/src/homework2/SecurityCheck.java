package homework2;

import java.util.List;

public class SecurityCheck {
	//doubly linked list by using two lines
		Line lineA;
		Line lineB;
		
		public SecurityCheck() {
			// TODO Auto-generated constructor stub
			lineA = new Line();
			lineB = new Line();
		}
		
		public void addPerson(List<Person> addPersonList)
		{
			//adds person in any line BALANCING
			//check the number people in each and add to the lowest 
			for(int i = 0; i < addPersonList.size()-1; i++)
			{
				if(lineA.listLength() >= lineB.listLength())
				{
					lineA.addPerson(addPersonList.get(i).getName(),addPersonList.get(i).getTicketNo());
				}
				else //lineA.listLength() < lineB.listLength()
				{
					lineB.addPerson(addPersonList.get(i).getName(),addPersonList.get(i).getTicketNo());
				}
			}
			
		}
		public void removePerson(List<Person> removePersonList) throws PersonNotFoundException
		{
			//remove and balance
			for(int i = 0; i < removePersonList.size()-1; i++)
			{
		/*		boolean nameThereA = lineA.listSearchName(removePersonList.get(i).getName());
				boolean nameThereB = lineB.listSearchName(removePersonList.get(i).getName());
				boolean numThereA = lineA.listSearchNumber(removePersonList.get(i).getTicketNo());
				boolean numThereB = lineB.listSearchNumber(removePersonList.get(i).getTicketNo());*/
				//check which one has it then remove
				//if both have it then choose line A
				if(lineA.listLength() >= lineB.listLength() )
				{
					if(removePersonList.get(i).getName() == "" && removePersonList.get(i).getTicketNo() != -1)
					{
						lineA.removePerson(removePersonList.get(i).getTicketNo());
					}
					if(removePersonList.get(i).getName() != null && removePersonList.get(i).getTicketNo() == -1)
					{
						lineA.removePerson(removePersonList.get(i).getName());
					}
				}
				else //lineA.listLength() < lineB.listLength()
				{
					if(removePersonList.get(i).getName() == "" && removePersonList.get(i).getTicketNo() != -1)
					{
						lineB.removePerson(removePersonList.get(i).getTicketNo());
					}
					if(removePersonList.get(i).getName() != null && removePersonList.get(i).getTicketNo() == -1)
					{
						lineB.removePerson(removePersonList.get(i).getName());
					}
				}
			}
			
		}
		
		public void printSecurityCheck()
		{
			//set cursor at head
			lineA.setCursor(lineA.getHead());
			
			System.out.println("          <b>Line A: </b>          " 
			+ "\n" + "   Name    |    Ticket Number  " + "\n");
			//what if they're empty
			while(lineA.getCursor() != null && lineA.getCursor().getNextPerson() != null) //next person is nothing 
			{
				System.out.println("     " + lineA.getCursor().getName() + "    " + lineA.getCursor().getTicketNo()
						+"    " + "\n");
				lineA.setCursor(lineA.cursor.getNextPerson());
			}
			
			lineB.setCursor(lineB.getHead());
			System.out.println("          <b>Line B: </b>          " 
			+ "\n" + "   Name    |    Ticket Number  " + "\n");
			
			while(lineB.getCursor() != null && lineB.getCursor().getNextPerson() != null) //next person is nothing 
			{
				System.out.println("     " + lineB.getCursor().getName() + "    " + lineB.getCursor().getTicketNo()
						+"    " + "\n");
				lineB.setCursor(lineB.cursor.getNextPerson());
			}
			
		}
		
		public void printSecurityCheckBackwards()
		{
			//start from the back and go backwards
			lineA.setCursor(lineA.getTail());
			System.out.println("          <b>Line A (Reverse Order): </b>          " 
			+ "\n" + "   Name    |    Ticket Number  " + "\n");
			//what if they're empty
			while(lineA.getCursor() != null && lineA.getCursor().getPrevPerson() != null) //next person is nothing 
			{
				System.out.println("     " + lineA.getCursor().getName() + "    " + lineA.getCursor().getTicketNo()
						+"    " + "\n");
				lineA.setCursor(lineA.cursor.getPrevPerson());
			}
			
			lineB.setCursor(lineB.getTail());
			System.out.println("          <b>Line B (Reverse Order): </b>          " 
			+ "\n" + "   Name    |    Ticket Number  " + "\n");
			
			while(lineB.getCursor() != null && lineB.getCursor().getPrevPerson() != null) //next person is nothing 
			{
				System.out.println("     " + lineB.getCursor().getName() + "    " + lineB.getCursor().getTicketNo()
						+"    " + "\n");
				lineB.setCursor(lineB.cursor.getPrevPerson());
			}
			
		}
}
