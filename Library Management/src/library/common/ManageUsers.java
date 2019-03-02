package library.common;
import java.util.ArrayList;

public class ManageUsers {

	static ArrayList<Student> studentList = new ArrayList<Student>();
	
	
	
	public static void main(String[] args) {

		//make fake students
		Student james = new Student("James", "Obama", 213, 23, true);
		studentList.add(james);
		Student bob = new Student("Bob", "Bobb", 123, 5, true);
		studentList.add(bob);
		Student sally = new Student("Sally", "Swings", 435, 3, true);
		studentList.add(sally);
		
	
	}
	
	
	
	
}
