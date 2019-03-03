package library.views;
import java.util.ArrayList;

public class ManageUsers {

	private ArrayList<Student> studentList;
	
	public ManageUsers(){
		studentList = new ArrayList<Student>();
		Student james = new Student("James", "Obama", 213, 23, true);
		studentList.add(james);
		Student bob = new Student("Bob", "Bobb", 123, 5, true);
		studentList.add(bob);
		Student sally = new Student("Sally", "Swings", 435, 3, true);
		studentList.add(sally);
	}
	
	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	
	public void addStudent(Student name) {
		studentList.add(name);
		
	}
	
//	public static void main(String[] args) {
//
//		//make fake students
//		Student james = new Student("James", "Obama", 213, 23, true);
//		studentList.add(james);
//		Student bob = new Student("Bob", "Bobb", 123, 5, true);
//		studentList.add(bob);
//		Student sally = new Student("Sally", "Swings", 435, 3, true);
//		studentList.add(sally);
//		
//	
//	}
	
	
	
	
}
