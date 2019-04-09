package library.views;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * @author Britta Den Hoed
 * 
 * To be run at startup of system, to put users, materials, etc. in their proper arrays.
 */
public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getXMLUserList();

	}
	
	/**
	 * Method to grab the data from persistent storage and put in the correct data structures,
	 * to be run when the system starts up.
	 */
	public static void startup() {
		// Read a person from activeList.xml
		// Construct a Student from that
		// Add them to activeList array
		// Loop through the other students
		
		// And continue for the other files...
	}
	
	/**
	 * Method to grab the data from persistent storage and put in the correct data structures,
	 * to be run when the system starts up.
	 * 
	 * Code base taken from: https://www.programmergate.com/how-to-read-xml-file-in-java/
	 */
	public static void getXMLUserList() {
		ArrayList<Student> activeList = new ArrayList<Student>();
		ArrayList<Student> archiveList = new ArrayList<Student>();
		try {
			File xmlFile = new File("Users.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document users = builder.parse(xmlFile);
			
		    NodeList studentNodes = users.getElementsByTagName("student");
		    for(int i = 0; i < studentNodes.getLength(); i++) { // Go through each student node
		        Node studentNode = studentNodes.item(i);
		        if(studentNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element studentEl = (Element) studentNode;
		            // Get the student's info (and convert types when necessary)
		            String fn = studentEl.getElementsByTagName("firstName").item(0).getTextContent();
		            String ln = studentEl.getElementsByTagName("lastName").item(0).getTextContent();
		            String id = studentEl.getElementsByTagName("ucid").item(0).getTextContent();
		            int ucid = Integer.parseInt(id);
		            String cB = studentEl.getElementsByTagName("currentBorrowing").item(0).getTextContent();
		            int cb = Integer.parseInt(cB);
		            String iA = studentEl.getElementsByTagName("isActive").item(0).getTextContent();
		            boolean ia = Boolean.parseBoolean(iA);
		            String username = studentEl.getElementsByTagName("username").item(0).getTextContent();
		            String pW = studentEl.getElementsByTagName("password").item(0).getTextContent();
		            String iL = studentEl.getElementsByTagName("isLibrarian").item(0).getTextContent();
		            boolean isLib = Boolean.parseBoolean(iL);
		            
		            // And then create all a new instance of Student with the info
			        Student newStudent = new Student(fn, ln, ucid, cb, ia, username, pW, isLib);
			        // Put the newly created student in the right list
			        if(ia) {
			        	activeList.add(newStudent);
			        } else {
			        	archiveList.add(newStudent);
			        }
		        }
		    }
		} catch (Exception e) {
			System.out.println("Something went wrong with the activeList.xml parsing");
			System.out.println(e);
		}
		// Store our arrays so they are accessible elsewhere
		ManageUsers.setActiveList(activeList);
		ManageUsers.setArchiveList(archiveList);
	}

}