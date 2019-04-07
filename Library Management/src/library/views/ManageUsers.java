package library.views;

import java.util.ArrayList;

public class ManageUsers {

	private static ArrayList<Student> activeList = new ArrayList<Student>();
	private static ArrayList<Student> archiveList = new ArrayList<Student>();
	private static ArrayList<Material> materialList = new ArrayList<Material>();
	private static ArrayList<Borrowings> borrowingList = new ArrayList<Borrowings>();
	
	public static ArrayList<Borrowings> getBorrowingList() {
		return borrowingList;
	}


	public static void setBorrowingList(ArrayList<Borrowings> borrowingList) {
		ManageUsers.borrowingList = borrowingList;
	}


	public static ArrayList<Student> getActiveList() {
		return activeList;
	}


	public static void setActiveList(ArrayList<Student> activeList) {
		ManageUsers.activeList = activeList;
	}


	public static ArrayList<Student> getArchiveList() {
		return archiveList;
	}


	public static void setArchiveList(ArrayList<Student> archiveList) {
		ManageUsers.archiveList = archiveList;
	}
	
	public static ArrayList<Material> getMaterialList() {
		return materialList;
	}


	public static void setMaterialList(ArrayList<Material> materialList) {
		ManageUsers.materialList = materialList;
	}
	
	// initiate with fake users
	public ManageUsers(){
//		Student james = new Student("James", "Obama", 213, 23, true);
//		activeList.add(james);
//		Student bob = new Student("Bob", "Bobb", 123, 5, true);
//		activeList.add(bob);
//		Student sally = new Student("Sally", "Swings", 435, 3, true);
//		activeList.add(sally);
//		
//		
//		
//		Student tina = new Student("Tina", "Tyna", 2311, 5, false);
//		archiveList.add(tina);
//		Student michael = new Student("Michael", "Mann", 111, 3, false);
//		archiveList.add(michael);
	}

	

	
	
}
