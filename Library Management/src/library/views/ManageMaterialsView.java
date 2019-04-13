package library.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class ManageMaterialsView {

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
	private Student stu;
	
	private ManageUsers user = new ManageUsers();
	
	
	public ManageMaterialsView(Student stud) {
		stu = stud;

		
		
		
		try {
			initActive(stud);
			activeFrame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * initActive the contents of the activeFrame.
	 */
	private void initActive(Student stud) {
		activeFrame = new JFrame();
		activeFrame.setBounds(100, 100, 587, 505);
		activeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		dataActive = new DefaultTableModel(0, 0);
		
		
		header = new String[] {"ID", "Type", "Name", "Total", "Available"};
		
		dataActive.setColumnIdentifiers(header);
		
		dataActive.addRow(new Object[] {"ID", "Type", "Name", "Total", "Available"});
		
		for (int x = 0; x <= ManageUsers.getMaterialList().size() - 1; x++) {
			dataActive.addRow(new Object[] {ManageUsers.getMaterialList().get(x).getID(), ManageUsers.getMaterialList().get(x).getType(), ManageUsers.getMaterialList().get(x).getName(), ManageUsers.getMaterialList().get(x).getTotalInLibrary(), ManageUsers.getMaterialList().get(x).getCountAvailable()});
		
		activeLabel = new JLabel("Materials");
		activeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		activeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		activeTable = new JTable();
		
		
		activeTable.setModel(dataActive);
		
		moveToArchiveBtn = new JButton("Delete Material");
		moveToArchiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String idS = JOptionPane.showInputDialog(activeFrame, "Which Material would you like to delete? (Input id)", null);
				boolean success = false;
				
				try {
					int id = Integer.parseInt(idS);
					int index = 0;
					for (int x = 0; x < ManageUsers.getMaterialList().size(); x++) {
						if (id == ManageUsers.getMaterialList().get(x).getID()) {
							index = x;
							success = true;
							break;
						}
						else {
							success = false;
						}
					}
					
					
					if (success) {
						
						//delete all rows except header
						for (int x=0; x < ManageUsers.getMaterialList().size(); x++) {
							dataActive.removeRow(1);
						}

						//remove the student from active and add to archive
						ManageUsers.getMaterialList().remove(index);
						
						//put every active dstudent on the table
						for (int x = 0; x <= ManageUsers.getMaterialList().size() - 1; x++) {
							dataActive.addRow(new Object[] {ManageUsers.getMaterialList().get(x).getID(), ManageUsers.getMaterialList().get(x).getType(), ManageUsers.getMaterialList().get(x).getName(), ManageUsers.getMaterialList().get(x).getTotalInLibrary(), ManageUsers.getMaterialList().get(x).getCountAvailable()});
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
		
		
		moveToActiveBtn = new JButton("Edit Material");
		moveToActiveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String idS = JOptionPane.showInputDialog(activeFrame, "Which Material would you like to edit?", null);
				String quantityS = JOptionPane.showInputDialog(activeFrame, "How many would you like to add on/remove? (Negatives for remove)", null);
				boolean success = false;
				
				try {
					int id = Integer.parseInt(idS);
					int quantity = Integer.parseInt(quantityS);
					int index = 0;
					for (int x = 0; x < ManageUsers.getMaterialList().size(); x++) {
						if (id == ManageUsers.getMaterialList().get(x).getID()) {
							index = x;
							success = true;
							break;
						}
						else {
							success = false;
						}
					}
					
					
					if (success) {
						
						//delete all rows except header
						for (int x=0; x < ManageUsers.getMaterialList().size(); x++) {
							dataActive.removeRow(1);
						}

						//remove the student from active and add to archive
						ManageUsers.getMaterialList().get(index).addItems(quantity);
						
						//put every active dstudent on the table
						for (int x = 0; x <= ManageUsers.getMaterialList().size() - 1; x++) {
							dataActive.addRow(new Object[] {ManageUsers.getMaterialList().get(x).getID(), ManageUsers.getMaterialList().get(x).getType(), ManageUsers.getMaterialList().get(x).getName(), ManageUsers.getMaterialList().get(x).getTotalInLibrary(), ManageUsers.getMaterialList().get(x).getCountAvailable()});
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
				Login log = new Login(stud, user);
				log.setVisible(true);
				activeFrame.dispose();
				
			}
		});
		
				
		
		//layout for the GUI for all the buttons and tables and labels
		
		GroupLayout groupLayout = new GroupLayout(activeFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(activeLabel, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(24))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(moveToActiveBtn, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(moveToArchiveBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					//.addComponent(makeLibrarianBtn, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					//.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(backBtn)
					.addContainerGap())
				.addComponent(activeTable, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(activeLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(activeTable, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(moveToActiveBtn, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(moveToArchiveBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						//.addComponent(makeLibrarianBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(backBtn))
					.addGap(134))
		);
		activeFrame.getContentPane().setLayout(groupLayout);
		
	}

	}
	
}
