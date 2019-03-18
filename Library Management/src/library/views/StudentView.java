package library.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTextField welcomeTxt;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	StudentView frame = new StudentView();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentView(Student s, ManageUsers users) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSearchForBook = new JButton("Search for Book");
		
		JButton btnSearchForMaterial = new JButton("Search/Order for Material");
		btnSearchForMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		
		welcomeTxt = new JTextField();
		welcomeTxt.setColumns(10);
		welcomeTxt.setText("Logged in as: " + s.getFirstName() + " " + s.getLastName() + ", current books: " + s.getCurrentBorrowing());
		
		btnBack = new JButton("Back");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeTxt, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(246)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearchForMaterial, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addComponent(btnSearchForBook, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addComponent(btnBorrowBook, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(314, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(21))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSearchForBook)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearchForMaterial)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBorrowBook)
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryUI lib = new LibraryUI();
				lib.getFrame().setVisible(true);
				dispose();
			}
		});
	}
	
}
