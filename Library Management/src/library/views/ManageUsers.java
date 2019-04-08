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
	
	public ManageUsers(){

	}

	

	
	
}
