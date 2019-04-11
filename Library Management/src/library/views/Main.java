package library.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The main class of our function - run this one, and you can use the system.
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
//		Material kla = new Material("Book", " Chromebook", false, 1 ,1 ,1);
//		ManageUsers.getMaterialList().add(kla);
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
