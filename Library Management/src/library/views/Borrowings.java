package library.views;

import java.util.Date;

/**
 * Class that keeps track of which students have which books, and when they're due
 *
 */
public class Borrowings {

	private int studentId;
	private int materialId;
	private Date due;
	
	

	public Borrowings(int stu, int mat, Date deadline) {
		studentId = stu;
		materialId = mat;
		due = deadline;
	}
	
	
	
	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public int getMaterialId() {
		return materialId;
	}



	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}



	public Date getDue() {
		return due;
	}



	public void setDue(Date due) {
		this.due = due;
	}



	
	
	
}
