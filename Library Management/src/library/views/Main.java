package library.views;


/**
 * The main class of our function - run this one, and you can use the system.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Main {
	public static ManageUsers students;
	
	public static void main(String[] args) {
		Startup.getXMLUserList();
		Startup.getXMLMaterials();
		
		Student ins = new Student ("Admin", "", 01, 0 , true, "admin", "admin",true);
		Student stu = new Student ("Student", "", 02, 6, true, "Student", "password", false);
		ManageUsers.getActiveList().add(ins);
		ManageUsers.getActiveList().add(stu);


		Book harry = new Book("Book", "Harry Potter", "Rowling", false, 0);
		ManageUsers.getMaterialList().add(harry);
		Material chair2 = new Material("Chair", "IKEA-2a1", true, 1);
		ManageUsers.getMaterialList().add(chair2);
		Material chair = new Material("Chair", "IKEA-261", true, 2);
		ManageUsers.getMaterialList().add(chair);
		Book percy = new Book("Book", "Percy Jackson", "Riordan", false, 3);
		ManageUsers.getMaterialList().add(percy);
		Book ref = new Book("Book", "Maps of Africa", "Zinetti", true, 4);
		ManageUsers.getMaterialList().add(ref);
		Material lap = new Material("Laptop", "Chromebook", true, 5);
		ManageUsers.getMaterialList().add(lap);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//calculate the deadline date
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 2, 23);
		Date deadline = null;
		try {
			deadline = sdf.parse(sdf.format(calendar.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Borrowings a = new Borrowings(1009, 0, deadline);
		ManageUsers.getBorrowingList().add(a);
		
		LibraryUI lol = new LibraryUI();
		lol.getFrame().setVisible(true);

	}

}
