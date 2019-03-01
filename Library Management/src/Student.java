
public class Student {

	
	private String 	firstName			= "";
	private String 	lastName			= "";
	private int		ucid				= 0;
	private int		currentBorrowing	= 0;
	private boolean	isActive			= true;
	
	
	public Student(String fn, String ln, int id, int cb, boolean ia){
		
		firstName 			= fn;
		lastName			= ln;
		ucid				= id;
		currentBorrowing	= cb;
		isActive			= ia;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getUcid() {
		return ucid;
	}


	public void setUcid(int ucid) {
		this.ucid = ucid;
	}


	public int getCurrentBorrowing() {
		return currentBorrowing;
	}


	public void setCurrentBorrowing(int currentBorrowing) {
		this.currentBorrowing = currentBorrowing;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
}
