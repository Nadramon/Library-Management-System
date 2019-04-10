package library.views;

/**
 * The main class of our function - run this one, and you can use the system.
 */
public class Main {
	public static ManageUsers students;
	
	public static void main(String[] args) {
		Startup.getXMLUserList();
		Startup.getXMLMaterials();
		
		Student ins = new Student ("Admin", "", 01, 0 , true, "admin", "admin",true);
		Student stu = new Student ("Student", "", 02, 6, true, "Student", "password", false);
		ManageUsers.getActiveList().add(ins);
		ManageUsers.getActiveList().add(stu);

		LibraryUI lol = new LibraryUI();
		lol.getFrame().setVisible(true);

	}

}
