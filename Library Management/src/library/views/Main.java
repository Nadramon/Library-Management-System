package library.views;

public class Main {
	public static ManageUsers students;
	
	public static void main(String[] args) {
		Student ins = new Student ("Admin", "", 01, 0 , true, "admin", "admin",true);
		Student stu = new Student ("Student", "", 02, 6, true, "Student", "password", false);
		students.getActiveList().add(ins);
		students.getActiveList().add(stu);
		Book harry = new Book("Book", "Harry Potter", "Rowling", false, 0);
		students.getMaterialList().add(harry);
		Material chair = new Material("Chair", "IKEA-261", true, 1);
		students.getMaterialList().add(chair);
		LibraryUI lol = new LibraryUI();
		lol.getFrame().setVisible(true);

	}

}
