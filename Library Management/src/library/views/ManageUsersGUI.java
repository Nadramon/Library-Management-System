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
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

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
	private JTable table_2;
	private DefaultTableModel dataActive;
	private DefaultTableModel dataArchive;

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
		frame.setBounds(100, 100, 572, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		dataActive = new DefaultTableModel(0, 0);
		
		
		String header[] = new String[] {"Number", "First Name", "Last Name", "UCID", "Borrowing"};
		
		dataActive.setColumnIdentifiers(header);
		
		dataActive.addRow(new Object[] {"No.", "F Name", "L Name", "UCID", "Borrowing"});
		
		for (int x = 0; x <= activeList.size() - 1; x++) {
			dataActive.addRow(new Object[] {x, activeList.get(x).getFirstName(), activeList.get(x).getLastName(), activeList.get(x).getUcid(), activeList.get(x).getCurrentBorrowing()});
		}
		
		
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		lblActiveDatabase = new JLabel("Active Accounts");
		lblActiveDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblActiveDatabase);
		
		table = new JTable();
		
		
		table.setModel(dataActive);
		frame.getContentPane().add(table);
		
		btnNewButton = new JButton("Move to Archive");
		
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

		
		
		
		frame.getContentPane().add(btnNewButton);
		
		table_2 = new JTable();
		frame.getContentPane().add(table_2);
		
		lblNewLabel = new JLabel("Archived Accounts");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		dataArchive = new DefaultTableModel(0, 0);

		
		dataArchive.setColumnIdentifiers(header);
		
		dataArchive.addRow(new Object[] {"No.", "F Name", "L Name", "UCID", "Borrowing"});
		
		for (int x = 0; x <= archiveList.size() - 1; x++) {
			dataArchive.addRow(new Object[] {x, archiveList.get(x).getFirstName(), archiveList.get(x).getLastName(), archiveList.get(x).getUcid(), archiveList.get(x).getCurrentBorrowing()});
		}
		
		
		
		
		
		
		
		
		
		table_1 = new JTable();
		table_1.setModel(dataArchive);
		frame.getContentPane().add(table_1);
		
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
		
		
		
		frame.getContentPane().add(btnNewButton_1);
		
	}
	
	
	public void createStudents() {
		
	}

}
