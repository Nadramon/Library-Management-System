import java.util.ArrayList;

public class ManageUsers {

	static ArrayList<Student> activeList = new ArrayList<Student>();
	static ArrayList<Student> archiveList = new ArrayList<Student>();
	
	
	public static void main(String[] args) {

		//make fake students
		Student james = new Student("James", "Obama", 213, 23, true);
		activeList.add(james);
		Student bob = new Student("Bob", "Bobb", 123, 5, true);
		activeList.add(bob);
		Student sally = new Student("Sally", "Swings", 435, 3, true);
		activeList.add(sally);
		
		
		
		Student tina = new Student("Tina", "Tyna", 2311, 5, false);
		archiveList.add(tina);
		Student michael = new Student("Michael", "Mann", 111, 3, false);
		archiveList.add(michael);
		
		
		
		ManageUsersGUI obama = new ManageUsersGUI(activeList, archiveList);
		//obama.startGUI(studentList);
		
	}
	
	
	
	
}
