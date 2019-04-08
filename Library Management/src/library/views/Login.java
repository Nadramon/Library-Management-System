/**
 * This view is what a librarian would see when they log in, It shows all the basic functionality a librarian would be able to do
 */

package library.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtSuccessfulLogin;
	private JButton btnManageUsers;
	private JButton btnBack;
    private JButton btnBorrowMaterial; 
    private JButton btnReturnMaterial;
    private JButton btnReviewOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Login frame = new Login();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login(ManageUsers users) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSuccessfulLogin = new JTextField();
		txtSuccessfulLogin.setText("SUCCESSFUL LOGIN");
		txtSuccessfulLogin.setColumns(10);
		
		btnManageUsers = new JButton("Manage Users");
		
		btnBack = new JButton("Back");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(txtSuccessfulLogin, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(btnManageUsers)
					.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(txtSuccessfulLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnManageUsers)
						.addComponent(btnBack))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		createEvents(users);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public Login(Student s, ManageUsers users) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        txtSuccessfulLogin = new JTextField();
        txtSuccessfulLogin.setText("Logged in as: " + s.getFirstName() + " " + s.getLastName() + ", current books: " + s.getCurrentBorrowing());
        txtSuccessfulLogin.setColumns(10);
        
        btnManageUsers = new JButton("Manage Users");
        
        btnBack = new JButton("Back");
        
        btnBorrowMaterial = new JButton("Borrow material");
        
        btnReturnMaterial = new JButton("Return Material");
        
        btnReviewOrder = new JButton("Review Order");
        
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addComponent(txtSuccessfulLogin, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addContainerGap(332, Short.MAX_VALUE)
        			.addComponent(btnBack)
        			.addGap(37))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(btnManageUsers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnBorrowMaterial, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(313, Short.MAX_VALUE))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnReviewOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(307))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnReturnMaterial)
        			.addContainerGap(307, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(txtSuccessfulLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(btnManageUsers)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnBorrowMaterial)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnReturnMaterial)
        			.addGap(13)
        			.addComponent(btnReviewOrder)
        			.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
        			.addComponent(btnBack)
        			.addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        createEvents(users);
    }
	
	// create events
	private void createEvents(ManageUsers users) {
		/*
		 * This method sets up a button in order to open the ManageUsersGUI
		 */
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ArrayList<Student> archiveList = users.getArchiveList();
			ArrayList<Student> activeList = users.getActiveList();
			ManageUsersGUI manageUsers = new ManageUsersGUI(activeList, archiveList);
			dispose();
			}
		});
		
		/*
		 * This method goes back to the previous menu
		 */
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryUI lib = new LibraryUI();
				lib.getFrame().setVisible(true);
				dispose();
			}
		});
		
		//For borrowing materials, when the button is clicked, dialog boxes will pop up to inquire for IDs
		btnBorrowMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String materialIdS = JOptionPane.showInputDialog(contentPane, "Enter the Material ID to lend:", null);
				String studentIdS = JOptionPane.showInputDialog(contentPane, "Enter the Student ID it is for:", null);
				int studentIndex = 999;
				boolean success = false;
				try {
					int materialId = Integer.parseInt(materialIdS);
					int studentId = Integer.parseInt(studentIdS);
					
					//for loop to iterate to check if exists or not
					//loop through available save file
					
					for (int z = 0; z < users.getMaterialList().size(); z++) {
						if (users.getMaterialList().get(z).getID() == materialId) {
							if (!users.getMaterialList().get(z).isAReferenceMaterial()) {
								if (users.getMaterialList().get(z).getCountAvailable() > 0) {
									success = true;
									break;
								}
							}
						}
					}
					
					if(success) {
						
						//first: check if student has less than 5 borrowings
						//find student by id in save file, check borrowings value
						for (int x = 0; x < users.getActiveList().size(); x++) {
							if (users.getActiveList().get(x).getUcid() == studentId) {
								studentIndex = x;
								if (5 <= users.getActiveList().get(x).getCurrentBorrowing()) {
									success = false;
								}
								break;
							}
						}
						
						System.out.println("pass student check");
						
						//check if available in library
						if(success) {
							
							users.getMaterialList().get(materialId).setCountAvailable(-1);
							//For working with dates formats
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							
							//calculate the deadline date
							Date currentDate = new Date();
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(currentDate);
							calendar.add(Calendar.DATE, 14);
							Date deadline = sdf.parse(sdf.format(calendar.getTime()));
							
							System.out.println("date shit");
							
							Borrowings borrowerData = new Borrowings(studentId, materialId, deadline);
							users.getBorrowingList().add(borrowerData);
							System.out.println("borrowing class");
							users.getActiveList().get(studentIndex).setCurrentBorrowing(1);
							System.out.println("set student borrow");
							String msg = users.getMaterialList().get(materialId).getName() + " has been lent out to " + users.getActiveList().get(studentIndex).getFirstName();
							System.out.println("calc mesg");
							JOptionPane.showMessageDialog(contentPane, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
							
							System.out.println("finit");
							
							
						}
						
						else {
							JOptionPane.showMessageDialog(contentPane, "The student has reached the limit for borrowing books!", "Error", JOptionPane.WARNING_MESSAGE);
						}
						
						
						
					}
					
					else {
						
						JOptionPane.showMessageDialog(contentPane, "That material does not exist, or is a reference, or is not available at the moment!", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(contentPane, "Please input a number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			
		});
		
		
		//The button for returning materials, when clicked will inquire user to input ID
		btnReturnMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String materialIdS = JOptionPane.showInputDialog(contentPane, "Enter the Material ID to lend:", null);
				String studentIdS = JOptionPane.showInputDialog(contentPane, "Enter the Student ID it is for:", null);
				int studentIndex = 999;
				boolean success = false;
				try {
					int materialId = Integer.parseInt(materialIdS);
					int studentId = Integer.parseInt(studentIdS);
					Date deadline = new Date();
					Date currentDate = new Date();
					String msg = "";
					
					//getting rid of it from student
					
					for (int x = 0; x < users.getBorrowingList().size(); x++) {
						if (users.getBorrowingList().get(x).getMaterialId() == materialId) {
							if (users.getBorrowingList().get(x).getStudentId() == studentId) {
								deadline = users.getBorrowingList().get(x).getDue();
								
								users.getMaterialList().get(materialId).setCountAvailable(1);
								for (int y = 0; y < users.getActiveList().size(); x++) {
									if (users.getActiveList().get(y).getUcid() == studentId) {
										users.getActiveList().get(y).setCurrentBorrowing(-1);
										break;
									}
								}
								msg = 	users.getMaterialList().get(materialId).getName() + " has been returned!";	
								success = true;
								
								users.getBorrowingList().remove(x);
								break;
									
							}
						}
					}
					
					if (success) {
						JOptionPane.showMessageDialog(contentPane, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
					}


					
					else {
						
						JOptionPane.showMessageDialog(contentPane, "That material is not being borrowed right now!", "Error", JOptionPane.WARNING_MESSAGE);
					}
					
					
					if(currentDate.after(deadline)) {
						String text = "The material was overdue.\nCurrent Date: " + currentDate.toString() + "\nDue Date: " + deadline.toString();
						JOptionPane.showMessageDialog(contentPane, text, "Error", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(contentPane, "Please input a number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
			
		});
		
	

		
	}
}
