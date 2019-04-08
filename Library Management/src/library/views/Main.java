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
		Material chair2 = new Material("Chair", "IKEA-2a1", true, 2);
		students.getMaterialList().add(chair2);
		Book percy = new Book("Book", "Percy Jackson", "Riordan", false, 3);
		students.getMaterialList().add(percy);
		Book ref = new Book("Book", "Maps of Africa", "Zinetti", true, 4);
		students.getMaterialList().add(ref);
		Material lap = new Material("Laptop", "Chromebook", true, 5);
		students.getMaterialList().add(lap);
		LibraryUI lol = new LibraryUI();
		lol.getFrame().setVisible(true);

	}

}