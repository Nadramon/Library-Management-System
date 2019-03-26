package library.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class ManageUsersGUI {

	private JFrame activeFrame;
	private JFrame archivedFrame;
	private JTable activeTable;
	private ArrayList<Student> activeList = new ArrayList<Student>();
	private ArrayList<Student> archiveList = new ArrayList<Student>();
	private JLabel activeLabel;
	private JButton moveToArchiveBtn;
	private JLabel archivedLabel;
	private JTable archivedTable;
	private JButton moveToActiveBtn;
	private DefaultTableModel dataActive;
	private DefaultTableModel dataArchive;
	private String[] header;
	
	private ManageUsers user = new ManageUsers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ManageUsersGUI window = new ManageUsersGUI();
					//window.activeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ManageUsersGUI(ArrayList<Student> active, ArrayList<Student> archive) {
		
		activeList = active;
		archiveList = archive;
		
		
		
		try {
			initActive();
			//this.initArchived();
			activeFrame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * initActive the contents of the activeFrame.
	 */
	private void initActive() {
		activeFrame = new JFrame();
		activeFrame.setBounds(100, 100, 587, 505);
		activeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		dataActive = new DefaultTableModel(0, 0);
		
		
		header = new String[] {"UCID", "First Name", "Last Name", "Borrowing"};
		
		dataActive.setColumnIdentifiers(header);
		
		dataActive.addRow(new Object[] {"UCID", "F Name", "L Name", "Borrowing"});
		
		for (int x = 0; x <= activeList.size() - 1; x++) {
			dataActive.addRow(new Object[] {activeList.get(x).getUcid(), activeList.get(x).getFirstName(), activeList.get(x).getLastName(), activeList.get(x).getCurrentBorrowing()});
		}
		
		activeLabel = new JLabel("Active Accounts");
		activeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		activeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		activeTable = new JTable();
		
		
		activeTable.setModel(dataActive);
		
		moveToArchiveBtn = new JButton("Move to Archive");
		moveToArchiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		moveToArchiveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				String idS = JOptionPane.showInputDialog(activeFrame, "Which person would you like to move? (Insert UCID)", null);
				boolean success = false;
				
				try {
					int id = Integer.parseInt(idS);
					int index = 0;
					for (int x = 0; x < activeList.size(); x++) {
						if (id == activeList.get(x).getUcid()) {
							index = x;
							success = true;
							break;
						}
						else {
							success = false;
						}
					}
					
					
					if (success) {
						
						for (int x=0; x < activeList.size(); x++) {
							dataActive.removeRow(1);
						}

						archiveList.add(activeList.get(index));
						activeList.remove(activeList.get(index));
						
						for (int x = 0; x <= activeList.size() - 1; x++) {
							dataActive.addRow(new Object[] {activeList.get(x).getUcid(), activeList.get(x).getFirstName(), activeList.get(x).getLastName(), activeList.get(x).getCurrentBorrowing()});
						}
						activeTable.setModel(dataActive);
					}
					else {
						JOptionPane.showMessageDialog(activeFrame, "That person does not exist in the Active Table!", "Error", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(activeFrame, "Please input a number", "Error", JOptionPane.ERROR_MESSAGE);
				}

				

				


				
			}
		});
		
		
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login(user);
				log.setVisible(true);
				activeFrame.dispose();
				archivedFrame.dispose();
				
			}
		});
		
		JButton switchBtn = new JButton("Switch Table");
		switchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				activeFrame.dispose();
				initArchived();
				archivedFrame.setVisible(true);
				
			}
		});
		
		JButton makeLibrarianBtn = new JButton("Make Librarian");
		makeLibrarianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentIdS = JOptionPane.showInputDialog(activeFrame, "Enter the Student ID to make a Librarian", null);

				try {
					int studentId = Integer.parseInt(studentIdS);
					
					boolean found = false;
					
					for (int x = 0; x <= activeList.size() - 1; x++) {
						if (studentId == activeList.get(x).getUcid()) {
							found = true;
							if(activeList.get(x).getIsLibrarian()) {
								String msg = activeList.get(x).getFirstName() + " is already a librarian!";
								JOptionPane.showMessageDialog(activeFrame, msg, "Error", JOptionPane.WARNING_MESSAGE);
							}
							else {
								activeList.get(x).setIsLibrarian(true);
								String msg = activeList.get(x).getFirstName() + " is now a librarian!";
								JOptionPane.showMessageDialog(activeFrame, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
							}
							break;
							
							
						}
					}
					
					if (!found) {
						JOptionPane.showMessageDialog(activeFrame, "That UCID does not exist in the active database!", "Error", JOptionPane.ERROR_MESSAGE);
					}


				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(activeFrame, "Please input a number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			
		});
				
		
		
		
		GroupLayout groupLayout = new GroupLayout(activeFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(activeLabel, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(24))
				//.addComponent(archivedLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addComponent(activeTable, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				//.addComponent(archivedTable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(switchBtn, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(moveToArchiveBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
					.addComponent(makeLibrarianBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
					.addComponent(backBtn)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(activeLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(activeTable, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					//.addComponent(archivedLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					//.addComponent(archivedTable, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(switchBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(moveToArchiveBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(makeLibrarianBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(backBtn))
					.addGap(134))
		);
		activeFrame.getContentPane().setLayout(groupLayout);
		
	}
	

	private void initArchived() {
		
		
		archivedFrame = new JFrame();
		archivedFrame.setBounds(100, 100, 587, 505);
		archivedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		archivedLabel = new JLabel("Archived Accounts");
		archivedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		archivedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		dataArchive = new DefaultTableModel(0, 0);

		
		dataArchive.setColumnIdentifiers(header);
		
		dataArchive.addRow(new Object[] {"UCID", "F Name", "L Name", "Borrowing"});
		
		for (int x = 0; x <= archiveList.size() - 1; x++) {
			dataArchive.addRow(new Object[] {archiveList.get(x).getUcid(), archiveList.get(x).getFirstName(), archiveList.get(x).getLastName(),  archiveList.get(x).getCurrentBorrowing()});
		}

		
		archivedTable = new JTable();
		archivedTable.setModel(dataArchive);
		
		moveToActiveBtn = new JButton("Move to Active");
		
		
		moveToActiveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String idS = JOptionPane.showInputDialog(archivedFrame, "Which person would you like to move? (Insert UCID)", null);
				boolean success = false;
				
				
				try {
					int id = Integer.parseInt(idS);
					int index = 0;
					
					for (int x = 0; x < archiveList.size(); x++) {
						if (id == archiveList.get(x).getUcid()) {
							index = x;
							success = true;
							break;
						}
						else {
							success = false;
						}
					}
					
					if (success) {
						for (int x=0; x < archiveList.size(); x++) {
							dataArchive.removeRow(1);
						}
						
						activeList.add(archiveList.get(index));
						archiveList.remove(archiveList.get(index));
						
						for (int x = 0; x <= archiveList.size() - 1; x++) {
							dataArchive.addRow(new Object[] {archiveList.get(x).getUcid(), archiveList.get(x).getFirstName(), archiveList.get(x).getLastName(), archiveList.get(x).getCurrentBorrowing()});
						}				
						archivedTable.setModel(dataArchive);
					}
					else {
						JOptionPane.showMessageDialog(archivedFrame, "That person does not exist in the Archived Table!", "Error", JOptionPane.WARNING_MESSAGE);
					}

				
				}

				catch (Exception exception) {
					JOptionPane.showMessageDialog(archivedFrame, "Please input a number", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
			
			
		});
		
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login(user);
				log.setVisible(true);
				activeFrame.dispose();
				archivedFrame.dispose();
				
			}
		});
		
		
		JButton switchBtn = new JButton("Switch Table");
		switchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivedFrame.dispose();
				initActive();
				activeFrame.setVisible(true);
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(archivedFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(archivedLabel, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(24))
				//.addComponent(archivedLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addComponent(archivedTable, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				//.addComponent(archivedTable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(switchBtn, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(moveToActiveBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
					.addComponent(backBtn)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(archivedLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(archivedTable, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					//.addComponent(archivedLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					//.addPreferredGap(ComponentPlacement.RELATED)
					//.addComponent(archivedTable, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(switchBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(moveToActiveBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(backBtn))
					.addGap(134))
		);
		
		
		archivedFrame.getContentPane().setLayout(groupLayout);
		
	}

}
	

