package library.views;

public class Main {
	public static ManageUsers students;
	
	public static void main(String[] args) {
		Startup.getXMLUserList();
		
		Student ins = new Student ("Admin", "", 01, 0 , true, "admin", "admin",true);
		Student stu = new Student ("Student", "", 02, 6, true, "Student", "password", false);
		ManageUsers.getActiveList().add(ins);
		ManageUsers.getActiveList().add(stu);
		Book harry = new Book("Book", "Harry Potter", "Rowling", false, 0);
		ManageUsers.getMaterialList().add(harry);
		Material chair = new Material("Chair", "IKEA-261", true, 1);
		ManageUsers.getMaterialList().add(chair);
		Material chair2 = new Material("Chair", "IKEA-2a1", true, 2);
		ManageUsers.getMaterialList().add(chair2);
		Book percy = new Book("Book", "Percy Jackson", "Riordan", false, 3);
		ManageUsers.getMaterialList().add(percy);
		Book ref = new Book("Book", "Maps of Africa", "Zinetti", true, 4);
		ManageUsers.getMaterialList().add(ref);
		Material lap = new Material("Laptop", "Chromebook", true, 5);
		ManageUsers.getMaterialList().add(lap);
		LibraryUI lol = new LibraryUI();
		lol.getFrame().setVisible(true);

	}

}
