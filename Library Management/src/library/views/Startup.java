package library.views;
import java.io.File;
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
		getActiveList();

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
	private static void getActiveList() {
		try {
			File xmlFile = new File("activeList.xml");
			System.out.println("xmlFile created");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			System.out.println("factory created");
			DocumentBuilder builder = factory.newDocumentBuilder();
			System.out.println("builder created");
			Document actLst = builder.parse(xmlFile);
			System.out.println("actLst created");
			
		    NodeList studentNodes = actLst.getElementsByTagName("student");
		    for(int i=0; i<studentNodes.getLength(); i++)
		    {
		        Node studentNode = studentNodes.item(i);
		        if(studentNode.getNodeType() == Node.ELEMENT_NODE)
		        {
		            Element studentElement = (Element) studentNode;
		            String studentId = studentElement.getElementsByTagName("ucid").item(0).getTextContent();
		            String studentName = studentElement.getElementsByTagName("username").item(0).getTextContent();
		            System.out.println("Student Id = " + studentId);
		            System.out.println("Student Name = " + studentName);
		        }
		    }
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong with the activeList.xml parsing");
		}
	}

}