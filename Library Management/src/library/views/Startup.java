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
 * To be run at startup of system, to put users/materials, etc. in their proper arrays.
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
	 * Method to grab the user data from persistent storage and put in the correct data structures,
	 * to be run when the system starts up.
	 * 
	 * Code base taken from: https://www.programmergate.com/how-to-read-xml-file-in-java/
	 */
	public static void getXMLUserList() {
		// Make some local arrays to use below
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
			System.out.println("Something went wrong with the Users.xml parsing");
			System.out.println(e);
		}
		// Store our arrays so they are accessible elsewhere
		ManageUsers.setActiveList(activeList);
		ManageUsers.setArchiveList(archiveList);
	}
	
	
	/**
	 * Method to grab the materials data from persistent storage and put in the correct data structures,
	 * to be run when the system starts up.
	 * (Code base taken from above)
	 */
	public static void getXMLMaterials() {
		// Make some local array to use below
		ArrayList<Material> materialList = new ArrayList<Material>();
		try {
			File xmlFile = new File("Material.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document material = builder.parse(xmlFile);
			
		    NodeList materialNodes = material.getElementsByTagName("Material");
		    for(int i = 0; i < materialNodes.getLength(); i++) { // Go through each material node
		        Node materialNode = materialNodes.item(i);
		        if(materialNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element materialEl = (Element) materialNode;
		            
		            // Get the material's info (and convert types when necessary)
		            String type = materialEl.getElementsByTagName("type").item(0).getTextContent();
		            String name = materialEl.getElementsByTagName("name").item(0).getTextContent();
		            String id = materialEl.getElementsByTagName("id").item(0).getTextContent();
		            int ID = Integer.parseInt(id);
		            String isref = materialEl.getElementsByTagName("isRef").item(0).getTextContent();
		            boolean isRef = Boolean.parseBoolean(isref);
		            String avail = materialEl.getElementsByTagName("available").item(0).getTextContent();
		            int available = Integer.parseInt(avail);
		            String totinlib = materialEl.getElementsByTagName("totalInLib").item(0).getTextContent();
		            int totInLib = Integer.parseInt(totinlib);
		            
		            // Deal with it being a book subclass & store new instance in materialList
		            if(type == "Book") {
		            	String author = materialEl.getElementsByTagName("author").item(0).getTextContent();
		            	Book newBook = new Book(type, name, author, isRef, ID, totInLib, available);
		            	materialList.add(newBook);
		            } else {
		            	Material newMat = new Material(type, name, isRef, ID, totInLib, available);
		            	materialList.add(newMat);
		            }
		        }
		    }
		} catch (Exception e) {
			System.out.println("Something went wrong with the Material.xml parsing");
			System.out.println(e);
		}
		// Store our array so it is accessible elsewhere
		ManageUsers.setMaterialList(materialList);
	}

}