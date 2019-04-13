package library.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The main class of our function - run this one, and you can use the entire system.
 */
public class Main {
	public static ManageUsers students;
	
	public static void main(String[] args) {
		Startup.getXMLUserList();
		Startup.getXMLMaterials();
		
		Student ins = new Student ("Admin", "", 01, 0 , true, "admin", "admin", true);
		Student stu = new Student ("Student", "", 02, 6, true, "Student", "password", false);
		ManageUsers.getActiveList().add(ins);
		ManageUsers.getActiveList().add(stu);

		
		//For testing the deadline overdue in returning a material
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		//calculate the deadline date
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 2, 23); // some random old date
		Date deadline = null;
		try {
			deadline = sdf.parse(sdf.format(calendar.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Borrowings a = new Borrowings(1009, 0, deadline);
		ManageUsers.getBorrowingList().add(a);
		
		LibraryUI lol = new LibraryUI();
		lol.getFrame().setVisible(true);

	}

}
