import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManageUsersGUI {

	private JFrame frame;
	private JTable table;
	private ArrayList<Student> list = new ArrayList<Student>();

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
	 */
	public ManageUsersGUI(ArrayList<Student> lululu) {
		
		list = lululu;
		
		
		
		try {
			this.initialize();
			this.frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void startGUI(ArrayList<Student> lululu) {
		
		list = lululu;
		
		try {
			this.frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//initialize();
		
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Switch to Archive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		table = new JTable();
		DefaultTableModel dataModel = new DefaultTableModel(0, 0);
		
		
		String header[] = new String[] {"First Name", "Last Name", "UCID", "Borrowing", "Archive"};
		
		dataModel.setColumnIdentifiers(header);
		
		
		table.setModel(dataModel);
		
		dataModel.addRow(new Object[] {"F Name", "L Name", "UCID", "Borrowing", "Archive"});
		
		for (int x = 0; x <= list.size(); x++) {
	        dataModel.addRow(new Object[] {list.get(x).getFirstName(), list.get(x).getLastName(), list.get(x).getUcid(), list.get(x).getCurrentBorrowing(), "N" });
		}
		
		
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
	}
	
	
	public void createStudents() {
		
	}

}
