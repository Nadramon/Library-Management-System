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

	private JFrame frame;
	private JTable table;
	private ArrayList<Student> activeList = new ArrayList<Student>();
	private ArrayList<Student> archiveList = new ArrayList<Student>();
	private JLabel lblActiveDatabase;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTable table_1;
	private JButton btnNewButton_1;
	private DefaultTableModel dataActive;
	private DefaultTableModel dataArchive;
	private ManageUsers user = new ManageUsers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ManageUsersGUI window = new ManageUsersGUI();
					//window.frame.setVisible(true);
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
			this.initialize();
			this.frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		dataActive = new DefaultTableModel(0, 0);
		
		
		String header[] = new String[] {"Number", "First Name", "Last Name", "UCID", "Borrowing"};
		
		dataActive.setColumnIdentifiers(header);
		
		dataActive.addRow(new Object[] {"No.", "F Name", "L Name", "UCID", "Borrowing"});
		
		for (int x = 0; x <= activeList.size() - 1; x++) {
			dataActive.addRow(new Object[] {x, activeList.get(x).getFirstName(), activeList.get(x).getLastName(), activeList.get(x).getUcid(), activeList.get(x).getCurrentBorrowing()});
		}
		
		lblActiveDatabase = new JLabel("Active Accounts");
		lblActiveDatabase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblActiveDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		
		table = new JTable();
		
		
		table.setModel(dataActive);
		
		btnNewButton = new JButton("Move to Archive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//activeList.clear();
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
				//dataActive.removeRow(0);
				//table.setModel(dataActive);
				
				
				String idS = JOptionPane.showInputDialog(frame, "Which No. would you like to move?", null);
				
				for (int x=0; x < archiveList.size(); x++) {
					dataArchive.removeRow(1);
				}
				
				for (int x=0; x < activeList.size(); x++) {
					dataActive.removeRow(1);
				}
				
				
				
				int id = Integer.parseInt(idS);
				
				archiveList.add(activeList.get(id));
				
				activeList.remove(activeList.get(id));
				
				
				for (int x = 0; x <= activeList.size() - 1; x++) {
					dataActive.addRow(new Object[] {x, activeList.get(x).getFirstName(), activeList.get(x).getLastName(), activeList.get(x).getUcid(), activeList.get(x).getCurrentBorrowing()});
				}
				
								
				
				
				
				
				table.setModel(dataActive);
				
				for (int x = 0; x <= archiveList.size() - 1; x++) {
					dataArchive.addRow(new Object[] {x, archiveList.get(x).getFirstName(), archiveList.get(x).getLastName(), archiveList.get(x).getUcid(), archiveList.get(x).getCurrentBorrowing()});
				}
				
				
				
				table_1.setModel(dataArchive);
				
			}
		});
		
		lblNewLabel = new JLabel("Archived Accounts");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		dataArchive = new DefaultTableModel(0, 0);

		
		dataArchive.setColumnIdentifiers(header);
		
		dataArchive.addRow(new Object[] {"No.", "F Name", "L Name", "UCID", "Borrowing"});
		
		for (int x = 0; x <= archiveList.size() - 1; x++) {
			dataArchive.addRow(new Object[] {x, archiveList.get(x).getFirstName(), archiveList.get(x).getLastName(), archiveList.get(x).getUcid(), archiveList.get(x).getCurrentBorrowing()});
		}
		
		
		
		
		
		
		
		
		
		table_1 = new JTable();
		table_1.setModel(dataArchive);
		
		btnNewButton_1 = new JButton("Move to Active");
		
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//activeList.clear();
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
				//dataActive.removeRow(0);
				//table.setModel(dataActive);
				
				
				String idS = JOptionPane.showInputDialog(frame, "Which No. would you like to move?", null);
				
				for (int x=0; x < archiveList.size(); x++) {
					dataArchive.removeRow(1);
				}
				
				for (int x=0; x < activeList.size(); x++) {
					dataActive.removeRow(1);
				}
				
				
				
				int id = Integer.parseInt(idS);
				
				activeList.add(archiveList.get(id));
				
				archiveList.remove(archiveList.get(id));
				
				for (int x = 0; x <= archiveList.size() - 1; x++) {
					dataArchive.addRow(new Object[] {x, archiveList.get(x).getFirstName(), archiveList.get(x).getLastName(), archiveList.get(x).getUcid(), archiveList.get(x).getCurrentBorrowing()});
				}
				
				
				
								
				
				table_1.setModel(dataArchive);
				
				
				
				
				for (int x = 0; x <= activeList.size() - 1; x++) {
					dataActive.addRow(new Object[] {x, activeList.get(x).getFirstName(), activeList.get(x).getLastName(), activeList.get(x).getUcid(), activeList.get(x).getCurrentBorrowing()});
				}
				
				
				table.setModel(dataActive);
				
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login(user);
				log.setVisible(true);
				frame.dispose();
				
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblActiveDatabase, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(24))
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addComponent(table_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblActiveDatabase, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(134))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	
	public void createStudents() {
		
	}
}
